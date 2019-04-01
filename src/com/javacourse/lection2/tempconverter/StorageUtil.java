package com.javacourse.lection2.tempconverter;

import com.javacourse.lection2.tempconverter.util.CryptUtil;

import javax.crypto.Cipher;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

class StorageUtil
{
  private final static String LINE_SEPARATOR=System.lineSeparator();

  void log(String user, double input, double result, String convertTo)
  {

    try (BufferedWriter bw=new BufferedWriter(new FileWriter("res/lec2_tempconverter/conversion.log", true)))
    {
      CryptUtil cUtil=new CryptUtil();
      String timestamp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").format(new Timestamp(System.currentTimeMillis()));
      bw.write(cUtil
          .aes(timestamp + "(User: " + user + ") " + input + (convertTo.equals("C") ? "F -> " : "C -> ") + result + convertTo, Cipher.ENCRYPT_MODE)
          + LINE_SEPARATOR);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
