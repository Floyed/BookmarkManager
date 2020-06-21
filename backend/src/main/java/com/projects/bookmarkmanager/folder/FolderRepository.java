package com.projects.bookmarkmanager.folder;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FolderRepository extends CrudRepository<Folder, Integer> {

    @Query("select folder from Folder folder where folder.parentFolder = NULL order by folder.name")
    public List<Folder> getRootFolders();
}
