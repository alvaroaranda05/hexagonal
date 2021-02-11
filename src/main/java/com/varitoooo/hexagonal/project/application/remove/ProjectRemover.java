package com.varitoooo.hexagonal.project.application.remove;

import com.varitoooo.hexagonal.shared.domain.exception.NotFoundException;
import com.varitoooo.hexagonal.project.domain.DomainProjectFinder;
import com.varitoooo.hexagonal.project.domain.Project;
import com.varitoooo.hexagonal.project.domain.ProjectId;
import com.varitoooo.hexagonal.project.domain.ProjectRepository;

import java.util.Optional;

public final class ProjectRemover {

    private final ProjectRepository projectRepository;

    public ProjectRemover(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void remove(ProjectId id) {
        DomainProjectFinder domainProjectFinder = new DomainProjectFinder(projectRepository);
        Optional<Project> project = domainProjectFinder.find(id);

        if (project.isEmpty()) throw new NotFoundException("The project with id " + id.getValue() + " does not exist");
        projectRepository.remove(id);
    }
}
