package com.projects.bookmarkmanager.graphql;

import com.projects.bookmarkmanager.bookmark.Bookmark;
import com.projects.bookmarkmanager.repository.MetaRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.ArrayList;
import java.util.List;

public class Query implements GraphQLQueryResolver {

    private final MetaRepository metaRepository;

    public Query(MetaRepository metaRepository){
        this.metaRepository = metaRepository;
    }

    public Iterable<Bookmark> getBookMarks(){
        return metaRepository.getBookmarkRepository().findAll();
    }

}
