package org.gklsan.springboot.inventoryservice.service;

import org.gklsan.springboot.inventoryservice.entitys.Product;
import org.gklsan.springboot.inventoryservice.repository.ProductReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

  @Autowired
  private ProductReporsitory productRepository;

  public List<Product> getProducts() {
    return productRepository.findAll();
  }

  public List<Product> getProductsByCategory(String category) {
    return productRepository.findByCategory(category);
  }

}
