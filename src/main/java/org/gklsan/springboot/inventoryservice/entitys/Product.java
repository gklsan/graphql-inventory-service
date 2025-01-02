package org.gklsan.springboot.inventoryservice.entitys;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String category;
  private double price;
  private int stock;

  public Product(String name, String category, double price, int stock) {
    this.name = name;
    this.category = category;
    this.price = price;
    this.stock = stock;
  }
}
