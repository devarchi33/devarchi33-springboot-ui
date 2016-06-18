package com.devarchi33.web.bookmark;

import com.devarchi33.domain.mongo.Bookmark;
import com.devarchi33.service.mongo.BookmarkService;
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
@RequestMapping("bookmarks")
public class BookmarkController {

    private Logger logger = LoggerFactory.getLogger(BookmarkController.class);

    @Autowired
    private BookmarkService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Bookmark> getBookmarkList() {
        logger.info("북마크 리스트..");

        return service.findAll();
    }
}
