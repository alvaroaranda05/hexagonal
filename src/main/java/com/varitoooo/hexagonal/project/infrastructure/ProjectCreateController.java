package com.varitoooo.hexagonal.project.infrastructure;

import com.varitoooo.hexagonal.project.application.create.ProjectCreator;
import com.varitoooo.hexagonal.project.application.ProjectEntry;
import com.varitoooo.hexagonal.project.application.ProjectResponse;
import com.varitoooo.hexagonal.project.application.ProjectResponseConverter;
import com.varitoooo.hexagonal.project.domain.Project;
import com.varitoooo.hexagonal.project.domain.ProjectId;
import com.varitoooo.hexagonal.project.domain.ProjectName;
import com.varitoooo.hexagonal.project.domain.ProjectRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/projects")
public final class ProjectCreateController {

    private final ProjectRepository projectRepository;

    public ProjectCreateController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @PostMapping(produces = {"application/json"})
    public ResponseEntity<ProjectResponse> create(@RequestBody ProjectEntry projectEntry) {
        ProjectCreator projectCreator = new ProjectCreator(projectRepository);
        Project project = projectCreator.create(
                new ProjectId(projectEntry.getId()),
                new ProjectName(projectEntry.getName())
        );
        ProjectResponse projectResponse = new ProjectResponseConverter().getResponse(project);
        return ResponseEntity.ok().body(projectResponse);
    }
}
