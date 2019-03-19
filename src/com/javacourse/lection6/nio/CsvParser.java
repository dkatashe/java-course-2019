package com.javacourse.lection6.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class CsvParser
{
  public Map<Integer, Entity> parse(String filePath)
  {
    Path path=Paths.get(filePath);
    Map<Integer, Entity> entities=new HashMap<>();

    try (BufferedReader br=Files.newBufferedReader(path))
    {
      int i=0;
      String line;

      while ((line=br.readLine()) != null)
      {
        String[] parsedEntity=line.split(",");
        entities.put(i++, new Entity(Integer.parseInt(parsedEntity[0]), parsedEntity[1]));
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

    return entities;
  }
}
