package com.javacourse.lection1.additional.utils;

public class NumUtil
{
  public static void determineClosestNumber(int a, int b, int c)
  {
    int absA=Math.abs(c - a);
    int absB=Math.abs(c - b);

    if (absA != absB)
    {
      System.out.println((absA < absB ? a : b) + " is closer to " + c + " than " + (absA < absB ? b : a));
    }
    else
    {
      System.out.println(a + " and " + b + " are equidistant from " + c);
    }
  }

  public static int minOfThree(int a, int b, int c)
  {
    int[] nums={ a, b, c };
    int min=Integer.MAX_VALUE;

    for (int num : nums)
    {
      if (num < min)
        min=num;
    }

    return min;
  }

  public static boolean isEven(int num)
  {
    return num % 2 == 0;
  }
}
