package com.example.mka.fiftyplay;

import java.util.ArrayList;
import java.util.List;


public class Andrew {
    private int questionNumber;
    private boolean answer;
    private List<int[]> cards = new ArrayList<int[]>();

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

    public int[] getCard() {
        return cards.get(questionNumber);
    }

    private void generateCards() {
        int[] card1 = {1, 4, 6, 9, 12, 14, 17, 19, 22, 25, 27, 30, 33, 35, 38, 40, 43, 46, 48, 51, 53, 56, 59, 61, 64};
        int[] card2 = {2, 7, 10, 15, 20, 23, 28, 31, 36, 41, 44, 49, 54, 57, 62, 65, 70, 75, 78, 83, 86, 91, 96, 99, 104};
        int[] card3 = {3, 4, 11, 12, 16, 17, 24, 25, 32, 33, 37, 38, 45, 46, 50, 51, 58, 59, 66, 67, 71, 72, 79, 80, 87};
        int[] card5 = {5, 6, 7, 18, 19, 20, 26, 27, 28, 39, 40, 41, 52, 53, 54, 60, 61, 62, 73, 74, 75, 81, 82, 83, 94};
        int[] card8 = {8, 9, 10, 11, 12, 29, 30, 31, 32, 33, 42, 43, 44, 45, 46, 63, 64, 65, 66, 67, 84, 85, 86, 87, 88};
        int[] card13 = {13, 14, 15, 16, 17, 18, 19, 20, 47, 48, 49, 50, 51, 52, 53, 54, 68, 69, 70, 71, 72, 73, 74, 75, 102};
        int[] card21 = {21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87};
        int[] card34 = {34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 123, 124, 125, 126};
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card5);
        cards.add(card8);
        cards.add(card13);
        cards.add(card21);
        cards.add(card34);
    }

}
