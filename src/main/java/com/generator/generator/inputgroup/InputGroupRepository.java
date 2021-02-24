package com.generator.generator.inputgroup;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Interface com CRUD do Spring Data.
 */
public interface InputGroupRepository extends JpaRepository<InputGroupEntity, UUID> {
}
