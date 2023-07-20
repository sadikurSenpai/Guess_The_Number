package com.example.guessthenumber;

import static com.example.guessthenumber.R.*;

import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GuessTheNumber extends AppCompatActivity{
    private Button bu;
    private TextView t;
    private EditText e;
    private int count=0;
    private int flag=-1;
    private long n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.guess_the_number);
        n=new Random().nextInt(99)+1;
        bu=findViewById(id.button);
        t=findViewById(id.resultText);
        e=findViewById(id.editTextNumber);
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num=e.getText().toString();
                if(bu.getText()=="Reset"){
                    e.setText("");
                    bu.setText("Enter");
                    t.setText("");
                    e.setEnabled(true);
                    count=0;
                    flag=0;
                    e.setFilters(new InputFilter[] {new InputFilter.LengthFilter(7)});
                }
                if(num.isEmpty()){
                   if(flag==-1)
                    t.setText("You didn't enter.");
                   flag=-1;
                }
                else{
                    long number=Integer.parseInt(num);
               if(number>100 ||number<1){
                    t.setText("Please enter a number between 1 to 100");
                    e.setText("");
                }
                else if(number==n){

                   MediaPlayer mp=MediaPlayer.create(GuessTheNumber.this, raw.winningsound);
                    mp.start();
                    count++;
                    t.setText("    Congratulations !! \n"+"You needed "+count+" steps.");e.setText("");
                    e.setEnabled(false);
                   bu.setText("Reset");
                   n=new Random().nextInt(99)+1;
                }
                else if( (number-n)>20 ){
                    t.setText("Not even close. Way too big. Try entering a smaller number.");count++;
                   e.setText("");
                }
                else if((number-n)<=20 && (number-n)>0 ){
                    t.setText("Close. Enter a little bit smaller number. ");count++;
                   e.setText("");
                   e.setText("");
                }
                else if( (number-n)>=-20 && (number-n)<0){
                    t.setText("Close. Enter a little bit bigger number.");count++;
                   e.setText("");
                }
                else if( (number-n)<-20 ){
                    t.setText("Not even close. Way too small. Try entering a bigger number.");count++;
                   e.setText("");
                }

            }
            }
        });
    }
}
