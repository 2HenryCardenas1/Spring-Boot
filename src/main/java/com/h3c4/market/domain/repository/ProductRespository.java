package com.h3c4.market.domain.repository;

import com.h3c4.market.domain.Product;

import java.util.List;
import java.util.Optional;



public interface ProductRespository{
    List<Product> getAll();

    Optional<List<Product>> getByCategory(int categoryId);

    Optional<List<Product>> getScarseProducts(int quantity);

    Optional<Product> getProduct(int productId);

    Product save(Product product);

    void delete(int productId);

}
