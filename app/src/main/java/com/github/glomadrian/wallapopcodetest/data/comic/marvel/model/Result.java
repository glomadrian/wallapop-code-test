package com.github.glomadrian.wallapopcodetest.data.comic.marvel.model;

import java.util.ArrayList;
import java.util.List;

public class Result {

  private String id;
  private String digitalId;
  private String title;
  private String issueNumber;
  private String variantDescription;
  private String description;
  private String modified;
  private String isbn;
  private String upc;
  private String diamondCode;
  private String ean;
  private String issn;
  private String format;
  private String pageCount;
  private List<TextObject> textObjects = new ArrayList<TextObject>();
  private String resourceURI;
  private List<Url> urls = new ArrayList<Url>();
  private Series series;
  private List<Variant> variants = new ArrayList<Variant>();
  private List<Collection> collections = new ArrayList<Collection>();
  private List<CollectedIssue> collectedIssues = new ArrayList<CollectedIssue>();
  private List<Date> dates = new ArrayList<Date>();
  private List<Price> prices = new ArrayList<Price>();
  private Thumbnail thumbnail;
  private List<Image> images = new ArrayList<Image>();
  private Creators creators;
  private Characters characters;
  private Stories stories;
  private Events events;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDigitalId() {
    return digitalId;
  }

  public void setDigitalId(String digitalId) {
    this.digitalId = digitalId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIssueNumber() {
    return issueNumber;
  }

  public void setIssueNumber(String issueNumber) {
    this.issueNumber = issueNumber;
  }

  public String getVariantDescription() {
    return variantDescription;
  }

  public void setVariantDescription(String variantDescription) {
    this.variantDescription = variantDescription;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getModified() {
    return modified;
  }

  public void setModified(String modified) {
    this.modified = modified;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getUpc() {
    return upc;
  }

  public void setUpc(String upc) {
    this.upc = upc;
  }

  public String getDiamondCode() {
    return diamondCode;
  }

  public void setDiamondCode(String diamondCode) {
    this.diamondCode = diamondCode;
  }

  public String getEan() {
    return ean;
  }

  public void setEan(String ean) {
    this.ean = ean;
  }

  public String getIssn() {
    return issn;
  }

  public void setIssn(String issn) {
    this.issn = issn;
  }

  public String getFormat() {
    return format;
  }

  public void setFormat(String format) {
    this.format = format;
  }

  public String getPageCount() {
    return pageCount;
  }

  public void setPageCount(String pageCount) {
    this.pageCount = pageCount;
  }

  public List<TextObject> getTextObjects() {
    return textObjects;
  }

  public void setTextObjects(List<TextObject> textObjects) {
    this.textObjects = textObjects;
  }

  public String getResourceURI() {
    return resourceURI;
  }

  public void setResourceURI(String resourceURI) {
    this.resourceURI = resourceURI;
  }

  public List<Url> getUrls() {
    return urls;
  }

  public void setUrls(List<Url> urls) {
    this.urls = urls;
  }

  public Series getSeries() {
    return series;
  }

  public void setSeries(Series series) {
    this.series = series;
  }

  public List<Variant> getVariants() {
    return variants;
  }

  public void setVariants(List<Variant> variants) {
    this.variants = variants;
  }

  public List<Collection> getCollections() {
    return collections;
  }

  public void setCollections(List<Collection> collections) {
    this.collections = collections;
  }

  public List<CollectedIssue> getCollectedIssues() {
    return collectedIssues;
  }

  public void setCollectedIssues(List<CollectedIssue> collectedIssues) {
    this.collectedIssues = collectedIssues;
  }

  public List<Date> getDates() {
    return dates;
  }

  public void setDates(List<Date> dates) {
    this.dates = dates;
  }

  public List<Price> getPrices() {
    return prices;
  }

  public void setPrices(List<Price> prices) {
    this.prices = prices;
  }

  public Thumbnail getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(Thumbnail thumbnail) {
    this.thumbnail = thumbnail;
  }

  public List<Image> getImages() {
    return images;
  }

  public void setImages(List<Image> images) {
    this.images = images;
  }

  public Creators getCreators() {
    return creators;
  }

  public void setCreators(Creators creators) {
    this.creators = creators;
  }

  public Characters getCharacters() {
    return characters;
  }

  public void setCharacters(Characters characters) {
    this.characters = characters;
  }

  public Stories getStories() {
    return stories;
  }

  public void setStories(Stories stories) {
    this.stories = stories;
  }

  public Events getEvents() {
    return events;
  }

  public void setEvents(Events events) {
    this.events = events;
  }
}