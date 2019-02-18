package com.tsystems.javacourse.lection2.tempconverter;

public class ConverterTest
{
  private void testCToF(String testName, double input, double expected)
  {
    System.out.print(testName + ": ");
    Converter converter=new Converter();

    double result=converter.convertToFahrenheit(input);

    if (result == expected)
    {
      System.out.println("passed");
    }
    else
    {
      System.out.println("failed");
    }
  }

  private void testFToC(String testName, double input, double expected)
  {
    System.out.print(testName + ": ");
    Converter converter=new Converter();

    double result=converter.convertToCelsius(input);

    if (result == expected)
    {
      System.out.println("passed");
    }
    else
    {
      System.out.println("failed");
    }
  }

  public static void main(String[] args)
  {
    ConverterTest tester=new ConverterTest();

    tester.testCToF("Convert 25C to F (77F expected)", 25.0, 77.0);
    tester.testCToF("Convert 9C to F (48.2F expected)", 9.0, 48.2);
    tester.testFToC("Convert 95F to C (35C expected)", 95.0, 35.0);
    tester.testFToC("Convert 0F to C (-17.8C expected)", 0.0, -17.8);
  }
}
