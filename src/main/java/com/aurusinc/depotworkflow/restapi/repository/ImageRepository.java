package com.aurusinc.depotworkflow.restapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurusinc.depotworkflow.restapi.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
	Optional<Image> findByName(String name);
}