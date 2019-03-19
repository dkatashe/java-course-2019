package com.javacourse.lection6.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Application
{
  public static void main(String[] args)
  {
    try (BufferedReader br=new BufferedReader(new InputStreamReader(System.in)))
    {
      System.out.println("Path to root directory with files: ");
      FileScanner fs=new FileScanner(br.readLine());
      List<File> allFiles=fs.getFiles();
      Concatenator.concatFiles(allFiles);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
