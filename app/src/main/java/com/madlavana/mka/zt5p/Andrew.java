package com.madlavana.mka.zt5p;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class Andrew {
    private int questionNumber;
    private boolean answer;
    private int numberOfCards = 8;
    private int maxCardSize = 25;
    private ArrayList<ArrayList<Integer>> cards = new ArrayList<>();

    public Andrew(int questionNumber) {
        answer = false;
        this.questionNumber = questionNumber;
        generateCards();
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
    public boolean getAnswer() {
        return answer;
    }

    public ArrayList<Integer> getCard() {
        return cards.get(questionNumber);
    }

    private void generateCards() {
        int generatorFibNumber;
        ArrayList<Integer> card =  new ArrayList<>();
        ArrayList<Integer> zeckendorfSequence = new ArrayList<>();
        for (int cardNumber = 1; cardNumber <= numberOfCards; cardNumber++) {
            generatorFibNumber = Utils.getFibonacciNumber(cardNumber);
            for (int n = 1; n <= 200; n++) {
                if (card.size() >= maxCardSize) {
                    break;
                }
                zeckendorfSequence = Utils.getZeckendorfSequence(n);
                if (!card.contains(n)  && zeckendorfSequence.contains(generatorFibNumber)) {
                    card.add(n);
                }
            }
        }
    }
}
