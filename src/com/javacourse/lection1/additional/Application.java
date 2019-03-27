package com.javacourse.lection1.additional;

import java.util.Scanner;

public class Application
{
  private static class Options
  {
    private int page;

    Options()
    {
      this.page=1;
    }

    int getPage()
    {
      return page;
    }

    private void show(int page)
    {
      switch (page)
      {
        case 1:
          System.out.println("Available tasks: \n");
          System.out.println("1. Check palindrome");
          System.out.println("2. Get number from {A, B} that is closer to C");
          System.out.println("3. Get minimum of three numbers");
          System.out.println("4. Check if number is odd or even");
          System.out.println("5. Get min and max of int array");
          System.out.println("6. Get sum of int array");
          System.out.println("7. Get arithmetic mean of int array");
          System.out.println("8. Find a number in array");
          System.out.println("9. Get number of occurences of a number in array");
          System.out.println("10. Get powers of 2 (from 0 to 60)");
          System.out.println("0. Exit application\n");

          System.out.println("> - Next page");
          break;
        case 2:
          System.out.println("Available tasks: \n");
          System.out.println("11. Multiply/divide by 2, 4 and 8");
          System.out.println("12. Get arithmetic mean from three different numbers");
          System.out.println("13. Quicksort");
          System.out.println("14. Multiplication table");
          System.out.println("15. Bubble sort");
          System.out.println("16. Get count of days in year");
          System.out.println("17. Check if point is inside a circle");
          System.out.println("18. Get factorial");
          System.out.println("19. Fibonacci numbers");
          System.out.println("20. Leonardo numbers");
          System.out.println("0. Exit application\n");

          System.out.println("> - Next page");
          System.out.println("< - Previous page");
          break;
        case 3:
          System.out.println("Available tasks: \n");
          System.out.println("21. Get reversed number");
          System.out.println("22. Check equation a+b=c (floating point)");
          System.out.println("23. \"Busy intersection\"");
          System.out.println("24. Look-and-say sequence");
          System.out.println("25. Get max product of three numbers from a number setup");
          System.out.println("26. Convert dec -> hex");
          System.out.println("27. Convert dec -> random numeral system");
          System.out.println("0. Exit application\n");

          System.out.println("< - Previous page");
          break;
      }

      System.out.println("\nSelect an option:");
    }

    void show()
    {
      this.show(this.page);
    }

    void nextPage()
    {
      this.page++;
    }

    void prevPage()
    {
      this.page--;
    }

    void resetPage()
    {
      this.page=1;
    }
  }

  public static void main(String[] args)
  {
    Scanner sc=new Scanner(System.in);
    TaskRunner runner=new TaskRunner();
    Options options=new Application.Options();

    boolean isRunning=true;

    System.out.println("Additional tasks for lesson 2");
    while (isRunning)
    {
      int page=options.getPage();
      options.show();

      if (page == 1)
      {
        switch (sc.nextLine())
        {
          case "0":
            isRunning=false;
            break;
          case "1":
            runner.runPalindrome();
            break;
          case "2":
            runner.runClosestNumber();
            break;
          case "3":
            runner.runNumOfThree();
            break;
          case "4":
            runner.runNumberIsEven();
            break;
          case "5":
            runner.runArrayMinMax();
            break;
          case "6":
            runner.runArraySum();
            break;
          case "7":
            runner.runArrayMean();
            break;
          case "8":
            runner.runArrayFindNum();
            break;
          case "9":
            runner.runArrayCountOccurences();
            break;
          case "10":
            runner.runPowersOfTwo();
            break;
          case ">":
            options.nextPage();
            break;
          default:
            System.out.println("Invalid option.");
        }
      }
      else
        if (page == 2)
        {
          switch (sc.nextLine())
          {
            case "0":
              isRunning=false;
              break;
            case "11":
              runner.runMultiplyDivide();
              break;
            case "12":
              runner.runMeanOfThree();
              break;
            case "13":
              runner.runArrayQuicksort();
              break;
            case "14":
              runner.runMultiplicationTable();
              break;
            case "15":
              runner.runArrayBubbleSort();
              break;
            case "16":
              runner.runGetDayCount();
              break;
            case "17":
              runner.runCheckPointInsideCircle();
              break;
            case "18":
              runner.runGetFactorial();
              break;
            case "19":
              runner.runGetFibonacci();
              break;
            case "20":
              runner.runGetLeonardo();
              break;
            case ">":
              options.nextPage();
              break;
            case "<":
              options.prevPage();
              break;
            default:
              System.out.println("Invalid option.");
          }
        }
        else
          if (page == 3)
          {
            switch (sc.nextLine())
            {
              case "0":
                isRunning=false;
                break;
              case "21":
                runner.runReverseNumber();
                break;
              case "22":
                runner.runCheckFloatEquation();
                break;
              case "23":
                runner.runGetBusyIntersectionNumber();
                break;
              case "24":
                runner.runGetLookAndSaySeq();
                break;
              case "25":
                runner.runArrayGetMaxProductNumbers();
                break;
              case "26":
                runner.runDec2Hex();
                break;
              case "27":
                runner.runDex2NumericSystem();
                break;
              case "<":
                options.prevPage();
                break;
              default:
                System.out.println("Invalid option.");
            }
          }
          else
          {
            System.out.println("Invalid options page");
            options.resetPage();
          }
    }
  }
}
