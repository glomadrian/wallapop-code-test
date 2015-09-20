package com.github.glomadrian.wallapopcodetest.data.comic.marvel.model;

/**
 * @author Adrián García Lomas
 */
public class ComicsResponse {

  private int code;
  private String status;
  private Data data;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Data getData() {
    return data;
  }

  public void setData(Data data) {
    this.data = data;
  }
}
