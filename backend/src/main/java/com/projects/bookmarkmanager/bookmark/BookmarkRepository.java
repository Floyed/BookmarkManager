package com.projects.bookmarkmanager.bookmark;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookmarkRepository extends CrudRepository<Bookmark, Integer> {

    @Query("select bookmark from Bookmark bookmark where bookmark.folder = NULL")
    public List<Bookmark> getRootBookmarks();

    @Query("select bookmark from Bookmark bookmark where bookmark.folder.id = :folderId")
    public List<Bookmark> getBookmarksInFolder(@Param("folderId") Integer folderId);
}
