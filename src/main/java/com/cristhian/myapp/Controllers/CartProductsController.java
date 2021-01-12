package com.cristhian.myapp.Controllers;

import com.cristhian.myapp.Exceptions.ResourceNotFoundException;
import com.cristhian.myapp.Models.CartProduct;
import com.cristhian.myapp.Services.CartProductsService;
import com.cristhian.myapp.Responses.CartProductsResponse;
import com.cristhian.myapp.Responses.HttpStatusCodes;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "htpp://localhost:4200")
@RestController
public class CartProductsController {

  private CartProductsService cartProductsService = new CartProductsService();

  @GetMapping("/api/cart")
  public ResponseEntity<CartProductsResponse> getCartProducts() {
    CartProduct[] cardProducts = cartProductsService.getCartProducts();
    return ResponseEntity.ok().body(new CartProductsResponse(
      HttpStatusCodes.STATUS_OK,
      cardProducts,
      null,
      HttpStatusCodes.STATUS_CODE_OK
    ));
  }

  @GetMapping("/api/cart/count")
  public ResponseEntity<Integer> getProductsCounter() {
    int productsCounter = cartProductsService.getTotalUnits();
    return ResponseEntity.ok().body(productsCounter);
  }

  @DeleteMapping("/api/cart/{productId}")
  public ResponseEntity<CartProductsResponse> discardCartProduct(@PathVariable String productId) {
    if (!productId.equals(null)) {
      int id = Integer.parseInt(productId);
      CartProduct cartProduct = cartProductsService.getCartProduct(id);
      if (cartProductsService.discardCartProduct(id)) {
        return ResponseEntity.ok().body(new CartProductsResponse(
          "deleted",
          cartProduct,
          null,
          HttpStatusCodes.STATUS_CODE_OK
        ));
      }
    }
    throw new ResourceNotFoundException("cart product not found");
  }
}