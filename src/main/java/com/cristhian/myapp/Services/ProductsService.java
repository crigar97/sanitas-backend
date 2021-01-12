package com.cristhian.myapp.Services;

import java.util.ArrayList;

import com.cristhian.myapp.Mocks.ProductsMock;
import com.cristhian.myapp.Models.Product;

public class ProductsService {

  private static Product[] products = ProductsMock.PRODUCTS; 

  public static Product[] getProducts() {
    return products;
  }

  public static Product getProduct(int id) {
    for (Product product : products) {
      int productId = product.getId();
      if (productId == id) {
        return product;
      }
    }
    return null;
  }

  public static ArrayList<Product> searchByTitle(String text) {
    ArrayList<Product> productsThatMatched = new ArrayList<>();
    for (Product product : products) {
      String title = product.getTitle().toLowerCase();
      if (title.contains(text)) {
        productsThatMatched.add(product);
      }
    }
    return productsThatMatched;
  }

}