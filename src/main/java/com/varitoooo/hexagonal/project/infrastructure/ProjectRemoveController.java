package com.varitoooo.hexagonal.project.infrastructure;

import com.varitoooo.hexagonal.project.application.remove.ProjectRemover;
import com.varitoooo.hexagonal.project.domain.ProjectId;
import com.varitoooo.hexagonal.project.domain.ProjectRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/projects")
public final class ProjectRemoveController {

    private final ProjectRepository projectRepository;

    public ProjectRemoveController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> remove(@PathVariable(value = "id") Integer id) {
        ProjectRemover projectRemover = new ProjectRemover(projectRepository);
        projectRemover.remove(new ProjectId(id));

        return ResponseEntity.ok().build();
    }
}
