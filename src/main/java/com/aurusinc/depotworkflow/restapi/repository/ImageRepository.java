package com.aurusinc.depotworkflow.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurusinc.depotworkflow.restapi.model.Image;

public interface ImageRepository extends JpaRepository<Image, String> {
	
}