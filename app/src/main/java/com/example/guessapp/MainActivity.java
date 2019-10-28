package com.example.guessapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String TAG = MainActivity.class.getSimpleName();
    int secert = new Random().nextInt(10)+1;
    private EditText number;
    private TextView hint;
    private ImageView result;
    int c;
    private TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        number = findViewById(R.id.num);
        hint = findViewById(R.id.hint);
        result = findViewById(R.id.result);
        time = findViewById(R.id.time);
        c = 5;
        Log.d(TAG,"SECRET:"+secert);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void enter(View view){
        c--;
        int guessnum = Integer.parseInt(number.getText().toString());
        result.setAlpha(1.0f);
        result.setVisibility(View.VISIBLE);
        if(guessnum < secert){
            hint.setText("bigger");
            result.setImageResource(R.drawable.up);
        }else if(guessnum > secert){
            hint.setText("smaller");
            result.setImageResource(R.drawable.down);
        }else {
            hint.setText("bingo, the secret number is: "+secert);
            result.setImageResource(R.drawable.cat);
            Toast.makeText(MainActivity.this, "you so good", Toast.LENGTH_LONG).show();
        }
        if(c < 5 || c > 0){
            time.setText("remaining times: " +c);
        }else{
            time.setText("game over!!!!!!!!!");
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
