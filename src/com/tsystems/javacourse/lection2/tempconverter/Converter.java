package com.tsystems.javacourse.lection2.tempconverter;

public class Converter
{
  public double convertToCelsius(double degFahrenheit)
  {
    double result=5.0 / 9.0 * (degFahrenheit - 32.0);
    return Math.rint(result * 10.0) / 10.0;
  }

  public double convertToFahrenheit(double degCelsius)
  {
    double result=9.0 / 5.0 * degCelsius + 32.0;
    return Math.rint(result * 10.0) / 10.0;
  }
}
