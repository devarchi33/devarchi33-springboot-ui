package com.devarchi33.domain.elastic;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

/**
 * Created by donghoon on 2016. 6. 17..
 */
@Data
@Document(indexName = "posts", type = "post", shards = 1, replicas = 0)
public class Post {

    @Id
    private String id;
    private String title;

    @Field(type = FieldType.Nested)
    private List<Tag> tags;

}
