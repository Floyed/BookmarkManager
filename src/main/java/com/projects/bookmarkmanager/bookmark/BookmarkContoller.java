package com.projects.bookmarkmanager.bookmark;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @Slf4j
@RequestMapping("/bookmark")
public class BookmarkContoller {

    @Autowired
    BookmarkRepository bookmarkRepository;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Bookmark>> getBookmarks(){
        log.info("Receinging GET");
        return new ResponseEntity<List<Bookmark>>(Lists.newArrayList(bookmarkRepository.findAll()), HttpStatus.OK);
    }
}
