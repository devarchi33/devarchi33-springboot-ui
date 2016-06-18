package com.devarchi33.web.bookmark;

import com.devarchi33.domain.mongo.Category;
import com.devarchi33.service.mongo.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by donghoon on 2016. 6. 18..
 */
@RestController
@RequestMapping("categories")
public class CategoryController {

    private Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> getCategoryList() {
        logger.info("카테고리 리스트..");

        return service.findAll();
    }
}
