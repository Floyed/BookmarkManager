package com.projects.bookmarkmanager.repository;

import com.projects.bookmarkmanager.bookmark.BookmarkRepository;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component @Slf4j
public class MetaRepository {

    @Getter @Setter
    private final BookmarkRepository bookmarkRepository;

    MetaRepository(BookmarkRepository bookmarkRepository){
        this.bookmarkRepository = bookmarkRepository;
    }
}
