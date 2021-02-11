package com.varitoooo.hexagonal.project.infrastructure.postgresql;

import com.varitoooo.hexagonal.project.domain.Project;
import com.varitoooo.hexagonal.project.domain.ProjectId;
import com.varitoooo.hexagonal.project.domain.ProjectName;

public final class ProjectEntityConverter {
    public ProjectEntity getEntity(Project project) {
        return new ProjectEntity(
            project.getId().getValue(),
            project.getName().getValue()
        );
    }

    public Project getProject(ProjectEntity projectEntity) {
        return new Project(
                new ProjectId(projectEntity.getId()),
                new ProjectName(projectEntity.getName())
        );
    }
}
