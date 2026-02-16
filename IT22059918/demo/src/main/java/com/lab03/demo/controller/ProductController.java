package com.lab03.demo.controller;

import com.lab03.demo.model.Product;
import com.lab03.demo.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {

    private final ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    // POST
    @PostMapping
    public Product create(@RequestBody Product product) {
        return repo.save(product);
    }

    // GET ALL
    @GetMapping
    public List<Product> getAll() {
        return repo.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
