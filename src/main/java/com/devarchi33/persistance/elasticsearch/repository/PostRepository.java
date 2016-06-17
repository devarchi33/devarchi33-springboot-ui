package com.devarchi33.persistance.elasticsearch.repository;

import com.devarchi33.domain.elastic.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by donghoon on 2016. 6. 17..
 */
public interface PostRepository extends ElasticsearchRepository<Post, String> {

//    @Query("{\"posts\" : {\"tags\" : {\"field\" : {\"name\" : \"?0\"}}}}")
    Page<Post> findByTagsName(String name, Pageable pageable);
}
