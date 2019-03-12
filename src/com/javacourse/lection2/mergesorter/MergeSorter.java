package com.javacourse.lection2.mergesorter;

import java.util.Arrays;
import java.util.Scanner;

class MergeSorter
{
  private static int[] sort(int[] inputArray)
  {
    if (inputArray.length <= 1)
      return inputArray;

    int aLen=inputArray.length / 2;
    int bLen=inputArray.length - aLen;

    int[] a=new int[aLen];
    int[] b=new int[bLen];

    System.arraycopy(inputArray, 0, a, 0, aLen);
    System.arraycopy(inputArray, aLen, b, 0, bLen);
    a=sort(a);
    b=sort(b);

    int[] result=new int[aLen + bLen];
    int aIndex=0;     // current index of array a
    int bIndex=0;     // current index of array b
    int resIndex=0;   // current index of array result

    while (aIndex < aLen && bIndex < bLen)
    {
      result[resIndex++]=a[aIndex] < b[bIndex] ? a[aIndex++] : b[bIndex++];
    }

    if (aIndex < aLen)
      System.arraycopy(a, aIndex, result, resIndex, aLen - aIndex);

    if (bIndex < bLen)
      System.arraycopy(b, bIndex, result, resIndex, bLen - bIndex);

    return result;
  }

  void execute()
  {
    Scanner in=new Scanner(System.in);

    System.out.println("Enter an array of integers delimited by space character:");
    String inputStr=in.nextLine();
    String[] inputArr=inputStr.split(" ");
    int[] inputInts=new int[inputArr.length];

    try
    {
      for (int i=0; i < inputArr.length; i++)
      {
        inputInts[i]=Integer.parseInt(inputArr[i]);
      }
    }
    catch (NumberFormatException e)
    {
      System.out.println("Error: Input value is invalid.\n");
      return;
    }

    System.out.println("Input:\n" + Arrays.toString(inputInts));

    int[] sorted=sort(inputInts);
    System.out.println("Result:\n" + Arrays.toString(sorted));
    System.out.println();
  }
}
