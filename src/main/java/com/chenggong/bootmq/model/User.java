package com.chenggong.bootmq.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * created By DCG
 **/
@Data
@Accessors(chain = true)
public class User implements Serializable {
  private String name;
  private String pass;


  @Override
  public String toString() {
    return "User{" +
      "name='" + name + '\'' +
      ", pass='" + pass + '\'' +
      '}';
  }

}
