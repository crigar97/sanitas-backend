package com.cristhian.myapp.Models;

public class CartProduct {
  private int productId;
  private int units;

  public CartProduct(int productId, int units) {
    this.productId = productId;
    this.units = units;
  }

  public int getProductId() {
    return this.productId;
  }

  public int getUnits() {
    return this.units;
  }
}
