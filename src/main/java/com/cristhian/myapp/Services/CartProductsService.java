package com.cristhian.myapp.Services;

import com.cristhian.myapp.Models.CartProduct;

import java.util.Arrays;
import java.util.List;

import com.cristhian.myapp.Mocks.CartProductsMock;

public class CartProductsService {
  private CartProduct[] cartProducts;
  private int totalUnits;

  public CartProductsService() {
    this.cartProducts = CartProductsMock.CART_PRODUCTS;
    this.totalUnits = this.countUnits();
  }

  public CartProduct[] getCartProducts() {
    return this.cartProducts;
  }

  public CartProduct getCartProduct(int id) {
    for (CartProduct cartProduct : this.cartProducts) {
      if (id == cartProduct.getProductId()) {
        return cartProduct;
      }
    }
    return null;
  }

  public int getTotalUnits() {
    return this.totalUnits;
  }

  public int countUnits() {
    int totalUnits = 0;
    for (CartProduct cartProduct : this.cartProducts) {
      int units = cartProduct.getUnits(); 
      totalUnits += units;
    }
    return totalUnits;
  }

  public boolean existsOnCartProducts(int id) {
    for (CartProduct cartProduct : this.cartProducts) {
      if (id == cartProduct.getProductId()) {
        return true;
      }
    }
    return false;
  }

  public boolean discardCartProduct(int id) { // doesn´t work
    List<CartProduct> cartProducts = Arrays.asList(this.cartProducts);
    for (int i = 0; i < cartProducts.size(); i++) {
      int productId = cartProducts.get(i).getProductId();
      if (id == productId) {
        this.cartProducts[i] = null;
        // cartProducts.remove(i);
        // this.cartProducts = cartProducts.toArray(this.cartProducts);
        return true;
      }
    }
    return false;
  }
}
