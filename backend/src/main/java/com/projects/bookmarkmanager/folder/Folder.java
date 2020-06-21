package com.projects.bookmarkmanager.folder;


import com.projects.bookmarkmanager.bookmark.Bookmark;
import com.projects.bookmarkmanager.model.StateBased;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Folder extends StateBased {

    @Getter
    @Setter
    private String name;

    @Getter @Setter
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "folder")
    private List<Bookmark> bookmarkList;

    @Getter @Setter @OneToOne
    private Folder parentFolder;
}
