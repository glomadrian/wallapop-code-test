package com.github.glomadrian.wallapopcodetest.data.comic.marvel.model;

import java.util.ArrayList;
import java.util.List;

public class Data {

  private String offset;
  private String limit;
  private String total;
  private String count;
  private List<Result> results = new ArrayList<Result>();

  public String getOffset() {
    return offset;
  }

  public void setOffset(String offset) {
    this.offset = offset;
  }

  public String getLimit() {
    return limit;
  }

  public void setLimit(String limit) {
    this.limit = limit;
  }

  public String getTotal() {
    return total;
  }

  public void setTotal(String total) {
    this.total = total;
  }

  public String getCount() {
    return count;
  }

  public void setCount(String count) {
    this.count = count;
  }

  public List<Result> getResults() {
    return results;
  }

  public void setResults(List<Result> results) {
    this.results = results;
  }
}