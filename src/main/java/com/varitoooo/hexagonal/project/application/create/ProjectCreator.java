package com.varitoooo.hexagonal.project.application.create;

import com.varitoooo.hexagonal.project.domain.*;
import com.varitoooo.hexagonal.shared.domain.exception.InvalidEntityException;

import java.util.Optional;


public final class ProjectCreator {

    private final ProjectRepository projectRepository;

    public ProjectCreator(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project create(ProjectId id, ProjectName name) {
        DomainProjectFinder domainProjectFinder = new DomainProjectFinder(projectRepository);
        Optional<Project> existingProject = domainProjectFinder.find(id);

        if (existingProject.isPresent()) throw new InvalidEntityException("There is another project with id " + id.getValue());

        Project project = Project.create(id, name);
        projectRepository.save(project);

        return project;
    }
}
