package org.gklsan.springboot.inventoryservice;

import jakarta.annotation.PostConstruct;
import org.gklsan.springboot.inventoryservice.entitys.Product;
import org.gklsan.springboot.inventoryservice.repository.ProductReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class InventoryServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(InventoryServiceApplication.class, args);
  }

  @Autowired
  private ProductReporsitory productReporsitory;

  @PostConstruct
  public void initDB() {
    List<Product> products = Stream.of(
        new Product("Laptop", "Electronics", 1200.0, 10),
        new Product("Mobile", "Electronics", 800.0, 20),
        new Product( "Shirt", "Fashion", 35.0, 50),
        new Product( "Shoe", "Fashion", 60.0, 30),
        new Product("Television", "Electronics", 2000.0, 15)
    ).collect(Collectors.toList());

    productReporsitory.saveAll(products);
  }

}
