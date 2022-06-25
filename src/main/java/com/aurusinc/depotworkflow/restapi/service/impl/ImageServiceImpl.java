package com.aurusinc.depotworkflow.restapi.service.impl;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.aurusinc.depotworkflow.restapi.exception.ResourceNotFoundException;
import com.aurusinc.depotworkflow.restapi.model.Image;
import com.aurusinc.depotworkflow.restapi.repository.ImageRepository;
import com.aurusinc.depotworkflow.restapi.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService{

	private ImageRepository imageRepository;
	
	public ImageServiceImpl(ImageRepository imageRepository) {
		super();
		this.imageRepository = imageRepository;
	}

	@Override
	public Image saveImage(Image image) {
		return imageRepository.save(image);
	}

	@Override
	public List<Image> getAllImages() {
		return imageRepository.findAll();
	}

	@Override
	public Image getImageById(String id) {
		return imageRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Image")); 
	}

	@Override
	public Image updateImage(Image image, String id) {
		
		// we need to check whether image with given id is exist in DB or not
		Image existingImage = imageRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Image")); 

        if(image.getShipmentLabel() != null) existingImage.setShipmentLabel(image.getShipmentLabel());

        if(image.getDeviceImageName() != null) existingImage.setDeviceImageName(image.getDeviceImageName());
        if(image.getDeviceImageType() != null) existingImage.setDeviceImageType(image.getDeviceImageType());
        if(image.getDeviceImage() != null) existingImage.setDeviceImage(image.getDeviceImage());

        if(image.getDeviceBoxImageName() != null) existingImage.setDeviceBoxImageName(image.getDeviceBoxImageName());
        if(image.getDeviceBoxImageType() != null) existingImage.setDeviceBoxImageType(image.getDeviceBoxImageType());
        if(image.getDeviceBoxImage() != null) existingImage.setDeviceBoxImage(image.getDeviceBoxImage());
        
        if(image.getDeviceAccessoriesImageName() != null) existingImage.setDeviceAccessoriesImageName(image.getDeviceAccessoriesImageName());
        if(image.getDeviceAccessoriesImageType() != null) existingImage.setDeviceAccessoriesImageType(image.getDeviceAccessoriesImageType());
        if(image.getDeviceAccessoriesImage() != null) existingImage.setDeviceAccessoriesImage(image.getDeviceAccessoriesImage());

		// save existing image to DB
		imageRepository.save(existingImage);
		return existingImage;
	}

	@Override
	public void deleteImage(String id) {
		
		// check whether a image exist in a DB or not
		imageRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Image"));
                                imageRepository.deleteById(id);
	}
	
}