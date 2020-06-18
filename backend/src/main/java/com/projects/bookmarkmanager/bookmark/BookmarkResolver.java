package com.projects.bookmarkmanager.bookmark;

import com.projects.bookmarkmanager.repository.MetaRepository;
import graphql.kickstart.tools.GraphQLResolver;

import java.util.List;

public class BookmarkResolver implements GraphQLResolver<Bookmark> {

    private final MetaRepository metaRepository;

    public BookmarkResolver(MetaRepository metaRepository){
        this.metaRepository = metaRepository;
    }

}
