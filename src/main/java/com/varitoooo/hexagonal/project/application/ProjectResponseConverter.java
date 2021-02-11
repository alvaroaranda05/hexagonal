package com.varitoooo.hexagonal.project.application;

import com.varitoooo.hexagonal.project.domain.Project;

public final class ProjectResponseConverter {
    public ProjectResponse getResponse(Project project) {
        return new ProjectResponse(
            project.getId().getValue(),
            project.getName().getValue()
        );
    }
}
