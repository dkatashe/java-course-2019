package com.javacourse.lection1;

public class EquationSolver
{
  private static double discriminant;

  private static double[] solveLinearEquation(double a, double b)
  {
    double[] result=new double[1];

    if (a == 0)
    {
      if (b == 0)
      {
        result[0]=Double.POSITIVE_INFINITY;
      }
      else
      {
        result=null;
      }
    }
    else
    {
      result[0]=-b / a;
    }

    return result;
  }

  private static double[] solveQuadEqPositiveDiscriminant(double a, double b)
  {
    double x1=(-b + Math.sqrt(discriminant)) / (2 * a);
    double x2=(-b - Math.sqrt(discriminant)) / (2 * a);

    return new double[] { x1, x2 };
  }

  private static double[] solveQuadEqDiscriminantZero(double a, double b)
  {
    double x=-b / 2 * a;

    return new double[] { x };
  }

  private static double[] solveQuadraticEquation(double a, double b, double c)
  {
    double[] result;
    if (a != 0)
    {
      discriminant=Math.pow(b, 2) - 4 * a * c;

      if (discriminant > 0)
      {
        result=solveQuadEqPositiveDiscriminant(a, b);
      }
      else
        if (discriminant == 0)
        {
          result=solveQuadEqDiscriminantZero(a, b);
        }
        else
        {
          result=null;
        }
    }
    else
    {
      result=solveLinearEquation(b, c);
    }

    return result;
  }

  public static void main(String[] args)
  {
    double[] result;

    // insert a, b, c here
    double a=2;
    double b=5;
    double c=-3;

    System.out.println("a = " + a);
    System.out.println("b = " + b);
    System.out.println("c = " + c);

    // linear equation
    System.out.println("Solving the linear equation ax + b = 0");
    try
    {
      result=solveLinearEquation(a, b);
      System.out.println("x = " + result[0]);
    }
    catch (NullPointerException e)
    {
      System.out.println("No solution");
    }

    // quadratic equation
    System.out.println("Solving the equation ax^2 + bx + c = 0");
    result=solveQuadraticEquation(a, b, c);
    System.out.print("Result: ");
    if (result != null)
    {
      for (int i=0; i < result.length; i++)
      {
        System.out.print(result[i]);
        if (i < result.length - 1)
          System.out.print(", ");
      }
    }
    else
    {
      System.out.print("no solution");
    }
  }
}
