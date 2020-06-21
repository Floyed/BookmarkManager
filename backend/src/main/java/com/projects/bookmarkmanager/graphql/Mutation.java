package com.projects.bookmarkmanager.graphql;

import com.projects.bookmarkmanager.bookmark.Bookmark;
import com.projects.bookmarkmanager.folder.Folder;
import com.projects.bookmarkmanager.model.enums.Status;
import com.projects.bookmarkmanager.repository.MetaRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.lang.Nullable;

public class Mutation implements GraphQLMutationResolver {

    private final MetaRepository metaRepository;

    public Mutation(MetaRepository metaRepository){
        this.metaRepository = metaRepository;
    }

}
