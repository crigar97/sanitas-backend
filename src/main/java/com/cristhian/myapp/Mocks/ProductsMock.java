package com.cristhian.myapp.Mocks;

import java.util.concurrent.atomic.AtomicInteger;

import com.cristhian.myapp.Models.Product;

public class ProductsMock {

  private static AtomicInteger counter = new AtomicInteger();
  private static String routeForImg = "http://localhost:8080/api/products/img";

  public static Product[] PRODUCTS = {
    new Product(
      counter.incrementAndGet(),
      "Careta",
      "Careta de platico para persona adulta. Medidas 20.5x31.2 cm.",
      (float) 57,
      routeForImg+"/careta.jpg",
      new String[] { "uso personal" }
    ),
    new Product(
      counter.incrementAndGet(),
      "Cloro",
      "Galón de cloro (3,785 litros).",
      (float) 87,
      routeForImg+"/cloro.jpg",
      new String[] { "limpieza", "desinfectante" }
    ),
    new Product(
      counter.incrementAndGet(),
      "Cubrebocas KN-95",
      "Cubrebocas kn-95 color blaco para persona adulta.",
      (float) 75,
      routeForImg+"/cubrebocas-kn95.jpg",
      new String[] { "uso personal" }
    ),
    new Product(
      counter.incrementAndGet(),
      "Cubrebocas Tricapa",
      "Cubrebocas tricapa color azul para persona adulta.",
      (float) 15,
      routeForImg+"/cubrebocas-tricapa.png",
      new String[] { "uso personal" }
    ),
    new Product(
      counter.incrementAndGet(),
      "Desinfectante de Pisos",
      "Garrafón de desinfecta de pisos marca Limpiao 1.8 lts.",
      (float) 46,
      routeForImg+"/desinfectante-de-pisos.jpg",
      new String[] { "limpieza", "desinfectante" }
    ),
    new Product(
      counter.incrementAndGet(),
      "Desinfectante de Superficies",
      "Desinfectante para muebles, mesas, mostradores, etc. 2 piezas: garrafón de 2.5 lts y pistola rociadora.",
      (float) 87,
      routeForImg+"/desinfectante-de-superficies.png",
      new String[] { "limpieza", "desinfectante" }
    ),
    new Product(
      counter.incrementAndGet(),
      "Gel Actibacterial",
      "Botella de gel antibacterial 1 lt",
      (float) 69,
      routeForImg+"/gel-antibacterial.jpg",
      new String[] { "limpieza", "desinfectante" }
    ),
    new Product(
      counter.incrementAndGet(),
      "Jabón Líquido para Manos",
      "Botella de jabón líquido para manos 1 lt",
      (float) 76,
      routeForImg+"/jabon-liquido-para-manos.jpg",
      new String[] { "limpieza", "desinfectante" }
    ),
    new Product(
      counter.incrementAndGet(),
      "Papel Higiénico",
      "Rollo de papel suave y absorvente 700'",
      (float) 62,
      routeForImg+"/papel-higienico.jpg",
      new String[] { "limpieza", "uso personal" }
    ),
    new Product(
      counter.incrementAndGet(),
      "Toallas Desinfectantes",
      "Bote con 90 toallas. Ideal para desinfectar manos",
      (float) 94,
      routeForImg+"/toallas-desinfectantes.jpg",
      new String[] { "limpieza", "desinfectante", "uso personal" }
    ),
  };

}