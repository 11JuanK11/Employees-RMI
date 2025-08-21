package com.example1.demo1;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class CatalogController {
    
    @GetMapping("/")
    public List<Product> getProducts() {
        return List.of(
            new Product(1, "Laptop"),
            new Product(2, "Mouse"),
            new Product(3, "Teclado")
        );
    }

}
