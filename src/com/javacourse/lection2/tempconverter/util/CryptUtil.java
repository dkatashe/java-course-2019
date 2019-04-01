package com.javacourse.lection2.tempconverter.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Properties;

public class CryptUtil
{
  private SecretKey secretKey;

  public CryptUtil() throws IOException
  {
    try
    {
      Properties props=new Properties();
      props.load(new FileInputStream("res/lec2_tempconverter/config.properties"));
      byte[] strKey=props.getProperty("secret").getBytes();
      this.secretKey=new SecretKeySpec(strKey, 0, strKey.length, "AES");
    }
    catch (NullPointerException e)
    {
      throw new IOException("Can't find secret in properties file");
    }
    catch (FileNotFoundException e)
    {
      throw new FileNotFoundException("Can't find properties file with secret key");
    }
    catch (IOException e)
    {
      throw new IOException("Can't load properties file with secret key");
    }
  }

  public byte[] generateSalt()
  {
    byte[] salt=new byte[8];

    SecureRandom random=new SecureRandom();
    random.nextBytes(salt);

    return salt;
  }

  public String aes(String str, int cipherMode)
  {
    try
    {
      Cipher cipher=Cipher.getInstance("AES");
      cipher.init(cipherMode, this.secretKey);
      byte[] input=null;
      if (cipherMode == Cipher.DECRYPT_MODE)
      {
        input=Base64.getDecoder().decode(str);
      }
      else
        if (cipherMode == Cipher.ENCRYPT_MODE)
        {
          input=str.getBytes();
        }
      byte[] output=cipher.doFinal(input);

      if (cipherMode == Cipher.ENCRYPT_MODE)
        return Base64.getEncoder().encodeToString(output);

      return new String(output);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return "";
    }
  }
}
