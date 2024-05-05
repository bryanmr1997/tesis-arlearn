package com.arlearn.tesis.tesisuns.models;

import javax.persistence.*;

@Entity
@Table(name = "arimages")
public class ArImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    private String uri;

    private String description;


    private String state;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ArImages() {
    }

    public ArImages(String name, String uri, String description, String state) {
        this.name = name;
        this.uri = uri;
        this.description = description;
        this.state = state;
    }
}
