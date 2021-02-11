package com.varitoooo.hexagonal.project.domain;

import java.util.Optional;

public final class DomainProjectFinder {

    private final ProjectRepository projectRepository;

    public DomainProjectFinder(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Optional<Project> find(ProjectId id) {
        return projectRepository.search(id);
    }
}
