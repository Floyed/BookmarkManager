package com.projects.bookmarkmanager.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class StateBased extends Base{

    @Column
    @Getter @Setter
    private String status;

}
