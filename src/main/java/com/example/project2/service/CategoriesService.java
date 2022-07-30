package com.example.project2.service;

import com.example.project2.model.Categories;
import com.example.project2.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    public Categories findCategoriesById(int id){
        return categoriesRepository.findById(id);
    }
    public Categories create(Categories categories){
        categoriesRepository.save(categories);
        return categories;
    }

    public Categories update(int id, Categories categories){
       Categories cate1 = categoriesRepository.findById(id);
       if(cate1 == null) return null;
       categories.setId(cate1.getId());
       categories.setCreatedAt(cate1.getCreatedAt());

       categoriesRepository.save(categories);
       return categories;
    }

    public boolean delete(int id){
        Categories cate1 = categoriesRepository.findById(id);
        if(cate1 == null) return false;
        categoriesRepository.delete(cate1);
        return true;
    }
}
