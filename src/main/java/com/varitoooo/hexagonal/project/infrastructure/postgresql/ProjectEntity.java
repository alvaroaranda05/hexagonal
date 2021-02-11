package com.varitoooo.hexagonal.project.infrastructure.postgresql;

import javax.persistence.*;

@Entity
@Table(name = "project")
public final class ProjectEntity {
    @Id
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private int id;

    @Basic
    @Column(name = "name", nullable = false, length = 250)
    private String name;

    public ProjectEntity() {
    }

    public ProjectEntity(int id, String name) {
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
