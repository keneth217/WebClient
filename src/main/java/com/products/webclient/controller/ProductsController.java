package com.products.webclient.controller;

import com.products.webclient.model.Products;
import com.products.webclient.repository.ProductsRepository;
import com.products.webclient.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private final ProductsService productService;

    @Autowired
    public ProductsController(ProductsService productService) {
        this.productService = productService;
    }

    @GetMapping("/fetch-and-save")
    public Mono<Void> fetchAndSaveProducts() {
        return productService.fetchAndSaveProducts();
    }

    @GetMapping
    public Flux<Products> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Mono<Products> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Mono<Products> createProduct(@RequestBody Products product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Mono<Products> updateProduct(@PathVariable Long id, @RequestBody Products productDetails) {
        return productService.updateProduct(id, productDetails);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
