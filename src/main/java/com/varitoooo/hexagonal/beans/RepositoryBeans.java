package com.varitoooo.hexagonal.beans;

import com.varitoooo.hexagonal.project.domain.ProjectRepository;
import com.varitoooo.hexagonal.project.infrastructure.postgresql.ProjectRepositoryPostgreSql;
import com.varitoooo.hexagonal.project.infrastructure.postgresql.ProjectRepositoryPostgreSqlJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class RepositoryBeans {
    @Bean
    @Primary
    public ProjectRepository projectRepositoryComponent(ProjectRepositoryPostgreSqlJpa projectRepositoryPostgreSqlJpa) {
        return new ProjectRepositoryPostgreSql(projectRepositoryPostgreSqlJpa);
    }
}
