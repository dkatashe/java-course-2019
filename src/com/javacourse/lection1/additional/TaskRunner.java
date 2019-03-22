package com.javacourse.lection1.additional;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.javacourse.lection1.additional.utils.*;

class TaskRunner
{
  void runPalindrome()
  {
    Scanner sc=new Scanner(System.in);
    boolean isRunning=true;

    System.out.println("CheckPalindrome\n");
    while (isRunning)
    {
      try
      {
        System.out.println("Enter a word (length = 5 chars) or type 'exit' to exit the task:");
        String word=sc.nextLine();

        if (!word.toLowerCase().equals("exit"))
        {
          boolean isPalindrome=StringUtil.checkPalindrome(word);
          System.out.println("The word is " + (isPalindrome ? "" : "not ") + "a palindrome.\n");
        }
        else
        {
          isRunning=false;
        }
      }
      catch (IllegalArgumentException e)
      {
        System.out.println("Error: " + e.getMessage() + "\n");
      }
    }
  }

  void runClosestNumber()
  {
    Scanner sc=new Scanner(System.in);
    boolean isRunning=true;
    int a=0;
    int b=0;
    int c=0;

    System.out.println("ClosestNumber\n");
    System.out.println("Enter three numbers to check which of the numbers (a, b) is closer to number c:");

    while (isRunning)
    {
      try
      {
        if (a == 0)
        {
          System.out.print("a = ");
          a=sc.nextInt();
        }

        if (b == 0)
        {
          System.out.print("b = ");
          b=sc.nextInt();
        }

        if (c == 0)
        {
          System.out.print("c = ");
          c=sc.nextInt();
        }

        NumUtil.determineClosestNumber(a, b, c);

        isRunning=false;
      }
      catch (InputMismatchException e)
      {
        System.out.println("Error: Only integers allowed");
        sc.nextLine();
      }
    }
  }

  void runNumOfThree()
  {
    Scanner sc=new Scanner(System.in);
    boolean isRunning=true;
    int a=0;
    int b=0;
    int c=0;

    System.out.println("MinOfThree\n");
    System.out.println("Enter three numbers to get minimal one:");

    while (isRunning)
    {
      try
      {
        if (a == 0)
        {
          System.out.print("#1: ");
          a=sc.nextInt();
        }

        if (b == 0)
        {
          System.out.print("#2: ");
          b=sc.nextInt();
        }

        if (c == 0)
        {
          System.out.print("#3: ");
          c=sc.nextInt();
        }

        System.out.println("Min value is " + NumUtil.minOfThree(a, b, c));

        isRunning=false;
      }
      catch (InputMismatchException e)
      {
        System.out.println("Error: Only integers allowed");
        sc.nextLine();
      }
    }
  }

  void runNumberIsEven()
  {
    Scanner sc=new Scanner(System.in);
    boolean isRunning=true;
    int num;

    System.out.println("NumberIsEven\n");

    while (isRunning)
    {
      try
      {
        System.out.println("Enter the number to check whether it is even or odd:");
        num=sc.nextInt();

        System.out.println("The number is " + (NumUtil.isEven(num) ? "even" : "odd"));
        isRunning=false;
      }
      catch (InputMismatchException e)
      {
        System.out.println("Error: Only integers allowed");
        sc.nextLine();
      }
    }
  }

  void runArrayMinMax()
  {
    Scanner sc=new Scanner(System.in);
    boolean isRunning=true;

    System.out.println("ArrayMinMax\n");

    while (isRunning)
    {
      try
      {
        System.out.println("Enter an array of integers delimited by comma:");
        String numsInput=sc.nextLine();

        int[] nums=ArrayUtil.toArray(numsInput);

        System.out.println("Min = " + ArrayUtil.min(nums));
        System.out.println("Max = " + ArrayUtil.max(nums));

        isRunning=false;
      }
      catch (NumberFormatException e)
      {
        System.out.println("Error: Only integers allowed");
      }
    }
  }

  void runArraySum()
  {
    Scanner sc=new Scanner(System.in);
    boolean isRunning=true;

    System.out.println("ArraySum\n");

    while (isRunning)
    {
      try
      {
        System.out.println("Enter an array of integers delimited by comma:");
        String numsInput=sc.nextLine();

        System.out.println("Sum of all array elements = " + ArrayUtil.sum(ArrayUtil.toArray(numsInput)));

        isRunning=false;
      }
      catch (NumberFormatException e)
      {
        System.out.println("Error: Only integers allowed");
      }
    }
  }

  void runArrayMean()
  {
    Scanner sc=new Scanner(System.in);
    boolean isRunning=true;

    System.out.println("ArrayMean\n");

    while (isRunning)
    {
      try
      {
        System.out.println("Enter an array of integers delimited by comma:");
        String numsInput=sc.nextLine();

        System.out.println("Arithmetic mean of array elements = " + String.format("%.2f", ArrayUtil.mean(ArrayUtil.toArray(numsInput))));

        isRunning=false;
      }
      catch (NumberFormatException e)
      {
        System.out.println("Error: Only integers allowed");
      }
    }
  }
}
