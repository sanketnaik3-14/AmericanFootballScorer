package com.example.sanket.americanfootballscorer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class MainActivity extends AppCompatActivity {

    int teamAScore = 0;
    int teamBScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* THis function displays Team A score in textView */
    public void displayTeamAScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /* This function adds one point to Team A score in textView */
    public void addOneToA(View v) {
        teamAScore = teamAScore + 1;
        displayTeamAScore(teamAScore);
        displayImageA();
        playCheerA();
    }

    /* This function adds two points to Team A score in textView */
    public void addTwoToA(View v) {
        teamAScore = teamAScore + 2;
        displayTeamAScore(teamAScore);
        playCheerA();
        displayImageA();
    }

    /* This function adds three points to Team A score in textView */
    public void addThreeToA(View v) {
        teamAScore = teamAScore + 3;
        displayTeamAScore(teamAScore);
        playCheerA();
        displayImageA();
    }

    /* This function adds six points to Team A score in textView */
    public void addSixToA(View v) {
        teamAScore = teamAScore + 6;
        displayTeamAScore(teamAScore);
        playCheerA();
        displayImageA();
    }


    /* THis function displays Team A score in textView */
    public void displayTeamBScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /* This function adds one point to Team B score in textView */
    public void addOneToB(View v) {
        teamBScore = teamBScore + 1;
        displayTeamBScore(teamBScore);
        playCheerB();
        displayImageB();
    }

    /* This function adds two points to Team B score in textView */
    public void addTwoToB(View v) {
        teamBScore = teamBScore + 2;
        displayTeamBScore(teamBScore);
        playCheerB();
        displayImageB();
    }

    /* This function adds three points to Team B score in textView */
    public void addThreeToB(View v) {
        teamBScore = teamBScore + 3;
        displayTeamBScore(teamBScore);
        playCheerB();
        displayImageB();
    }

    /* This function adds six points to Team B score in textView */
    public void addSixToB(View v) {
        teamBScore = teamBScore + 6;
        displayTeamBScore(teamBScore);
        playCheerB();
        displayImageB();
    }

    /* This function resets both team scores to zero */
    public void reset(View v) {
        playGameEnd();
        teamAScore = 0;
        teamBScore = 0;
        displayTeamAScore(teamAScore);
        displayTeamBScore(teamBScore);
    }


    /* This function plays cheering sound effect when Team A scores any of the 4 valid points */
    public void playCheerA() {
        MediaPlayer mediaPlayer1 = MediaPlayer.create(this , R.raw.cheer);
        mediaPlayer1.start();
    }

    /* This function plays cheering sound effect when Team B scores any of the 4 valid points */
    public void playCheerB() {
        MediaPlayer mediaPlayer2 = MediaPlayer.create(this , R.raw.whoohoo);
        mediaPlayer2.start();
    }

    /* This function plays applause sound effect when the Game is reset */
    public void playGameEnd() {
        MediaPlayer mediaPlayer3 = MediaPlayer.create(this , R.raw.applause);
        mediaPlayer3.start();
    }


    /* This function displays a gif image in imageview everytime Team A scores any of the 4 valid points */
    public void displayImageA() {

        final ImageView cheerImageA = (ImageView) findViewById(R.id.team_a_cheer);
        new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Glide
                        .with(getApplicationContext())
                        .load(R.drawable.cheeraimage)
                        .asGif()
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .into(cheerImageA);

                cheerImageA.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFinish() {
                cheerImageA.setVisibility(View.GONE);
            }
        }.start();

    }

    /* This function displays a gif image in imageview everytime Team B scores any of the 4 valid points */
    public void displayImageB() {

        final ImageView cheerImageB = (ImageView) findViewById(R.id.team_b_cheer);
        new CountDownTimer(2500, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                Glide
                        .with(getApplicationContext())
                        .load(R.drawable.cheerbimage)
                        .asGif()
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .into(cheerImageB);

                cheerImageB.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFinish() {
                cheerImageB.setVisibility(View.GONE);
            }

        }.start();

    }

}
