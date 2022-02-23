package com.company;

public class Question {
    String text;
    Answer[] answers = new Answer[4];

    public Question(String text, Answer[] answers){
        this.text = text;
       for(int i=0;i<4;i++)
       {
           this.answers[i] = answers[i];
       }
    }
    public String getText() {
        return text;
    }
}
