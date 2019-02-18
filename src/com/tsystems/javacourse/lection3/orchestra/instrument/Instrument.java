package com.tsystems.javacourse.lection3.orchestra.instrument;

public abstract class Instrument
{
  String name = "";

  public void play()
  {
    System.out.println(name + " is playing");
  }
}
