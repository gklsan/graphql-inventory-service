package org.gklsan.springboot.inventoryservice.repository;

import org.gklsan.springboot.inventoryservice.entitys.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductReporsitory extends JpaRepository<Product, Long> {
  List<Product> findByCategory(String category);
}
