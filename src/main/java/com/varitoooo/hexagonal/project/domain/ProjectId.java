package com.varitoooo.hexagonal.project.domain;

public final class ProjectId {
    private final int value;

    public ProjectId(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
