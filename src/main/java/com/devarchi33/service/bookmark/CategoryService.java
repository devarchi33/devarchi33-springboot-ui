package com.devarchi33.service.bookmark;

import com.devarchi33.domain.mongo.Category;
import com.devarchi33.persistance.mongo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by donghoon on 2016. 6. 18..
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category save(Category category) {
        repository.save(category);
        return category;
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category find(Integer id) {
        return repository.findOne(id);
    }

    public void delete(Integer id) {
        repository.delete(id);
    }

}
