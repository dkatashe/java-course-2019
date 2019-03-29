package com.javacourse.lection2.tempconverter;

class Converter
{
  private StorageUtil sUtil = new StorageUtil();

  double convertToCelsius(double degFahrenheit)
  {
    double result=5.0 / 9.0 * (degFahrenheit - 32.0);
    result = Math.rint(result * 10.0) / 10.0;
    sUtil.log(degFahrenheit, result, "C");
    return result;
  }

  double convertToFahrenheit(double degCelsius)
  {
    double result=9.0 / 5.0 * degCelsius + 32.0;
    result = Math.rint(result * 10.0) / 10.0;
    sUtil.log(degCelsius, result, "F");
    return result;
  }
}
