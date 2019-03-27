package com.javacourse.lection1.additional.utils;

import java.util.Formatter;

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

  public static long[] getPowersOfTwo(int highestExponent) throws IllegalArgumentException
  {
    if (highestExponent < 0 || highestExponent > 60)
    {
      throw new IllegalArgumentException("The number must lay between 0 and 60, including 0 and 60");
    }

    long[] powers=new long[highestExponent + 1];

    for (int i=0; i <= highestExponent; i++)
    {
      powers[i]=(long) Math.pow(2, i);
    }

    return powers;
  }

  public static int multiply(int a, int b)
  {
    int result=0;
    boolean isNegative=(a < 0) ^ (b < 0);

    a=Math.abs(a);
    b=Math.abs(b);

    for (int i=1; i <= b; i++)
    {
      result+=a;
    }

    return isNegative ? -result : result;
  }

  public static int div(int divident, int divisor)
  {
    int result=0;
    boolean isNegative=(divident < 0) ^ (divisor < 0);

    divident=Math.abs(divident);
    divisor=Math.abs(divisor);

    while (divident >= divisor)
    {
      divident-=divisor;
      result++;
    }

    return isNegative ? -result : result;
  }

  public static double mean(int a, int b, int c)
  {
    return (a + b + c) / 3.0;
  }

  private static int numLength(int num)
  {
    int len=0;

    do
    {
      len++;
    }
    while ((num/=10) > 0);

    return len;
  }

  private static Integer[][] fillMultiplicationTable(int from, int to)
  {
    Integer[][] table=new Integer[10][to - from + 1];

    for (int i=1, j=0; i <= 10; i++, j++)
    {
      for (int k=from, l=0; k <= to; k++, l++)
      {
        table[j][l]=i * k;
      }
    }

    return table;
  }

  public static void printMultiplicationTable(int from, int to)
  {
    Integer[] rowHeaders=new Integer[to - from + 1];
    Integer[][] mTable=fillMultiplicationTable(from, to);
    int colWidth=numLength(mTable[mTable.length - 1][mTable[mTable.length - 1].length - 1]);

    StringBuilder format=new StringBuilder();
    StringBuilder output=new StringBuilder();
    Formatter formatter=new Formatter(output);

    for (int i=from, j=0; i <= to; i++, j++)
    {
      format.append("%").append(colWidth).append("d ");
      rowHeaders[j]=i;
    }

    formatter.format("%" + colWidth + "s ", "x");
    formatter.format(format.toString(), (Object[]) rowHeaders);
    output.append("\n");

    for (int i=0; i < mTable.length; i++)
    {
      formatter.format("%" + colWidth + "d ", i + 1);
      formatter.format(format.toString(), (Object[]) mTable[i]);
      output.append("\n");
    }

    System.out.println(output.toString());
  }

  private static boolean checkLeapYear(int year) throws IllegalArgumentException
  {
    if (year < -45)
      throw new IllegalArgumentException("Can't check leap year earlier than 45 BC");

    if (year < 1582)
    {
      return (year % 4 == 0);
    }
    else
    {
      return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
    }
  }

  public static int getDayCount(int year) throws IllegalArgumentException
  {
    return checkLeapYear(year) ? 366 : 365;
  }

  /**
   * @param a Circle center X coordinate
   * @param b Circle center Y coordinate
   * @param r Circle radius
   * @param x Point X coordinate
   * @param y Point Y coordinate
   * @return True if point is inside the circle
   */
  public static boolean checkPointInsideCircle(int a, int b, int r, int x, int y)
  {
    return Math.pow(x - a, 2.0) + Math.pow(y - b, 2.0) <= Math.pow(r, 2);
  }

  public static int factorial(int num)
  {
    if (num <= 1)
      return 1;

    return num * factorial(num - 1);
  }

  public static long[] getFibonacci(int count)
  {
    long[] fibNumbers=new long[count];

    for (int i=0; i < count; i++)
    {
      if (i < 2)
      {
        fibNumbers[i]=i;
      }
      else
      {
        fibNumbers[i]=fibNumbers[i - 2] + fibNumbers[i - 1];
      }
    }

    return fibNumbers;
  }

  public static long[] getLeonardo(int count)
  {
    long[] leoNumbers=new long[count];

    for (int i=0; i < count; i++)
    {
      if (i < 2)
      {
        leoNumbers[i]=1;
      }
      else
      {
        leoNumbers[i]=leoNumbers[i - 2] + leoNumbers[i - 1] + 1;
      }
    }

    return leoNumbers;
  }

  public static String[] getLookAndSaySeq(int count)
  {
    if (count < 0)
      throw new IllegalArgumentException("Positive count of sequence elements expected");
    if (count == 0)
      return new String[] {};

    String[] sequence=new String[count];
    sequence[0]="1";

    for (int i=1; i < count; i++)
    {
      String prevItem=sequence[i - 1];
      StringBuilder seqItem=new StringBuilder();

      int end;
      do
      {
        end=0;
        int start=end;
        while (end + 1 < prevItem.length())
        {
          if (prevItem.charAt(end) == prevItem.charAt(end + 1))
          {
            end++;
          }
          else
          {
            break;
          }
        }

        seqItem.append(end - start + 1);
        seqItem.append(prevItem.charAt(start));
      }
      while (!(prevItem=prevItem.substring(end + 1)).equals(""));

      sequence[i]=seqItem.toString();
    }

    return sequence;
  }

  public static int reverse(int num)
  {
    int reversed=0;

    while (num != 0)
    {
      reversed*=10;
      reversed+=(num % 10);
      num/=10;
    }

    return reversed;
  }

  public static boolean checkFloatEquation(float a, float b, float c)
  {
    float sum=a + b;

    return Float.compare(sum, c) == 0;
  }

  public static String convertDecimalToNumeralSystem(int decimal, int targetBase)
  {
    if (targetBase > 36)
      throw new IllegalArgumentException("Target base must be less than or equal to 36");

    String sign=decimal < 0 ? "-" : "";
    decimal=Math.abs(decimal);

    char[] values={ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
        'U', 'V', 'W', 'X', 'Y', 'Z' };

    StringBuilder result=new StringBuilder();

    while (decimal >= targetBase)
    {
      result.insert(0, values[decimal % targetBase]);
      decimal/=targetBase;
    }

    if (decimal != 0)
      result.insert(0, values[decimal]);
    result.insert(0, sign);

    return result.toString();
  }
}
