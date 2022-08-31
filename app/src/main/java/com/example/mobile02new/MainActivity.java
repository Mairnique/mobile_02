package com.example.mobile02new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer player;
    Button incrementButton;
    TextView greetingDisplay;
    int count = 0;
    String[] planets;
    RadioButton leftRadBut, rightRadBut;
    EditText enterName;
    TextView nameDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        TextView textView = new TextView(this);
//        textView.setText(R.string.greet_dad);
        setContentView(R.layout.activity_main);
        incrementButton = findViewById(R.id.increment_button);
        greetingDisplay = findViewById(R.id.greeting_textview);
        planets = getResources().getStringArray(R.array.planets_array);
        leftRadBut = findViewById(R.id.radio_left);
        rightRadBut = findViewById(R.id.radio_right);
        enterName = findViewById(R.id.plain_text_input);
        nameDisplay = findViewById(R.id.name_textview);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                System.out.println("incrementing: " + ++count);
//                Log.i("incrementing", "" + count);
//                greetingDisplay.setText(getString(R.string.likes_count, count));
                if (rightRadBut.isChecked())
                    count =  ++count % planets.length;
                greetingDisplay.setText(planets[count]);
            }
        });

    }

    public void decrement(View view) {
//        System.out.println("incrementing: " + --count);
//        Log.i("incrementing", "" + count);
//        greetingDisplay.setText(getString(R.string.likes_count, count));
        if (leftRadBut.isChecked())
            if (--count < 0) count = planets.length - 1;
        greetingDisplay.setText(planets[count]);
    }


    public void submit_name(View view) {
        nameDisplay.setText(enterName.getText());
    }
}