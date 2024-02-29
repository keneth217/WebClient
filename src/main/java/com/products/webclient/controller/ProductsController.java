package com.products.webclient.controller;


import com.products.webclient.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;


@RestController
@RequestMapping("/api/products") // Adjusted endpoint to match the entity being handled
public class ProductsController {
    @Autowired
    private  WebClient.Builder webClientBuilder;
      Products products =  webClientBuilder.build()
            .get()
            .uri("https://dummyjson.com/products")
            .retrieve()
              .bodyToMono(Products.class)
              .block();

}
