package com.products.webclient.service;

import com.products.webclient.model.Products;
import com.products.webclient.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
@Service
public class ProductsService {
    private final WebClient webClient;

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsService(WebClient.Builder webClientBuilder, ProductsRepository productsRepository) {
        this.webClient = webClientBuilder.baseUrl("https://dummyjson.com").build();
        this.productsRepository = productsRepository;
    }

    public Mono<Void> fetchAndSaveProducts() {
        return webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToFlux(Products.class)
                .flatMap(productsRepository::save)
                .then();
    }
}
