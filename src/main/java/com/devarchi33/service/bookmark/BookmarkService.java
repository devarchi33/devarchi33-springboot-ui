package com.devarchi33.service.bookmark;

import com.devarchi33.domain.mongo.Bookmark;
import com.devarchi33.persistance.mongo.repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by donghoon on 2016. 6. 18..
 */
@Service
public class BookmarkService {

    @Autowired
    private BookmarkRepository repository;

    public Bookmark save(Bookmark bookmark) {
        repository.save(bookmark);
        return bookmark;
    }

    public List<Bookmark> findAll() {
        return repository.findAll();
    }

    public Bookmark find(Integer id) {
        return repository.findOne(id);
    }

    public void delete(Integer id) {
        repository.delete(id);
    }

}
