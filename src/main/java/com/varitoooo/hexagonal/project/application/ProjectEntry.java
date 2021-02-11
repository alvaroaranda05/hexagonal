package com.varitoooo.hexagonal.project.application;

public final class ProjectEntry {
    private final Integer id;
    private final String name;

    public ProjectEntry(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
