package net.malak.productsapp;

import net.malak.productsapp.entities.Product;
import net.malak.productsapp.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductsAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductsAppApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder()
                    .name("Computer").price(5400).quantity(12).selected(true).build());
            productRepository.save(Product.builder()
                    .name("Printer").price(1200).quantity(5).selected(false).build());
            productRepository.save(Product.builder()
                    .name("Smart Phone").price(3200).quantity(8).selected(true).build());
        };
    }
}
