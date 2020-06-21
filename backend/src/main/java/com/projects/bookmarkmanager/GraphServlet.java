package com.projects.bookmarkmanager;

import com.projects.bookmarkmanager.bookmark.BookmarkResolver;
import com.projects.bookmarkmanager.folder.FolderResolver;
import com.projects.bookmarkmanager.graphql.Mutation;
import com.projects.bookmarkmanager.graphql.Query;
import com.projects.bookmarkmanager.repository.MetaRepository;
import graphql.kickstart.execution.GraphQLObjectMapper;
import graphql.kickstart.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import graphql.servlet.GraphQLConfiguration;
import graphql.servlet.GraphQLHttpServlet;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebServlet;

/**
 * This servlet serves up our GraphQL API. If you are adding a new resolver, modify the {@code createSchema} function.
 */
@WebServlet(name = "GraphServlet", urlPatterns = {"graphql/*"}, loadOnStartup = 1) @Slf4j
public class GraphServlet extends GraphQLHttpServlet {

    public final MetaRepository metaRepository;

    public GraphServlet(MetaRepository metaRepository){
        this.metaRepository = metaRepository;
    }

    @Override
    protected GraphQLConfiguration getConfiguration() {
        return GraphQLConfiguration
                .with(createSchema())
                .with(GraphQLObjectMapper.newBuilder().withGraphQLErrorHandler(errors -> {
                    for (var e : errors) {
                        // TODO: maybe improve this error logging?
                        log.info("GraphQL error: {}", e);
                    }
                    return errors;
                }).build())
                .build();
    }

    private GraphQLSchema createSchema() {
        SchemaParser schemaParser = SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(
                        new Query(metaRepository),
                        new Mutation(metaRepository),
                        new BookmarkResolver(metaRepository),
                        new FolderResolver(metaRepository)
                ).build();

        return schemaParser.makeExecutableSchema();
    }

}