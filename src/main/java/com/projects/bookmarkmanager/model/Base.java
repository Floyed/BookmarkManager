package com.projects.bookmarkmanager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Base {

    @Id @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;



}
