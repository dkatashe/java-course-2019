package com.javacourse.lection6.nio;

import java.io.Serializable;

class Entity implements Serializable
{
  private Integer id;
  private String name;

  Entity(Integer id, String name)
  {
    this.id=id;
    this.name=name;
  }
}
