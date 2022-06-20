package com.communication.webflux.model;

import java.util.List;

public class Repository {

    private String name;

    private String description;

    private List<String> languages;

    public Repository() {
    }

    public Repository(String name, String description, List<String> languages) {
        this.name = name;
        this.description = description;
        this.languages = languages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", languages=" + languages +
                '}';
    }
}
