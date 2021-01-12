package com.cristhian.myapp.Mocks;

import java.util.concurrent.atomic.AtomicInteger;
import com.cristhian.myapp.Models.CartProduct;

public class CartProductsMock {
  private static AtomicInteger productIdFaker = new AtomicInteger();
  private static int unitsFaker = 2;

  public static CartProduct[] CART_PRODUCTS = {
    new CartProduct(productIdFaker.incrementAndGet(), unitsFaker),
    new CartProduct(productIdFaker.incrementAndGet(), unitsFaker),
    new CartProduct(productIdFaker.incrementAndGet(), unitsFaker),
    new CartProduct(productIdFaker.incrementAndGet(), unitsFaker),
    new CartProduct(productIdFaker.incrementAndGet(), unitsFaker),
    new CartProduct(productIdFaker.incrementAndGet(), unitsFaker),
    new CartProduct(productIdFaker.incrementAndGet(), unitsFaker),
    new CartProduct(productIdFaker.incrementAndGet(), unitsFaker),
    new CartProduct(productIdFaker.incrementAndGet(), unitsFaker),
    new CartProduct(productIdFaker.incrementAndGet(), unitsFaker),
  };
}
