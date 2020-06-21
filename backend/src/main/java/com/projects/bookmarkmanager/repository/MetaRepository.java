package com.projects.bookmarkmanager.repository;

import com.projects.bookmarkmanager.bookmark.BookmarkRepository;
import com.projects.bookmarkmanager.folder.FolderRepository;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component @Slf4j
public class MetaRepository {

    @Getter @Setter
    private final BookmarkRepository bookmarkRepository;

    @Getter @Setter
    private final FolderRepository folderRepository;

    MetaRepository(BookmarkRepository bookmarkRepository, FolderRepository folderRepository){
        this.bookmarkRepository = bookmarkRepository;
        this.folderRepository = folderRepository;
    }
}
