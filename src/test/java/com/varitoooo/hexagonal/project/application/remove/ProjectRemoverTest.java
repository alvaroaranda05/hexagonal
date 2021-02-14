package com.varitoooo.hexagonal.project.application.remove;

import com.varitoooo.hexagonal.project.domain.Project;
import com.varitoooo.hexagonal.project.domain.ProjectId;
import com.varitoooo.hexagonal.project.domain.ProjectName;
import com.varitoooo.hexagonal.project.domain.ProjectRepository;
import com.varitoooo.hexagonal.shared.domain.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class ProjectRemoverTest {

    private ProjectRemover sut;

    @MockBean
    private ProjectRepository projectRepository;

    @BeforeEach
    void setUp() {
        sut = new ProjectRemover(this.projectRepository);
    }

    @Test
    void should_remove_the_project_if_it_exists() {
        //Given
        ProjectId id = new ProjectId(1);
        ProjectName name = new ProjectName("project1");
        Project project = new Project(id, name);

        when(projectRepository.search(id)).thenReturn(Optional.of(project));

        //When
        sut.remove(id);

        //Then
        verify(projectRepository).search(id);
        verify(projectRepository).remove(id);
        verifyNoMoreInteractions(projectRepository);
    }

    @Test
    void should_thrown_exception_if_the_project_does_not_exist() {
        //Given
        ProjectId id = new ProjectId(1);

        when(projectRepository.search(id)).thenReturn(Optional.empty());

        //When
        Throwable thrown = catchThrowable(() -> sut.remove(id));

        //Then
        assertThat(thrown).isExactlyInstanceOf(NotFoundException.class);
        verify(projectRepository).search(id);
        verifyNoMoreInteractions(projectRepository);
    }
}