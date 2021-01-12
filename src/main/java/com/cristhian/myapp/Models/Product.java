package com.cristhian.myapp.Models;

public class Product {

  private final int id;
  private final String title;
  private final String description;
  private final float price;
  private final String img;
  private final String[] tags;

  public Product(int id, String title, String description, float price, String img, String[] tags) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.price = price;
    this.img = img;
    this.tags = tags;
  }

  public int getId() {
    return this.id;
  }

  public String getTitle() {
    return this.title;
  }

  public String getDescription() {
    return this.description;
  }

  public float getPrice() {
    return this.price;
  }

  public String getImg() {
    return this.img;
  }

  public String[] getTags() {
    return this.tags;
  }

}