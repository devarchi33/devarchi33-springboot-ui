package com.devarchi33.persistance.mongo.repository;

import com.devarchi33.domain.mongo.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by donghoon on 2016. 6. 18..
 */
public interface CategoryRepository extends MongoRepository<Category, Integer> {
}
