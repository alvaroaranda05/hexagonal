package com.varitoooo.hexagonal.project.application;

public final class ProjectResponse {
    private final int id;
    private final String name;

    public ProjectResponse(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
