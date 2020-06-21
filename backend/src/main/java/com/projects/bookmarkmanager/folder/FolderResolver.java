package com.projects.bookmarkmanager.folder;

import com.projects.bookmarkmanager.bookmark.Bookmark;
import com.projects.bookmarkmanager.model.enums.Status;
import com.projects.bookmarkmanager.repository.MetaRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.List;

public class FolderResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final MetaRepository metaRepository;

    public FolderResolver(MetaRepository metaRepository){
        this.metaRepository = metaRepository;
    }

    public Iterable<Folder> getAllFolders(){
        return metaRepository.getFolderRepository().findAll();
    }

    public Iterable<Folder> getRootFolders() {
        return this.metaRepository.getFolderRepository().getRootFolders();
    }

    public Iterable<Folder> getFoldersInFolder(Integer folderId) {
        return this.metaRepository.getFolderRepository().getFoldersInFolder(folderId);
    }

    public Folder createFolder(String name, @Nullable Integer parentFolderId){

        Folder folder = new Folder();
        folder.setName(name);
        folder.setStatus(Status.ACTIVE);
        folder.setCreatedTimeStamp(new Date());

        if(parentFolderId != null){
            Folder parentFolder = metaRepository.getFolderRepository().findById(parentFolderId).get();
            folder.setParentFolder(parentFolder);
        }

        return metaRepository.getFolderRepository().save(folder);

    }
}
