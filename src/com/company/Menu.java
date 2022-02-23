package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface Menu {
      static void outQuestion(Question question){};
      static void createTest(File file,File file2,String[] strings) throws FileNotFoundException, IOException{};
      static void resultOut(long time){};
      static void resultSave(long time) throws IOException{};
}
