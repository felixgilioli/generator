package com.generator.generator.input;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InputRepository extends JpaRepository<InputEntity, UUID> {

}
