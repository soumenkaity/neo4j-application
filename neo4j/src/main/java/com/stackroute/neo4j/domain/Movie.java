package com.stackroute.neo4j.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Id;

@NodeEntity
public class Movie {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String director;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Movie(Long id, String title, String director) {
        this.id = id;
        this.title = title;
        this.director = director;
    }

    public Movie() {
    }
}
