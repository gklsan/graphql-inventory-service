package org.gklsan.springboot.inventoryservice.controllers;

import org.gklsan.springboot.inventoryservice.entitys.Product;
import org.gklsan.springboot.inventoryservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping
  public List<Product> getProducts() {
    return productService.getProducts();
  }

  @GetMapping("/{category}")
  public List<Product> getProductsByCategory(@PathVariable String category) {
    return productService.getProductsByCategory(category);
  }
}
