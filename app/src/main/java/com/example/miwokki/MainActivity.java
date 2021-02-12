package com.example.miwokki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView numbers = (TextView)findViewById(R.id.numbers);
        TextView family = (TextView)findViewById(R.id.family);
        TextView  colors =(TextView)findViewById(R.id.colors);
        TextView Phases = (TextView)findViewById(R.id.phrases);
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent numbersIntent = new Intent(MainActivity.this,NumberActivity.class);
               startActivity(numbersIntent);
            }
        });

        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent familyIntent = new Intent(MainActivity.this,FamilityActivity.class);
                startActivity(familyIntent);
            }
        });

        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent colorIntent = new Intent(MainActivity.this,ColorsActivity.class);
                startActivity(colorIntent);
            }
        });

        Phases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phrasesIntent = new Intent(MainActivity.this,PhasesActivity.class);
                startActivity(phrasesIntent);
            }
        });

    }

}