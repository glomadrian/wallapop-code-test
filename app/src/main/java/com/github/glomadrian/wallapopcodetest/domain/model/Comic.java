package com.github.glomadrian.wallapopcodetest.domain.model;

import java.util.ArrayList;

/**
 * @author Adrián García Lomas
 */
public class Comic {

  private int id;
  private String title;
  private String description;
  private String pages;
  private String thumbnailUrl;
  private ArrayList<String> imagesUrls;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPages() {
    return pages;
  }

  public void setPages(String pages) {
    this.pages = pages;
  }

  public String getThumbnailUrl() {
    return thumbnailUrl;
  }

  public void setThumbnailUrl(String thumbnailUrl) {
    this.thumbnailUrl = thumbnailUrl;
  }

  public ArrayList<String> getImagesUrls() {
    return imagesUrls;
  }

  public void setImagesUrls(ArrayList<String> imagesUrls) {
    this.imagesUrls = imagesUrls;
  }
}
