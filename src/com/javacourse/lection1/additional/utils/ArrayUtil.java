package com.javacourse.lection1.additional.utils;

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

  public static double mean(int[] nums) {
    double numsQty = (double) nums.length;
    double sum = (double) sum(nums);

    return sum/numsQty;
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
}
