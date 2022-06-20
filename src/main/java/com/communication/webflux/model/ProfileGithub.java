package com.communication.webflux.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class ProfileGithub {

    @Id
    private String id;

    private String name;

    private List<Repository> repositories;

    public ProfileGithub() {

    }

    public ProfileGithub(String id, String name, List<Repository> repositories) {
        this.id = id;
        this.name = name;
        this.repositories = repositories;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Repository> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
    }

    @Override
    public String toString() {
        return "ProfileGithub{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", repositories=" + repositories +
                '}';
    }
}
