package com.javacourse.lection2.armstrong;

public class ArmstrongCalculator
{
  private static int getExponent(int num)
  {
    int exp=0;

    do
    {
      exp++;
    }
    while ((num/=10) > 0);

    return exp;
  }

  private void calculate()
  {
    for (int i=0; i < 100_000_000; i++)
    {
      int exp=getExponent(i);
      int sum=0;
      int num=i;
      int currentDigit;

      do
      {
        currentDigit=num % 10;
        if (currentDigit != 0)
        {
          int expd=currentDigit;
          for (int j=0; j < exp - 1; j++)
          {
            expd*=currentDigit;
          }
          sum+=expd;
        }
        num/=10;
      }
      while (num > 0);

      if (i == sum)
      {
        System.out.println(i);
      }
    }
  }

  public static void main(String[] args)
  {
    ArmstrongCalculator calculator=new ArmstrongCalculator();
    calculator.calculate();
  }
}
