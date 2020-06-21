package com.projects.bookmarkmanager.model;

import com.projects.bookmarkmanager.model.enums.Status;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class StateBased extends Base{

    @Column
    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private Status status;

    @Getter @Setter
    private Date createdTimeStamp;

}
