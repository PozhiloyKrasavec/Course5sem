package com.company;

import java.io.*;
import java.util.Scanner;

public class Main{
    static Test test;
    
    public static void main(String[] args) throws IOException, FileNotFoundException {
        File file = new File("C:\\Users\\user\\Downloads\\KR\\src\\com\\company\\answer.txt");
        File file1 = new File("C:\\Users\\user\\Downloads\\KR\\src\\com\\company\\quest.txt");
        Scanner in =  new Scanner(System.in);
        String str = new String();
        System.out.println("Введите свое ФИ");
        str = in.nextLine();
        System.out.println("Введите время на прохождение теста(в минутах)");
        long timer = 60*1000* in.nextLong();
        createTest(file,file1,str);
        long start_time = System.currentTimeMillis();
        for(int i=0;i<20 && (System.currentTimeMillis()-start_time<timer);i++)
        {
            outQuestion(test.questions[i]);
            System.out.println("Введите номер правильного ответа");
            int temp = in.nextInt();
            if(test.isRight(i,temp-1)) System.out.println("Правильный ответ!");
            else System.out.println("Неправильный ответ");
        }
        long end_time = (System.currentTimeMillis() - start_time)/60000;
        test.setMark();
        resultOut(end_time);
        resultSave(end_time);
    }

    public static void outQuestion(Question question) {
        System.out.println(question.getText());
        for (int i=0;i<4;i++)
        {
            System.out.println("\t"+question.answers[i].getText());
        }
    }
    public static void createTest(File file,File file2,String strings) throws FileNotFoundException, IOException {
        BufferedReader[] readers = new BufferedReader[2];
        readers[0] = new BufferedReader(new FileReader(file));
        readers[1] = new BufferedReader(new FileReader(file2));
        Question[] questions = new Question[20];
        for(int i=0;i<20;i++)
        {
            String temp = readers[1].readLine();
            Answer[] answers = new Answer[4];
            for (int j=0;j<4;j++)
            {
                String temp2 = readers[0].readLine();
                int tempint = 0;
                if(temp2.contains("!")) tempint = 1;
                answers[j] = new Answer(temp2,tempint);
            }
            questions[i] = new Question(temp,answers);
        }
        test = new Test(strings,questions);
    }

    public static void resultOut(long time) {
        System.out.println("Количество баллов: "+Test.getRecord());
        System.out.println("Оценка: " + Test.getMark());
        System.out.println("Дата: " + test.date);
        System.out.println("Время" + time);
    }


    public static void resultSave(long time) throws IOException  {
        File file = new File("C:\\Users\\user\\Downloads\\KR\\src\\com\\company\\users.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        int count = 0;
        while (reader.readLine()!=null)
        {
            count++;
        }
        fr.close();
        FileWriter writer = new FileWriter(file,true);
        String temp = count + "\t" + test.User + "\t" + time + "\t" + test.date + "\t" + "\t" +Test.getRecord() + "\t" + Test.getMark()+"\n";
        writer.write(temp);
        writer.close();
    }
}
