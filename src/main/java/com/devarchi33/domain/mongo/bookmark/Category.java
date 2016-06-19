package com.devarchi33.domain.mongo.bookmark;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by donghoon on 2016. 6. 18..
 */

@Data
@Document(collection = "categories")
public class Category {

    @Id
    private Integer id;
    private String name;

}
