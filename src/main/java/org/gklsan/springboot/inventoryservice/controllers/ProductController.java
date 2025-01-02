package org.gklsan.springboot.inventoryservice.controllers;

import org.gklsan.springboot.inventoryservice.entitys.Product;
import org.gklsan.springboot.inventoryservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductController {

  @Autowired
  private ProductService productService;

  @QueryMapping
  public List<Product> getProducts() {
    return productService.getProducts();
  }

  @QueryMapping
  public List<Product> getProductsByCategory(@Argument String category) {
    return productService.getProductsByCategory(category);
  }

  @MutationMapping
  public Product createProduct(@Argument("product") ProductInput productInput) {
    return productService.createProduct(productInput.name, productInput.category, productInput.price, productInput.stock);
  }

  @MutationMapping
  public Product updateProduct(@Argument("product") ProductInput productInput) {
    return productService.updateProduct(
        productInput.id,
        productInput.name,
        productInput.category,
        productInput.price,
        productInput.stock
    );
  }

  @MutationMapping
  public Product deleteProduct(@Argument Long id) {
    return productService.deleteProduct(id);
  }

  @MutationMapping
  public Product updateStock(@Argument Long id, @Argument int stock) {
    return productService.updateStock(id, stock);
  }

  record ProductInput(Long id, String name, String category, double price, int stock) {}
}
