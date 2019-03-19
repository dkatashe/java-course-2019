package com.javacourse.lection6.nio;

import java.io.*;
import java.util.Map;

public class Serializer
{
  public static void serialize(Map<Integer, Entity> entities)
  {
    for (Map.Entry<Integer, Entity> entry : entities.entrySet())
    {
      Entity currentEnt=entry.getValue();

      try (ObjectOutputStream objectOut=new ObjectOutputStream(new FileOutputStream("res/nio_out/obj_" + entry.getKey() + ".txt")))
      {
        objectOut.writeObject(currentEnt);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
  }
}
