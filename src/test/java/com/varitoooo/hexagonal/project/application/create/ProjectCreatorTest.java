package com.varitoooo.hexagonal.project.application.create;

import com.varitoooo.hexagonal.project.domain.Project;
import com.varitoooo.hexagonal.project.domain.ProjectId;
import com.varitoooo.hexagonal.project.domain.ProjectName;
import com.varitoooo.hexagonal.project.domain.ProjectRepository;
import com.varitoooo.hexagonal.shared.domain.exception.InvalidEntityException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class ProjectCreatorTest {
    private ProjectCreator sut;

    @MockBean
    private ProjectRepository projectRepository;

    @BeforeEach
    void setUp() {
        sut = new ProjectCreator(projectRepository);
    }

    @Test
    void should_create_the_project_if_it_does_not_exist_previously() {
        //Given
        ProjectId id = new ProjectId(1);
        ProjectName name = new ProjectName("project1");
        Project project = new Project(id, name);

        when(projectRepository.search(id)).thenReturn(Optional.empty());

        //When
        Project projectCreated = sut.create(id, name);

        //Then
        assertThat(projectCreated.getId()).isEqualTo(id);
        assertThat(projectCreated.getName()).isEqualTo(name);
        verify(projectRepository).search(id);
        verify(projectRepository).save(project);
        verifyNoMoreInteractions(projectRepository);
    }

    @Test
    void should_thrown_exception_if_the_project_exist_previously() {
        //Given
        ProjectId id = new ProjectId(1);
        ProjectName name = new ProjectName("project1");
        Project project = new Project(id, name);

        when(projectRepository.search(id)).thenReturn(Optional.of(project));

        //When
        Throwable thrown = catchThrowable(() -> sut.create(id, name));

        //Then
        assertThat(thrown).isExactlyInstanceOf(InvalidEntityException.class);
        verify(projectRepository).search(id);
        verifyNoMoreInteractions(projectRepository);
    }
}