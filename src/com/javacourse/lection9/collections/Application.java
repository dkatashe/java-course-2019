package com.javacourse.lection9.collections;

import java.io.*;
import java.util.*;

public class Application
{
  /*
  protected LinkedHashMap<String, Integer> getUnsortedDictionary()
  {
    LinkedHashMap<String, Integer> unsortedDictinoary=new LinkedHashMap<>();

  }
  */

  public static void main(String[] args)
  {
    LinkedHashMap<String, Integer> unsortedDictionary=new LinkedHashMap<>();

    try (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("res/lec9_collections/voina-i-mir.txt"), "windows-1251"));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("res/lec9_collections/enter_order_cnt.res")));
        BufferedWriter bwSorted=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("res/lec9_collections/abc_order_cnt.res"))))
    {
      long startTime = System.currentTimeMillis();
      String line;
      while ((line=br.readLine()) != null)
      {
        line=line.replaceAll("[^A-Za-z?-??-??' ]+|\\s([-?])|-[A-Za-z?-??-??']+|^-", " ");
        line=line.trim();
        if (line.length() > 0)
        {
          String[] lineWords=line.split(" ");
          for (String word : lineWords)
          {
            word=word.toLowerCase();
            if (word.length() > 0)
            {
              if (!unsortedDictionary.containsKey(word))
              {
                unsortedDictionary.put(word, 1);
              }
              else
              {
                Integer count=unsortedDictionary.get(word);
                unsortedDictionary.put(word, ++count);
              }
            }
          }
        }
      }

      for (String word : unsortedDictionary.keySet())
      {
        bw.append(word + " " + unsortedDictionary.get(word));
        bw.newLine();
      }
      System.out.println(System.currentTimeMillis() - startTime);

      /*
      TreeMap<String, Integer> sortedDictionary=new TreeMap<>(unsortedDictionary);
      for (String word : sortedDictionary.keySet())
      {
        bwSorted.append(word + " " + sortedDictionary.get(word));
        bwSorted.newLine();
      }
      */

      startTime = System.currentTimeMillis();

      LinkedList<Map.Entry<String, Integer>> sortedDictionary = new LinkedList<>(unsortedDictionary.entrySet());
      sortedDictionary.sort(Map.Entry.comparingByKey());

      for (Map.Entry word : sortedDictionary)
      {
        bwSorted.append(word.getKey() + " " + word.getValue());
        bwSorted.newLine();
      }
      System.out.println(System.currentTimeMillis() - startTime);

      sortedDictionary.removeIf(nextItem -> Character.UnicodeBlock.of(nextItem.getKey().charAt(0)).equals(Character.UnicodeBlock.CYRILLIC));

    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}