package com.javacourse.lection6.nio;

import java.io.Serializable;

public class Entity implements Serializable
{
  private Integer id;
  private String name;

  public Entity(Integer id, String name)
  {
    this.id=id;
    this.name=name;
  }
}
