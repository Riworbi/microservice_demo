package com.demo.microservice.demo_microservice.product.repository;

import com.demo.microservice.demo_microservice.product.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {

}
