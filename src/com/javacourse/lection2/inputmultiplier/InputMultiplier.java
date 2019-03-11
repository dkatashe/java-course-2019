package com.javacourse.lection2.inputmultiplier;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class InputMultiplier
{
  void multiply()
  {
    Scanner in=new Scanner(System.in);

    System.out.println("Enter some data:");
    String inputStr=in.nextLine();
    String[] inputArr=inputStr.split(" ");

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
        ArrayList<String[]> result=new ArrayList<>();

        for (int i=1; i <= inputQty; i++)
        {
          String[] arrCopy=new String[inputArr.length + 1];
          arrCopy[0]=Integer.toString(i);
          System.arraycopy(inputArr, 0, arrCopy, 1, inputArr.length);

          result.add(arrCopy);
        }

        System.out.println("Output:");
        for (String[] arr : result)
        {
          System.out.println(String.join(" ", arr));
        }
      }
    }
    catch (InputMismatchException e)
    {
      System.out.println("Input value is invalid.\n");
    }
  }
}
