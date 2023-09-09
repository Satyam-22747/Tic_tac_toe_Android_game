package com.satdroid.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class TicTacToeSplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent iHome=new Intent(TicTacToeSplash.this, MainActivity.class);
                startActivity(iHome);
                finish();
            }
        },2000);

    }
}