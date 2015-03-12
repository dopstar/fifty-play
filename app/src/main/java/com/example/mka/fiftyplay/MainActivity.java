package com.example.mka.fiftyplay;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
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
        setContentView(R.layout.activity_main);
        Button mYesButton = (Button) findViewById(R.id.YesButton);
        Button mNoButton = (Button) findViewById(R.id.NoButton);
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
    }

    public void calculateAnswer() {
        for (int i=0; i<cards.length; i++) {
            if (cards[i].getAnswer()) {
                answer = answer + cards[i].getCard()[0];
            }
        }
    }

    public void displayCard() {
        if (currentQuestionNumber == 8) {
            currentQuestionNumber = 0; // reset to the start
            calculateAnswer();
        }

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
        for (int i=0; i<resourceIds.length; i++) {
            ((TextView) findViewById(resourceIds[i])).setText(Integer.toString(cards[currentQuestionNumber].getCard()[i]));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
