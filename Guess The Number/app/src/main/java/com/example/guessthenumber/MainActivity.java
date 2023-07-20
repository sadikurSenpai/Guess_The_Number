package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button1:

                Intent gn=new Intent(this,GuessTheNumber.class);startActivity(gn);
                break;
            case R.id.button2:
                Intent hp=new Intent(this,HowToPlay.class);
                startActivity(hp);
                break;
            case R.id.button3:
            Intent profile=new Intent(this,developers_profile.class);
            startActivity(profile);
                break;

        }
    }
}