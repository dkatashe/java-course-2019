package com.javacourse.lection2.mergesorter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI
{
  private static boolean isRunning=true;

  private static void menu()
  {
    Scanner in=new Scanner(System.in);
    MergeSorter sorter=new MergeSorter();

    System.out.println("Available actions:\n");
    System.out.println("1) Sort an array using merge sort algorithm");
    System.out.println("2) Exit\n");
    System.out.print("Your choice: ");
    int opt;

    try
    {
      opt=in.nextInt();
    }
    catch (InputMismatchException e)
    {
      System.out.println("Error: Input value is invalid.\n");

      return;
    }

    switch (opt)
    {
      case 1:
        sorter.execute();
        break;
      case 2:
        in.close();
        isRunning=false;
        break;
      default:
        System.out.println("Error: Unrecognized option.\n");
        break;
    }
  }

  public static void main(String[] args)
  {
    while (isRunning)
      menu();
  }
}
