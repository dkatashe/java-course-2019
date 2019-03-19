package com.javacourse.lection6.io;

import java.io.*;
import java.util.List;

class Concatenator
{
  private final static String LINE_SEPARATOR=System.lineSeparator();

  static void concatFiles(List<File> files)
  {
    try (BufferedWriter bw=new BufferedWriter(new FileWriter("output.txt")))
    {
      for (File f : files)
      {
        try (BufferedReader br=new BufferedReader(new FileReader(f)))
        {
          String line;

          while ((line=br.readLine()) != null)
          {
            bw.write(line + LINE_SEPARATOR);
          }
        }
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
