package com.javacourse.lection1.additional.utils;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtil
{
  public static int min(int[] nums)
  {
    int min=Integer.MAX_VALUE;

    for (int num : nums)
    {
      if (num < min)
        min=num;
    }

    return min;
  }

  public static int max(int[] nums)
  {
    int max=Integer.MIN_VALUE;

    for (int num : nums)
    {
      if (num > max)
        max=num;
    }

    return max;
  }

  public static int sum(int[] nums)
  {
    int sum=0;

    for (int num : nums)
    {
      sum+=num;
    }

    return sum;
  }

  public static double mean(int[] nums)
  {
    double numsQty=(double) nums.length;
    double sum=(double) sum(nums);

    return sum / numsQty;
  }

  public static int indexOf(int[] nums, int numToFind)
  {
    int index=-1;

    for (int i=0; i < nums.length; i++)
    {
      if (nums[i] == numToFind)
      {
        index=i;
        break;
      }
    }

    return index;
  }

  public static int countOccurences(int[] nums, int numToFind)
  {
    int count=0;

    for (int num : nums)
    {
      if (num == numToFind)
        count++;
    }

    return count;
  }

  public static int[] toArray(String numsString) throws NumberFormatException
  {
    String[] numsStringArr=numsString.split(",");
    int[] nums=new int[numsStringArr.length];

    for (int i=0; i < numsStringArr.length; i++)
    {
      nums[i]=Integer.parseInt(numsStringArr[i].trim());
    }

    return nums;
  }

  private static void swap(int[] nums, int iA, int iB) throws ArrayIndexOutOfBoundsException
  {
    int buffer=nums[iA];
    nums[iA]=nums[iB];
    nums[iB]=buffer;
  }

  public static void quicksort(int[] nums, int left, int right)
  {
    int i=left;
    int j=right;

    int pivot=nums[right - (right - left) / 2];

    while (i <= j)
    {
      while (nums[i] < pivot)
        i++;
      while (nums[j] > pivot)
        j--;
      if (i <= j)
      {
        swap(nums, i++, j--);
      }
    }

    if (left < j)
      quicksort(nums, left, j);
    if (right > i)
      quicksort(nums, i, right);
  }

  public static void bubbleSort(int[] nums)
  {
    for (int i=0; i < nums.length - 1; i++)
    {
      boolean sorted=true;
      for (int j=0; j < nums.length - i - 1; j++)
      {
        if (nums[j] > nums[j + 1])
        {
          swap(nums, j, j + 1);
          sorted=false;
        }
      }
      if (sorted)
        break;
    }
  }

  private static void printGrid(int[][] arr)
  {
    for (int[] ints : arr)
    {
      for (int j=0; j < arr[0].length; j++)
      {
        System.out.printf("%3d ", ints[j]);
      }
      System.out.println();
    }
  }

  public static void getBusyIntersectionNum(int n)
  {
    int[][] rndTable=new int[n][n];
    int[] sumRows=new int[n];
    int[] sumCols=new int[n];
    Random random=new Random();

    for (int i=0; i < n; i++)
    {
      for (int j=0; j < n; j++)
      {
        rndTable[i][j]=random.nextInt(99);
        sumCols[j]+=rndTable[i][j];
        sumRows[i]+=rndTable[i][j];
      }
    }

    System.out.println("Array:");
    printGrid(rndTable);

    int iRow=indexOf(sumRows, max(sumRows));
    int iCol=indexOf(sumCols, min(sumCols));

    System.out.println("Busy intersection is (" + iRow + ", " + iCol + "), the number is " + rndTable[iRow][iCol]);
  }

  public static int[] getMaxProductNumbers(int[] nums)
  {
    int len=nums.length;
    if (len < 3)
      throw new IllegalArgumentException("Array must contain at least 3 integers.");

    Arrays.sort(nums);

    int prodHighestNums=nums[len - 1] * nums[len - 2] * nums[len - 3];
    int prodWithNegative=nums[0] * nums[1] * nums[len - 1];

    if (prodHighestNums > prodWithNegative)
    {
      return new int[] { nums[len - 1], nums[len - 2], nums[len - 3] };
    }
    else
    {
      return new int[] { nums[0], nums[1], nums[len - 1] };
    }
  }
}
