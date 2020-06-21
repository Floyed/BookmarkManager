package com.projects.bookmarkmanager.folder;

import com.projects.bookmarkmanager.bookmark.Bookmark;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FolderRepository extends CrudRepository<Folder, Integer> {

    @Query("select folder from Folder folder where folder.parentFolder = NULL order by folder.name")
    public List<Folder> getRootFolders();

    @Query("select folder from Folder folder where folder.parentFolder.id = :folderId")
    public List<Folder> getFoldersInFolder(@Param("folderId") Integer folderId);
}
