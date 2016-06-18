package com.devarchi33.service.blog;

import com.devarchi33.domain.elastic.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * Created by donghoon on 2016. 6. 17..
 */
public interface IPostService {

    Post save(Post post);

    Post findOne(String id);

    Iterable<Post> findAll();

    Page<Post> findByTagsName(String tagName, PageRequest pageRequest);

}
