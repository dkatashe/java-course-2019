package com.javacourse.lection1.additional.utils;

public class StringUtil
{
  public static boolean checkPalindrome(String word) throws IllegalArgumentException
  {
    if (word.length() != 5)
      throw new IllegalArgumentException("The word must be exactly 5 chars long.");

    if (word.contains(" "))
      throw new IllegalArgumentException("Only one word is permitted.");

    word=word.toLowerCase();
    String begin=word.substring(0, 2);

    String end=String.valueOf(word.charAt(4))
        + word.charAt(3);

    return begin.equals(end);
  }

}
