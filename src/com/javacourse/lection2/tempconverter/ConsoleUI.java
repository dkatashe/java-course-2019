package com.javacourse.lection2.tempconverter;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Locale;

public class ConsoleUI
{
  private static boolean isRunning=true;

  private static void convert(int mode)
  {
    Scanner in=new Scanner(System.in).useLocale(Locale.US);
    Converter converter=new Converter();
    double result;

    System.out.print("Enter temperature: ");

    try
    {
      double input=in.nextDouble();

      if (mode == 1)
      {
        result=converter.convertToFahrenheit(input);
      }
      else
      {
        result=converter.convertToCelsius(input);
      }

      System.out.println("Result: " + result + "\n");
    }
    catch (InputMismatchException e)
    {
      System.out.println("Input value is invalid.\n");
      convert(mode);
    }
  }

  private static void selectMode()
  {
    Scanner in=new Scanner(System.in);

    System.out.println("Available actions:\n");
    System.out.println("1) Convert Celsius to Fahrenheit");
    System.out.println("2) Convert Fahrenheit to Celsius");
    System.out.println("3) Exit\n");
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
      case 2:
        String modeStr=(opt == 1) ? "Celsius to Fahrenheit" : "Fahrenheit to Celsius";
        System.out.println(modeStr + " conversion\n");
        convert(opt);
        break;
      case 3:
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
      selectMode();
  }
}
