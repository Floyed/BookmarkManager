package com.projects.bookmarkmanager.bookmark;

import com.projects.bookmarkmanager.folder.Folder;
import com.projects.bookmarkmanager.model.StateBased;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Bookmark extends StateBased {

    @Getter @Setter
    private String url;

    @Getter @Setter
    private String path;

    @Getter @Setter
    private String name;

    @OneToOne @Getter @Setter
    private Folder folder;
}
