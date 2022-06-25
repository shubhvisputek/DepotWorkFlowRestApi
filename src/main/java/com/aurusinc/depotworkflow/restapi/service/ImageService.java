package com.aurusinc.depotworkflow.restapi.service;

import java.util.List;

import com.aurusinc.depotworkflow.restapi.model.Image;

public interface ImageService {
	Image saveImage(Image ticket);
	List<Image> getAllImages();
	Image getImageById(String id);
	Image updateImage(Image ticket, String id);
	void deleteImage(String id);
}
