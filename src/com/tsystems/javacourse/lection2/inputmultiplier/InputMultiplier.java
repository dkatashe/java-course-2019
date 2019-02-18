package com.tsystems.javacourse.lection2.inputmultiplier;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMultiplier
{
  public void multiply()
  {
    Scanner in=new Scanner(System.in);

    System.out.println("Enter some data:");
    String inputStr=in.nextLine();

    // TODO: parse input to array (use space as delimiter)
    System.out.println("How many times should input data be multiplied?");
    try
    {
      int inputQty=in.nextInt();
      if (inputQty <= 0)
      {
        System.out.println("Value should be more than 0.");
      }
      else
      {
        System.out.println("Output:");
        for (int i=1; i <= inputQty; i++)
        {
          System.out.println(i + " " + inputStr);
        }
      }
    }
    catch (InputMismatchException e)
    {
      System.out.println("Input value is invalid.\n");
    }
  }
}
