package com.products.webclient.repository;

import com.products.webclient.model.Products;
import org.reactivestreams.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products,Long> {

}
