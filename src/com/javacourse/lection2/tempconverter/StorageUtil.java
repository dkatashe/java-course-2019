package com.javacourse.lection2.tempconverter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

class StorageUtil
{
  private final static String LINE_SEPARATOR=System.lineSeparator();

  void log(double input, double result, String convertTo)
  {
    try (BufferedWriter bw=new BufferedWriter(new FileWriter("conversion.log", true)))
    {
      String timestamp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").format(new Timestamp(System.currentTimeMillis()));
      bw.write(timestamp + input + (convertTo.equals("C") ? "F -> " : "C -> ") + result + convertTo + LINE_SEPARATOR);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
