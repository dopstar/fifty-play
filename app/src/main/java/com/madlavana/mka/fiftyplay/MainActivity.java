package com.madlavana.mka.fiftyplay;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
    private int answer = 0;
    private Andrew[] cards = new Andrew[] {
            new Andrew(0),
            new Andrew(1),
            new Andrew(2),
            new Andrew(3),
            new Andrew(4),
            new Andrew(5),
            new Andrew(6),
            new Andrew(7)
    };
    private int currentQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showMainWidget();
    }

    public void calculateAnswer() {
        for (int i=0; i<cards.length; i++) {
            if (cards[i].getAnswer()) {
                answer += cards[i].getCard()[0];
            }
        }
    }

    public void showMainWidget() {
        setContentView(R.layout.activity_main);
        findViewById(R.id.instructions).setVisibility(View.VISIBLE);
        findViewById(R.id.startPlaying).setVisibility(View.VISIBLE);
        findViewById(R.id.step).setVisibility(View.GONE);
        findViewById(R.id.confirm).setVisibility(View.GONE);
        findViewById(R.id.card).setVisibility(View.GONE);
        findViewById(R.id.YesNoButtons).setVisibility(View.GONE);
        Button mYesButton = (Button) findViewById(R.id.YesButton);
        Button mNoButton = (Button) findViewById(R.id.NoButton);
        Button mStartButton = (Button) findViewById(R.id.StartButton);

        mYesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cards[currentQuestionNumber].setAnswer(true);
                currentQuestionNumber++;
                displayCard();
            }
        });
        mNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cards[currentQuestionNumber].setAnswer(false);
                currentQuestionNumber++;
                displayCard();
            }
        });
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.instructions).setVisibility(View.GONE);
                findViewById(R.id.startPlaying).setVisibility(View.GONE);
                findViewById(R.id.step).setVisibility(View.VISIBLE);
                findViewById(R.id.confirm).setVisibility(View.VISIBLE);
                findViewById(R.id.card).setVisibility(View.VISIBLE);
                findViewById(R.id.YesNoButtons).setVisibility(View.VISIBLE);
            }
        });
    }

    public void showAnswer() {
        currentQuestionNumber = 0; // reset to the start
        calculateAnswer();

        setContentView(R.layout.answer_activity);
        Button mPlayAgainButton = (Button) findViewById(R.id.PlayAgainButton);
        mPlayAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQuestionNumber = 0;
                answer = 0;
                showMainWidget();
            }
        });
        ((TextView) findViewById(R.id.Answer)).setText(Integer.toString(answer));
    }

    public void displayCard() {
        if (currentQuestionNumber == 8) {
            showAnswer();
        } else {

            ((TextView) findViewById(R.id.step)).setText("Step " + (currentQuestionNumber + 1) + " of 8");

            int[] resourceIds = {
                    R.id.textView0,
                    R.id.textView1,
                    R.id.textView2,
                    R.id.textView3,
                    R.id.textView4,
                    R.id.textView5,
                    R.id.textView6,
                    R.id.textView7,
                    R.id.textView8,
                    R.id.textView9,
                    R.id.textView10,
                    R.id.textView11,
                    R.id.textView12,
                    R.id.textView13,
                    R.id.textView14,
                    R.id.textView15,
                    R.id.textView16,
                    R.id.textView17,
                    R.id.textView18,
                    R.id.textView19
            };
            for (int i = 0; i < resourceIds.length; i++) {
                ((TextView) findViewById(resourceIds[i])).setText(Integer.toString(cards[currentQuestionNumber].getCard()[i]));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
