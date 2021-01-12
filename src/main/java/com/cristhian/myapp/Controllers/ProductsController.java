package com.cristhian.myapp.Controllers;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import com.cristhian.myapp.Models.Product;
import com.cristhian.myapp.Responses.ProductsResponse;
import com.cristhian.myapp.Services.ProductsService;
import com.cristhian.myapp.Exceptions.ResourceNotFoundException;


@CrossOrigin(origins = "htpp://localhost:4200")
@RestController
public class ProductsController {

  @GetMapping("/api/products")
  public ResponseEntity<ProductsResponse> getProducts() {
    Product[] products = ProductsService.getProducts();
    ProductsResponse response = new ProductsResponse(products);
    return ResponseEntity.ok().body(response);
  }
  
  @GetMapping("/api/products/{id}")
  public ResponseEntity<ProductsResponse> getProduct(@PathVariable String id) {
    if (id != null) {
      int productId = Integer.parseInt(id);
      Product product = ProductsService.getProduct(productId);
      if (product != null) {
        ProductsResponse response = new ProductsResponse(product);
        return ResponseEntity.ok().body(response);
      }
    }
    throw new ResourceNotFoundException("product not found");
  }

  @GetMapping(value = "/api/products/img/{fileName}", produces = MediaType.IMAGE_JPEG_VALUE)
  public @ResponseBody byte[] getImg(@PathVariable String fileName) {
    if (fileName != null) {
      try {
        Resource resource = new ClassPathResource(
          "../resources/static/img/"+fileName,
          getClass()
        );
        InputStream inputStream = resource.getInputStream();
        return IOUtils.toByteArray(inputStream);
      } catch(IOException e) {
        System.out.println(e);
      }
    }
    throw new ResourceNotFoundException("img not found");
  }

  @GetMapping("/api/products/search/{text}")
  public ResponseEntity<ProductsResponse> searchByTitle(@PathVariable String text) {
    if (!text.equals(null)) {
      text = text.toLowerCase();
      ArrayList<Product> products = ProductsService.searchByTitle(text);
      ProductsResponse response = new ProductsResponse(products);
      return ResponseEntity.ok().body(response);
    }
    throw new ResourceNotFoundException("no text sended");
  }

  // PRUEBAS
  // @GetMapping(value = "/api/img", produces = MediaType.IMAGE_PNG_VALUE)
  // public @ResponseBody byte[] getProductImage() throws IOException {
  //   String fileName = "desinfectante-de-superficies.png";
  //   Resource resource = new ClassPathResource(
  //     "../resources/static/img/"+fileName,
  //     getClass()
  //   );
  //   InputStream inputStream = resource.getInputStream();
  //   return IOUtils.toByteArray(inputStream);
  // }

  // @GetMapping("/api/product")
  // public ResponseEntity<Product> getProduct() {
  //   Product product = ProductsService.getProduct(1);
  //   return ResponseEntity.ok().body(product);
  // }

}