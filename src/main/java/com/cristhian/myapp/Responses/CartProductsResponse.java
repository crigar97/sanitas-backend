package com.cristhian.myapp.Responses;

public class CartProductsResponse {
  private String status;
  private Object data;
  private String error;
  private int statusCode;

  public CartProductsResponse(String status, Object data, String error, int statusCode) {
    this.status = status;
    this.data = data;
    this.error = error;
    this.statusCode = statusCode;
  }

  public String getStatus() {
    return this.status;
  }

  public Object getData() {
    return this.data;
  }

  public String getError() {
    return this.error;
  }

  public int getStatusCode() {
    return this.statusCode;
  }
}
