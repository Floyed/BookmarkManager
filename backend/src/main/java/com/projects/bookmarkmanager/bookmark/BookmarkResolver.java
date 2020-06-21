package com.projects.bookmarkmanager.bookmark;

import com.projects.bookmarkmanager.folder.Folder;
import com.projects.bookmarkmanager.model.enums.Status;
import com.projects.bookmarkmanager.repository.MetaRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.lang.Nullable;

import java.awt.print.Book;
import java.util.Date;
import java.util.List;

public class BookmarkResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final MetaRepository metaRepository;

    public BookmarkResolver(MetaRepository metaRepository){
        this.metaRepository = metaRepository;
    }

    public Iterable<Bookmark> getAllBookMarks(){
        return metaRepository.getBookmarkRepository().findAll();
    }

    public Iterable<Bookmark> getRootBookmarks() {
        return this.metaRepository.getBookmarkRepository().getRootBookmarks();
    }

    public Iterable<Bookmark> getBookmarksInFolder(Integer folderId) {
        return this.metaRepository.getBookmarkRepository().getBookmarksInFolder(folderId);
    }

    public Bookmark createBookmark(@Nullable String name, @Nullable Integer folderId, String url){

        Bookmark bookmark = new Bookmark();
        bookmark.setName(name);
        bookmark.setStatus(Status.ACTIVE);
        bookmark.setCreatedTimeStamp(new Date());
        bookmark.setUrl(url);

        if(folderId != null){
            Folder parentFolder = metaRepository.getFolderRepository().findById(folderId).get();
            bookmark.setFolder(parentFolder);
        }

        return metaRepository.getBookmarkRepository().save(bookmark);

    }
}
