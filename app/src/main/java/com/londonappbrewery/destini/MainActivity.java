package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView storyView;
    Button answer1, answer2;
    int mStoryIndex = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Wire up the 3 views from the layout to the member variables:
        storyView = findViewById(R.id.storyTextView);
        answer1 = findViewById(R.id.buttonTop);
        answer2 = findViewById(R.id.buttonBottom);


        if (savedInstanceState != null) {
            mStoryIndex = savedInstanceState.getInt("StoryIndex");
            storyView.setText(savedInstanceState.getCharSequence("StoryView"));
            answer1.setText(savedInstanceState.getCharSequence("Answer1"));
            answer2.setText(savedInstanceState.getCharSequence("Answer2"));
            answer1.setVisibility(savedInstanceState.getInt("Answer1Visibility"));
            answer2.setVisibility(savedInstanceState.getInt("Answer2Visibility"));
        }

        // Set a listener on the top button:
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (mStoryIndex) {
                    case 1:
                    case 2:
                        mStoryIndex = 3;
                        storyView.setText(R.string.T3_Story);
                        answer1.setText(R.string.T3_Ans1);
                        answer2.setText(R.string.T3_Ans2);
                        break;
                    case 3:
                        mStoryIndex = 6;
                        storyView.setText(R.string.T6_End);
                        answer1.setVisibility(View.INVISIBLE);
                        answer2.setVisibility(View.INVISIBLE);
                        break;
                    default:
                        break;
                }
            }
        });

        // Set a listener on the bottom button
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (mStoryIndex) {
                    case 1:
                        mStoryIndex = 2;
                        storyView.setText(R.string.T2_Story);
                        answer1.setText(R.string.T2_Ans1);
                        answer2.setText(R.string.T2_Ans2);
                        break;
                    case 2:
                        mStoryIndex = 4;
                        storyView.setText(R.string.T4_End);
                        answer1.setVisibility(View.INVISIBLE);
                        answer2.setVisibility(View.INVISIBLE);
                        break;
                    case 3:
                        mStoryIndex = 5;
                        storyView.setText(R.string.T5_End);
                        answer1.setVisibility(View.INVISIBLE);
                        answer2.setVisibility(View.INVISIBLE);
                        break;
                    default:
                        break;
                }
            }
        });

    }

    // Save state
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("StoryIndex", mStoryIndex);
        outState.putCharSequence("StoryView", storyView.getText());
        outState.putCharSequence("Answer1", answer1.getText());
        outState.putCharSequence("Answer2", answer2.getText());
        outState.putInt("Answer1Visibility", answer1.getVisibility());
        outState.putInt("Answer2Visibility", answer2.getVisibility());
    }
}
