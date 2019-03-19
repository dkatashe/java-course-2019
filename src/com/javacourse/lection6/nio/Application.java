package com.javacourse.lection6.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Application
{
  public static void main(String[] args)
  {
    System.out.println("Enter path to csv file:");
    try (BufferedReader br=new BufferedReader(new InputStreamReader(System.in)))
    {
      CsvParser parser=new CsvParser();
      Map<Integer, Entity> entities=parser.parse(br.readLine());
      Serializer.serialize(entities);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
