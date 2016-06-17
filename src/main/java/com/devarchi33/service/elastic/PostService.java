package com.devarchi33.service.elastic;

import com.devarchi33.domain.elastic.Post;
import com.devarchi33.persistance.elasticsearch.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Created by donghoon on 2016. 6. 17..
 */
@Service
public class PostService implements IPostService {

    @Autowired
    private PostRepository repository;

    @Override
    public Post save(Post post) {
        repository.save(post);
        return post;
    }

    @Override
    public Post findOne(String id) {
        return repository.findOne(id);
    }

    @Override
    public Iterable<Post> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Post> findByTagsName(String tagName, PageRequest pageRequest) {
        return repository.findByTagsName(tagName, pageRequest);
    }
}
