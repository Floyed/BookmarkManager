package com.projects.bookmarkmanager.bookmark;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BookmarkRepository extends Repository<Bookmark, Integer> {

    @Query("SELECT bookmark FROM Bookmark bookmark WHERE bookmark.id =:id")
    @Transactional(readOnly = true)
    Bookmark findById(@Param("id") Integer id);

    @Transactional(readOnly = true)
    Iterable<Bookmark> findAll();


    void save(Bookmark owner);
}
