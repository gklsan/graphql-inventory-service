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

  public Product createProduct(String name, String category, double price, int stock) {
    Product product = new Product(name, category, price, stock);

    return productRepository.save(product);
  }

  public Product updateProduct(Long id, String name, String category, double price, int stock) {
    Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    product.setName(name);
    product.setCategory(category);
    product.setPrice(price);
    product.setStock(stock);
    productRepository.save(product);

    return product;
  }

  public Product deleteProduct(Long id) {
    Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    productRepository.delete(product);
    return product;
  }

  public Product updateStock(Long id, int stock) {
    Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    product.setStock(product.getStock() + stock);
    productRepository.save(product);
    return product;
  }
}
