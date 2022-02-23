package com.company;

public class Answer {
    String text;
    int right;
    public Answer(String text, int right)
    {
        this.text = text;
        this.right = right;
    }
    public String getText() {
        return text;
    }
    public int isRight() {
        return right;
    }
}
