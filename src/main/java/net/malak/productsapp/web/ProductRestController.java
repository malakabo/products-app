package net.malak.productsapp.web;


import net.malak.productsapp.entities.Product;
import net.malak.productsapp.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class ProductRestController {
    private final ProductRepository productRepository;

    public ProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<Product> productList() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product findById(@PathVariable(name = "id") Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/products/{id}")
    public void deleteById(@PathVariable(name = "id") Long id) {
        productRepository.deleteById(id);
    }
}
