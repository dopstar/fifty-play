package com.madlavana.mka.zt5p;

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
        for (Andrew card: cards) {
            if (card.getAnswer()) {
                answer += card.getCard()[0];
                card.setAnswer(false);
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
        String displayedAnswer = (answer == -1) ? "Please try again and answer honestly." : Integer.toString(answer);
        answer = 0;
        ((TextView) findViewById(R.id.Answer)).setText(displayedAnswer);
    }

    public void displayCard() {
        calculateAnswer();
        if (currentQuestionNumber == 8) {
            showAnswer();
        } else if (answer > 50) {
            answer = -1;
            showAnswer();
        } else {
            ((TextView) findViewById(R.id.step)).setText(
                "Step " + (currentQuestionNumber + 1) + " of 8"
            );
            // Populate the matrix with numbers
            for (int i = 0; i < 20; i++) {
                int cellId = getResources().getIdentifier("textView"+i, "id", getPackageName());
                String cellValue = Integer.toString(cards[currentQuestionNumber].getCard()[i]);
                ((TextView) findViewById(cellId)).setText(cellValue);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
