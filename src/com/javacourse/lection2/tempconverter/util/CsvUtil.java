package com.javacourse.lection2.tempconverter.util;

import javax.crypto.Cipher;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CsvUtil
{
  private final static String LINE_SEPARATOR=System.lineSeparator();
  private CryptUtil cUtil;

  public CsvUtil() throws IOException
  {
    cUtil=new CryptUtil();
  }

  public ArrayList<AuthUtil.User> parse(String filePath) throws IOException
  {
    Path path=Paths.get(filePath);
    ArrayList<AuthUtil.User> entities=new ArrayList<>();

    try (BufferedReader br=Files.newBufferedReader(path))
    {
      String line;

      while ((line=br.readLine()) != null)
      {
        if (line.equals(""))
          break;
        line=cUtil.aes(line, Cipher.DECRYPT_MODE);
        String[] parsedEntity=line.split(",");
        entities.add(new AuthUtil.User(parsedEntity[0], parsedEntity[1]));
      }
    }

    return entities;
  }

  public void save(ArrayList<AuthUtil.User> users, String filePath) throws IOException
  {
    Path path=Paths.get(filePath);

    try (BufferedWriter bw=Files.newBufferedWriter(path))
    {
      for (AuthUtil.User user : users)
      {
        String decrypted=cUtil.aes(user.getLogin() + "," + user.getPassword(), Cipher.ENCRYPT_MODE);
        bw.write(decrypted + LINE_SEPARATOR);
      }
    }
  }
}
