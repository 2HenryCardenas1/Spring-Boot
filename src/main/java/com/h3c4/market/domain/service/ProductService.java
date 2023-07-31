package com.h3c4.market.domain.service;


import com.h3c4.market.domain.Product;
import com.h3c4.market.domain.repository.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired //Inyeccion de dependencias
    private ProductRespository productRespository;


    //Get all products

    public List<Product> getAll(){
        return productRespository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productRespository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productRespository.getByCategory(categoryId);
    }

    public Product save(Product product){
        return productRespository.save(product);
    }

    public boolean delete(int productId){
        return getProduct(productId).map(product -> {
            productRespository.delete(productId);
            return true;
        }).orElse(false);
    }


}
