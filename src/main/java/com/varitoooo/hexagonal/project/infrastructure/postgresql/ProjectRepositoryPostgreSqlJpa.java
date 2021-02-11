package com.varitoooo.hexagonal.project.infrastructure.postgresql;

import org.springframework.data.repository.CrudRepository;

public interface ProjectRepositoryPostgreSqlJpa extends CrudRepository<ProjectEntity, Integer> {

}
