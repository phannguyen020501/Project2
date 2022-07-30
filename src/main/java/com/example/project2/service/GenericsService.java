
package com.example.project2.service;

import com.example.project2.model.Categories;
import com.example.project2.model.Generics;
import com.example.project2.model.Generics;
import com.example.project2.repository.GenericsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenericsService {
    @Autowired
    GenericsRepository genericsRepository;
    @Autowired CategoriesService categoriesService;


    public Generics findById(int id){
        return genericsRepository.findById(id);
    }
    public Generics create(Generics generics){
        int cateid = generics.getCategoryId();
        Categories cate1 = categoriesService.findCategoriesById(cateid);
        if(cate1 == null){
            return null;
        }
        generics.setCategoriesByCategoryId(cate1);
        genericsRepository.save(generics);
        return generics;
    }

    public Generics update(int id, Generics generics){
        Generics gen1 = genericsRepository.findById(id);
        if(gen1 == null) return null;
        int cateid = generics.getCategoryId();

        Categories cate1 = categoriesService.findCategoriesById(cateid);
        if(cate1 == null){
            return null;
        }

        generics.setCategoriesByCategoryId(cate1);
        generics.setId(gen1.getId());
        Generics updated = genericsRepository.findById(id);
        if(updated == null) return null;
        generics.setId(updated.getId());
        generics.setCreatedAt(updated.getCreatedAt());

        genericsRepository.save(generics);
        return generics;
    }

    public boolean delete(int id){
        Generics gen1 = genericsRepository.findById(id);
        if(gen1 == null) return false;
        genericsRepository.delete(gen1);
        return true;
    }
}
