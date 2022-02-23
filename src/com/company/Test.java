package com.company;

import java.util.Calendar;
import java.util.Date;

public class Test {
    static int record = 0;
    Date date;
    static byte mark;
    String User = new String();
    Question[] questions = new Question[20];

    public Test(String User, Question[] questions)
    {
        mark = 0;
        this.User = User;
        for(int i=0;i<20;i++)
        {
            this.questions[i] = questions[i];
        }
        date = new Date();
    }
    public boolean isRight(int index,int ansNum)
    {
        if (questions[index].answers[ansNum].isRight()==1)
        {
            record++;
            return true;
        }
        return false;
    }
    public void setMark()
    {
        if (record<5) mark = 2;
        else if(record<10) mark = 3;
        else if (record<15) mark = 4;
        else  if (record<=20) mark = 5;
    }

    public static int getRecord() {
        return record;
    }

    public static byte getMark() {
        return mark;
    }
}
