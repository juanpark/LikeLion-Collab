package com.structural;

public class Score {
    private int korean;
    private int english;
    private int math;

    public Score(int korean, int english, int math) {
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    public int getTotal() {
        return korean + english + math;
    }

    public double getAverage() {
        return getTotal() / 3.0;
    }
}