package com.javacourse.lection1.additional;

import java.util.Arrays;
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

  void runArrayFindNum()
  {
    Scanner sc=new Scanner(System.in);
    boolean isRunning=true;
    int[] inputArr=null;

    System.out.println("ArrayFindNum\n");

    while (isRunning)
    {
      try
      {
        if (inputArr == null)
        {
          System.out.println("Enter an array of integers delimited by comma:");
          String numsInput=sc.nextLine();

          inputArr=ArrayUtil.toArray(numsInput);
        }

        System.out.println("Enter an integer to find in array:");
        int numToFind=sc.nextInt();

        int result=ArrayUtil.indexOf(inputArr, numToFind);

        if (result == -1)
        {
          System.out.println("Array doesn't contain the number " + numToFind);
        }
        else
        {
          System.out.println("Array has number " + numToFind + " on position " + result);
        }

        isRunning=false;
      }
      catch (NumberFormatException e)
      {
        System.out.println("Error: Only integers allowed");
      }
      catch (InputMismatchException e)
      {
        System.out.println("Error: Only integers allowed");
        sc.nextLine();
      }
    }
  }

  void runArrayCountOccurences()
  {
    Scanner sc=new Scanner(System.in);
    boolean isRunning=true;
    int[] inputArr=null;

    System.out.println("ArrayCountOccurences\n");

    while (isRunning)
    {
      try
      {
        if (inputArr == null)
        {
          System.out.println("Enter an array of integers delimited by comma:");
          String numsInput=sc.nextLine();

          inputArr=ArrayUtil.toArray(numsInput);
        }

        System.out.println("Enter an integer to count occurences in array:");
        int numToFind=sc.nextInt();

        System.out.println("Number " + numToFind + " occurs in array " + ArrayUtil.countOccurences(inputArr, numToFind) + " time(s)");

        isRunning=false;
      }
      catch (NumberFormatException e)
      {
        System.out.println("Error: Only integers allowed");
      }
      catch (InputMismatchException e)
      {
        System.out.println("Error: Only integers allowed");
        sc.nextLine();
      }
    }
  }

  void runPowersOfTwo()
  {
    Scanner sc=new Scanner(System.in);
    boolean isRunning=true;
    int num;

    System.out.println("PowersOfTwo\n");

    while (isRunning)
    {
      try
      {
        System.out.println("Enter the number from 0 to 60 to get all powers of 2 up to the number:");
        num=sc.nextInt();

        long[] powers=NumUtil.getPowersOfTwo(num);

        System.out.println("Powers of 2:");
        int i=0;
        for (long power : powers)
        {
          System.out.println("2 ^ " + i++ + " = " + power);
        }

        isRunning=false;
      }
      catch (IllegalArgumentException e)
      {
        System.out.println("Error: " + e.getMessage());
      }
      catch (InputMismatchException e)
      {
        System.out.println("Error: Only integers allowed");
        sc.nextLine();
      }
    }
  }

  void runMultiplyDivide()
  {
    Scanner sc=new Scanner(System.in);
    boolean isRunning=true;
    int num;

    System.out.println("MultiplyDivide\n");

    while (isRunning)
    {
      try
      {
        System.out.println("Enter the number to multiply/divide by 2, 4 and 8:");
        num=sc.nextInt();

        System.out.println("Results:");
        System.out.println(num + " * 2 = " + NumUtil.multiply(num, 2));
        System.out.println(num + " * 4 = " + NumUtil.multiply(num, 4));
        System.out.println(num + " * 8 = " + NumUtil.multiply(num, 8));
        System.out.println(num + " / 2 = " + NumUtil.div(num, 2));
        System.out.println(num + " / 4 = " + NumUtil.div(num, 4));
        System.out.println(num + " / 8 = " + NumUtil.div(num, 8));

        isRunning=false;
      }
      catch (IllegalArgumentException e)
      {
        System.out.println("Error: " + e.getMessage());
      }
      catch (InputMismatchException e)
      {
        System.out.println("Error: Only integers allowed");
        sc.nextLine();
      }
    }
  }

  void runMeanOfThree()
  {
    Scanner sc=new Scanner(System.in);
    boolean isRunning=true;
    int a=0;
    int b=0;
    int c=0;

    System.out.println("MeanOfThree\n");
    System.out.println("Enter three unique numbers to get arithmetic mean of them:");

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

          if (b == a)
          {
            b=0;
            throw new IllegalArgumentException("Numbers must be unique");
          }
        }

        if (c == 0)
        {
          System.out.print("#3: ");
          c=sc.nextInt();

          if (c == a || c == b)
          {
            c=0;
            throw new IllegalArgumentException("Numbers must be unique");
          }
        }

        System.out.println("Arithmetic mean is " + String.format("%.2f", NumUtil.mean(a, b, c)));

        isRunning=false;
      }
      catch (InputMismatchException e)
      {
        System.out.println("Error: Only integers allowed");
        sc.nextLine();
      }
      catch (IllegalArgumentException e)
      {
        System.out.println("Error: " + e.getMessage());
      }
    }
  }

  void runArrayQuicksort()
  {
    Scanner sc=new Scanner(System.in);
    boolean isRunning=true;
    int[] inputArr;

    System.out.println("ArrayQuicksort\n");

    while (isRunning)
    {
      try
      {
        System.out.println("Enter an array of integers delimited by comma:");
        String numsInput=sc.nextLine();

        inputArr=ArrayUtil.toArray(numsInput);

        ArrayUtil.quicksort(inputArr, 0, inputArr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(inputArr));
        isRunning=false;
      }
      catch (InputMismatchException e)
      {
        System.out.println("Error: Only integers allowed");
        sc.nextLine();
      }
    }
  }

  void runMultiplicationTable()
  {
    Scanner sc=new Scanner(System.in);
    boolean isRunning=true;
    int a=0;
    int b=0;

    System.out.println("MinOfThree\n");
    System.out.println("Enter two integers to print multiplication table for the interval [a, b]:");

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

          if (b < a)
          {
            b=0;
            throw new IllegalArgumentException("b must be greater than a");
          }
        }

        NumUtil.printMultiplicationTable(a, b);

        isRunning=false;
      }
      catch (InputMismatchException e)
      {
        System.out.println("Error: Only integers allowed");
        sc.nextLine();
      }
      catch (IllegalArgumentException e)
      {
        System.out.println("Error: " + e.getMessage());
      }
    }
  }

  void runArrayBubbleSort()
  {
    Scanner sc=new Scanner(System.in);
    boolean isRunning=true;
    int[] inputArr;

    System.out.println("ArrayBubbleSort\n");

    while (isRunning)
    {
      try
      {
        System.out.println("Enter an array of integers delimited by comma:");
        String numsInput=sc.nextLine();

        inputArr=ArrayUtil.toArray(numsInput);

        ArrayUtil.bubbleSort(inputArr);
        System.out.println("Sorted array: " + Arrays.toString(inputArr));
        isRunning=false;
      }
      catch (InputMismatchException e)
      {
        System.out.println("Error: Only integers allowed");
        sc.nextLine();
      }
    }
  }

  void runGetDayCount()
  {
    Scanner sc=new Scanner(System.in);
    boolean isRunning=true;
    int year;

    System.out.println("GetDayCount\n");

    while (isRunning)
    {
      try
      {
        System.out.println("Enter the year to get day count:");
        year=sc.nextInt();

        System.out.println("Year " + year + " has " + NumUtil.getDayCount(year) + " days.");

        isRunning=false;
      }
      catch (IllegalArgumentException e)
      {
        System.out.println("Error: " + e.getMessage());
      }
      catch (InputMismatchException e)
      {
        System.out.println("Error: Only integers allowed");
        sc.nextLine();
      }
    }
  }

  void runCheckPointInsideCircle()
  {
    Scanner sc=new Scanner(System.in);
    boolean isRunning=true;
    int a=0;
    int b=0;
    int r=0;
    int x=0;
    int y=0;

    System.out.println("CheckPointInsideCircle\n");
    System.out.println("Enter following data:");

    while (isRunning)
    {
      try
      {
        if (a == 0)
        {
          System.out.print("Circle center X coordinate: ");
          a=sc.nextInt();
        }

        if (b == 0)
        {
          System.out.print("Circle center Y coordinate: ");
          b=sc.nextInt();
        }

        if (r == 0)
        {
          System.out.print("Circle radius: ");
          r=sc.nextInt();

          if (r <= 0)
          {
            r=0;
            throw new IllegalArgumentException("Circle radius must be more than 0");
          }
        }

        if (x == 0)
        {
          System.out.print("Point X coordinate: ");
          x=sc.nextInt();
        }

        if (y == 0)
        {
          System.out.print("Point Y coordinate: ");
          y=sc.nextInt();
        }

        System.out
            .println("Point (" + x + ", " + y + ") is " + (NumUtil.checkPointInsideCircle(a, b, r, x, y) ? "inside" : "outside") + " the circle");

        isRunning=false;
      }
      catch (IllegalArgumentException e)
      {
        System.out.println(e.getMessage());
      }
      catch (InputMismatchException e)
      {
        System.out.println("Error: Only integers allowed");
        sc.nextLine();
      }
    }
  }

  void runGetFactorial()
  {
    Scanner sc=new Scanner(System.in);
    boolean isRunning=true;
    int num;

    System.out.println("GetFactorial\n");

    while (isRunning)
    {
      try
      {
        System.out.println("Enter number to calculate factorial:");
        num=sc.nextInt();

        System.out.println(num + "! = " + NumUtil.factorial(num));

        isRunning=false;
      }
      catch (InputMismatchException e)
      {
        System.out.println("Error: Only integers allowed");
        sc.nextLine();
      }
    }
  }

  void runGetFibonacci()
  {
    Scanner sc=new Scanner(System.in);
    boolean isRunning=true;
    int num;

    System.out.println("GetFibonacci\n");

    while (isRunning)
    {
      try
      {
        System.out.println("Enter count of Fibonacci numbers to return:");
        num=sc.nextInt();

        long[] fibo=NumUtil.getFibonacci(num);

        System.out.println("Fibonacci numbers:");
        for (long fiboNum : fibo)
        {
          System.out.print(fiboNum + " ");
        }
        System.out.println();

        isRunning=false;
      }
      catch (InputMismatchException e)
      {
        System.out.println("Error: Only integers allowed");
        sc.nextLine();
      }
    }
  }

  void runGetLeonardo()
  {
    Scanner sc=new Scanner(System.in);
    boolean isRunning=true;
    int num;

    System.out.println("GetLeonardo\n");

    while (isRunning)
    {
      try
      {
        System.out.println("Enter count of Leonardo numbers to return:");
        num=sc.nextInt();

        long[] leo=NumUtil.getLeonardo(num);

        System.out.println("Leonardo numbers:");
        for (long leoNum : leo)
        {
          System.out.print(leoNum + " ");
        }
        System.out.println();

        isRunning=false;
      }
      catch (InputMismatchException e)
      {
        System.out.println("Error: Only integers allowed");
        sc.nextLine();
      }
    }
  }

  void runReverseNumber()
  {
    Scanner sc=new Scanner(System.in);
    boolean isRunning=true;
    int num;

    System.out.println("ReverseNumber\n");

    while (isRunning)
    {
      try
      {
        System.out.println("Enter number to reverse:");
        num=sc.nextInt();

        System.out.println(NumUtil.reverse(num));

        isRunning=false;
      }
      catch (InputMismatchException e)
      {
        System.out.println("Error: Only integers allowed");
        sc.nextLine();
      }
    }
  }

  void runCheckFloatEquation()
  {
    Scanner sc=new Scanner(System.in);
    boolean isRunning=true;
    float a=0;
    float b=0;
    float c=0;

    System.out.println("CheckFloatEquation\n");
    System.out.println("Enter floats for equation a + b = c:");

    while (isRunning)
    {
      try
      {
        if (a == 0)
        {
          System.out.print("a = ");
          a=sc.nextFloat();
        }

        if (b == 0)
        {
          System.out.print("b = ");
          b=sc.nextFloat();
        }

        if (c == 0)
        {
          System.out.print("c = ");
          c=sc.nextFloat();
        }

        boolean isOk=NumUtil.checkFloatEquation(a, b, c);

        if (isOk)
        {
          System.out.println("Equation is correct");
        }
        else
        {
          System.out.println("Equation is incorrect, a + b = " + (a + b));
        }

        isRunning=false;
      }
      catch (InputMismatchException e)
      {
        System.out.println("Error: Only numbers allowed");
        sc.nextLine();
      }
    }
  }

  void runGetBusyIntersectionNumber()
  {
    Scanner sc=new Scanner(System.in);
    boolean isRunning=true;
    int n;

    System.out.println("GetBusyIntersectionNumber\n");

    while (isRunning)
    {
      try
      {
        System.out.println("Enter size of multidimensional array:");
        n=sc.nextInt();

        if (n <= 0)
        {
          throw new IllegalArgumentException("Array size must be more than 0");
        }

        ArrayUtil.getBusyIntersectionNum(n);

        isRunning=false;
      }
      catch (IllegalArgumentException e)
      {
        System.out.println("Error: " + e.getMessage());
      }
      catch (InputMismatchException e)
      {
        System.out.println("Error: Only integers allowed");
        sc.nextLine();
      }
    }
  }

  void runGetLookAndSaySeq()
  {
    Scanner sc=new Scanner(System.in);
    boolean isRunning=true;
    int num;

    System.out.println("GetLookAndSaySeq\n");

    while (isRunning)
    {
      try
      {
        System.out.println("Enter count of Look-and-Say sequence elements to return:");
        num=sc.nextInt();

        String[] conway=NumUtil.getLookAndSaySeq(num);

        System.out.println("Result:");
        for (String elem : conway)
        {
          System.out.println(elem);
        }

        isRunning=false;
      }
      catch (InputMismatchException e)
      {
        System.out.println("Error: Only integers allowed");
        sc.nextLine();
      }
    }
  }

  void runArrayGetMaxProductNumbers()
  {
    Scanner sc=new Scanner(System.in);
    boolean isRunning=true;
    int[] inputArr=null;

    System.out.println("ArrayGetMaxProductNumbers\n");

    while (isRunning)
    {
      try
      {
        if (inputArr == null)
        {
          System.out.println("Enter an array of integers delimited by comma:");
          String numsInput=sc.nextLine();

          inputArr=ArrayUtil.toArray(numsInput);
        }

        int[] result=ArrayUtil.getMaxProductNumbers(inputArr);

        System.out.println("Max product is " + result[0] + " * " + result[1] + " * " + result[2] + " = " + result[0] * result[1] * result[2]);

        isRunning=false;
      }
      catch (NumberFormatException e)
      {
        System.out.println("Error: Only integers allowed");
      }
    }
  }

  void runDec2Hex()
  {
    Scanner sc=new Scanner(System.in);
    boolean isRunning=true;
    int num;

    System.out.println("Dec2Hex\n");

    while (isRunning)
    {
      try
      {
        System.out.println("Enter decimal number to convert to hexadecimal:");
        num=sc.nextInt();

        System.out.println("Hex value is " + NumUtil.convertDecimalToNumeralSystem(num, 16));

        isRunning=false;
      }
      catch (IllegalArgumentException e)
      {
        System.out.println("Error: " + e.getMessage());
      }
      catch (InputMismatchException e)
      {
        System.out.println("Error: Only integers allowed");
        sc.nextLine();
      }
    }
  }

  void runDex2NumericSystem()
  {
    Scanner sc=new Scanner(System.in);
    boolean isRunning=true;
    int num=0;
    int base=0;

    System.out.println("Dex2NumericSystem\n");

    while (isRunning)
    {
      try
      {
        if (num == 0)
        {
          System.out.print("Enter decimal number: ");
          num=sc.nextInt();
        }

        if (base == 0)
        {
          System.out.print("Enter target base: ");
          base=sc.nextInt();
        }

        System.out.println("Base-" + base + " value is " + NumUtil.convertDecimalToNumeralSystem(num, base));

        isRunning=false;
      }
      catch (IllegalArgumentException e)
      {
        System.out.println("Error: " + e.getMessage());
      }
      catch (InputMismatchException e)
      {
        System.out.println("Error: Only numbers allowed");
        sc.nextLine();
      }
    }
  }
}
