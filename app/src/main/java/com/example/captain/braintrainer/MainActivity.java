package com.example.captain.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
      TextView timerTextView;
      TextView queTextView;
      TextView sumTextView;
      TextView textView;
      TextView finalScore;
      Button button1;
      Button button2;
      Button button3;
      Button button4;
      Button playAgain;
      LinearLayout linearLayout;
      Button go;
      RelativeLayout relativeLayout;
      RelativeLayout lastRelative;

     int num = 0;
      int x;
      int y;
      int ans;
    int locationOfCorrectAnswer = 0;
    int score =0;
    int time;

    public void go(View view)
    {
        go.setVisibility(View.INVISIBLE);
        lastRelative.setVisibility(View.INVISIBLE);
    }

    public void getQuestions()
    {
        if(num <=31 && time>1 ) {
            num++;

            queTextView.setText(Integer.toString(score)+"/"+Integer.toString(num));
            ArrayList<Integer> answers = new ArrayList<Integer>();


            int x = new Random().nextInt(10);
            Log.i("x", x+" ");
            int y = new Random().nextInt(10);
            Log.i("y",  y + " ");
            int ans = x+y;
            Log.i("ans", ans + " ");

            sumTextView.setText(x+" + "+y);

            int random = new Random().nextInt(4) + 1;
            locationOfCorrectAnswer = random;


            for(int i=1 ; i<=4 ; i++)
            {
                if(i == locationOfCorrectAnswer)
                    answers.add(ans);
                else
                    answers.add(new Random().nextInt(20)+21);
            }
            button1.setText(Integer.toString(answers.get(0)));
            button2.setText(Integer.toString(answers.get(1)));
            button3.setText(Integer.toString(answers.get(2)));
            button4.setText(Integer.toString(answers.get(3)));




        }


    }

    public void options(View view)
      {
          if(num <=31 && time>1 ) {

              if (view.getTag().equals(Integer.toString(locationOfCorrectAnswer))) {
                  score++;
                  textView.setText("GENIUS HUH!");
              } else
                  textView.setText("OOPS");

              getQuestions();
          }


      }

      public void playAgain(View view)
      {

          score = 0;
          num=0;
          locationOfCorrectAnswer = 0;
          queTextView.setText("0/0");
          timerTextView.setText("30s");
          linearLayout.setVisibility(View.GONE);
          textView.setVisibility(View.VISIBLE);
          playAgain.setVisibility(View.INVISIBLE);
          finalScore.setVisibility(View.INVISIBLE);


          new CountDownTimer(30000,1000)
          {

              @Override
              public void onTick(long millisUntilFinished) {
                  time = (int)millisUntilFinished/1000;

                  timerTextView.setText((int)millisUntilFinished/1000 +"s");
              }

              @Override
              public void onFinish() {
                  textView.setVisibility(View.INVISIBLE);
                  finalScore.setText(Integer.toString(score)+"/"+Integer.toString(num));
                  linearLayout.setVisibility(View.VISIBLE);
                  playAgain.setVisibility(View.VISIBLE);
                  finalScore.setVisibility(View.VISIBLE);



              }

          }.start();



      }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queTextView = (TextView)findViewById(R.id.queTextView);
        textView = (TextView)findViewById(R.id.textView);
        timerTextView = (TextView)findViewById(R.id.timerTextView);
        sumTextView = (TextView)findViewById(R.id.sumTextView);
        finalScore = (TextView)findViewById(R.id.finalScore);
        linearLayout = (LinearLayout)findViewById(R.id.linearLayout);

        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        playAgain = (Button)findViewById(R.id.playAgain);
        go = (Button)findViewById(R.id.button5);
        relativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout);
        lastRelative = (RelativeLayout)findViewById(R.id.lastRelative);

        getQuestions();

        playAgain(findViewById(R.id.playAgain));







    }
}
