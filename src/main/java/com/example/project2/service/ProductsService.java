package com.example.project2.service;


import com.example.project2.model.Categories;
import com.example.project2.model.Generics;
import com.example.project2.model.Products;
import com.example.project2.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {
    @Autowired
    ProductsRepository productsRepository;

    @Autowired GenericsService genericsService;

    public Products findById(int id){
        return productsRepository.findById(id);
    }
    public Products create(Products products){
        int genid = products.getGenericId();
        Generics gen = genericsService.findById(genid);
        if(gen == null){
            return null;
        }
        products.setGenericsByGenericId(gen);
        productsRepository.save(products);
        return products;
    }

    public Products update(int id, Products products){
        int genid = products.getGenericId();
        Generics gen = genericsService.findById(genid);
        if(gen == null){
            return null;
        }

        products.setGenericsByGenericId(gen);
        products.setId(products.getId());

        Products updated = productsRepository.findById(id);
        if(updated == null) return null;
        products.setId(updated.getId());
        products.setCreatedAt(updated.getCreatedAt());
        productsRepository.save(products);
        return products;
    }

    public boolean delete(int id){
        Products products = productsRepository.findById(id);
        if(products == null) return false;
        productsRepository.delete(products);
        return true;
    }
}
