package com.satdroid.tictactoe;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.res.ResourcesCompat;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    AppCompatButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,btn10,btn11;
    TextView winnerName, currentplayer;
    int flag = 0, count = 0;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private static final String CHANNEL_ID="My Channel";
    private static final int NOTIFICATION_ID=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder newGame=new AlertDialog.Builder(MainActivity.this);
                newGame.setTitle("New Game");
                newGame.setIcon(R.drawable.baseline_fiber_new_24);
                newGame.setMessage("Are you sure?");
                newGame.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        resetButton();
                    }
                });

                newGame.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                newGame.show();
                //resetButton();
            }
        });



    }
    private void init()
    {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn11=findViewById(R.id.btn11);
        currentplayer=findViewById(R.id.CurrentPlayer);
        currentplayer.setText("Player X turn");
    }
    public void Check(View view) {
        AppCompatButton btncurrent = (AppCompatButton) view;
        if (btncurrent.getText().toString().equals("")) {
            count++;
            if (flag == 0) {
                btncurrent.setText("X");
                currentplayer.setText("Player O turn");
                flag = 1;
            } else {
                btncurrent.setText("O");
                currentplayer.setText("Player X turn");
                flag = 0;
            }
            if (count > 4) {
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();
                if (b1.equals(b2) && b2.equals(b3) && !b1.equals(""))
                {
                    Newbutton(b1);

                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals(""))
                {
                    Newbutton(b4);

                } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {

                    Newbutton(b7);


                } else if (b1.equals(b4) && b4.equals(b7) && !b4.equals("")) {

                    Newbutton(b1);

                } else if (b8.equals(b5) && b2.equals(b5) && !b8.equals("")) {

                    Newbutton(b8);

                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {

                    Newbutton(b3);

                } else if (b1.equals(b5) && b5.equals(b9) && !b5.equals("")) {
                    Newbutton(b1);

                } else if (b3.equals(b5) && b5.equals(b7) && !b5.equals("")) {

                    Newbutton(b3);

                } else if(count==9)
                {
                    AlertDialog.Builder newGame=new AlertDialog.Builder(MainActivity.this);
                    newGame.setTitle("Game Draw");
                    newGame.setIcon(R.drawable.baseline_fiber_new_24);
                    newGame.setMessage("New Game ?");
                    newGame.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            resetButton();
                        }
                    });

                    newGame.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    newGame.show();
                }
            }
        }
    }
    public void resetButton()
    {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        flag = 0;
        count = 0;
        currentplayer.setText("Player X turn");
    }
    public void newgame() {
       // Toast.makeText(this, "Game Over", Toast.LENGTH_SHORT).show();
        Dialog dialog=new Dialog(MainActivity.this );
        dialog.setContentView(R.layout.winner_dialog);
        btn10= dialog.findViewById(R.id.btn10);
        winnerName=dialog.findViewById(R.id.winnerName);
        winnerName.setText("Game  Draw");
        dialog.show();
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                resetButton();
                currentplayer.setText("Player X turn");
                dialog.dismiss();
            }
        });
    }
    public void Newbutton(String btn)
    {
        AlertDialog.Builder newGame=new AlertDialog.Builder(MainActivity.this);
        newGame.setTitle(btn+" Won");
        newGame.setIcon(R.drawable.baseline_fiber_new_24);
        newGame.setMessage("New Game ?");
        newGame.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                resetButton();
            }
        });

        newGame.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        newGame.show();

    }
}


