package com.varitoooo.hexagonal.project.domain;

import java.util.Objects;

public final class Project {
    private final ProjectId id;
    private final ProjectName name;

    public Project(ProjectId id, ProjectName name) {
        this.id = id;
        this.name = name;
    }

    public static Project create(ProjectId id, ProjectName name) {
        return new Project(id, name);
    }

    public ProjectId getId() {
        return id;
    }

    public ProjectName getName() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;

        if (!(other instanceof Project)) return false;

        Project otherProject = (Project) other;
        return Objects.equals(id, otherProject.id) && Objects.equals(name, otherProject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
