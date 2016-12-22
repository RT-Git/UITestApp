package com.wordpress.obliviouscode.uitestapp;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {


    private CardView cardView;
    private int i =0;
    private boolean isButtonClicked=false;
    private boolean isQuestionClicked=false;
    private RelativeLayout rel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rel = (RelativeLayout) findViewById(R.id.dim_layout);
        cardView = (CardView) (findViewById(R.id.card));

        final Button b = (Button) findViewById(R.id.qbutton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isQuestionClicked=!isQuestionClicked;
                if(isQuestionClicked) {
                    rel.setVisibility(View.VISIBLE);
                    cardView.setVisibility(View.VISIBLE);
                    b.setText("Tap to collapse Question");
                }

                else{
                    rel.setVisibility(View.INVISIBLE);
                    cardView.setVisibility(View.INVISIBLE);
                    b.setText("This is a question. Tap on it to expand it.");
                }
            }
        });
    }

    public void didTapButton(View view) {
        Button button = (Button) findViewById(R.id.button);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);


        isButtonClicked=!isButtonClicked;
        view.setBackgroundResource(isButtonClicked?R.drawable.hearts_on:R.drawable.hearts_off);
        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);
    }

    public void onQClick(View v){


    }
}
