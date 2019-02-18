package com.tsystems.javacourse.lection2.inputmultiplier;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ConsoleUI
{
  private static boolean isRunning=true;

  private static void menu()
  {
    Scanner in=new Scanner(System.in);
    InputMultiplier multiplier=new InputMultiplier();

    System.out.println("Available actions:\n");
    System.out.println("1) Run input multiplication");
    System.out.println("2) Exit\n");
    System.out.print("Your choice: ");
    int opt;

    try
    {
      opt=in.nextInt();
    }
    catch (InputMismatchException e)
    {
      System.out.println("Input value is invalid.\n");

      return;
    }

    switch (opt)
    {
      case 1:
        multiplier.multiply();
        break;
      case 2:
        in.close();
        isRunning=false;
        break;
      default:
        System.out.println("Unrecognized option\n");
        break;
    }
  }

  public static void main(String[] args)
  {
    while (isRunning)
      menu();
  }
}
