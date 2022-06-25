package com.aurusinc.depotworkflow.restapi.controller;

import com.aurusinc.depotworkflow.restapi.model.Image;
import com.aurusinc.depotworkflow.restapi.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
// @CrossOrigin(origins = "http://localhost:8082") open for specific port
// @CrossOrigin() // open for all ports
public class ImageController {

        private ImageService imageService;

        public ImageController(ImageService imageService) {
                super();
                this.imageService = imageService;
        }

        @PostMapping("/upload/image")
        public ResponseEntity uplaodImage(
                        @RequestParam(name = "deviceImage", required = false) MultipartFile deviceImageFile,
                        @RequestParam(name = "deviceBoxImage", required = false) MultipartFile deviceBoxImageFile,
                        @RequestParam(name = "deviceAccessoriesImage", required = false) MultipartFile deviceAccessoriesImageFile,
                        @RequestParam("shipmentLabel") String shipmentLabel, 
                        @RequestParam("ticketID") String ticketID) throws IOException {

                Image image = new Image();

                image.setTicketID(ticketID);
                image.setShipmentLabel(shipmentLabel);

                if(deviceImageFile != null) image.setDeviceImageName(deviceImageFile.getOriginalFilename());
                if(deviceImageFile != null) image.setDeviceImageType(deviceImageFile.getContentType());
                if(deviceImageFile != null) image.setDeviceImage(deviceImageFile.getBytes());

                if(deviceBoxImageFile != null) image.setDeviceBoxImageName(deviceBoxImageFile.getOriginalFilename());
                if(deviceBoxImageFile != null) image.setDeviceBoxImageType(deviceBoxImageFile.getContentType());
                if(deviceBoxImageFile != null) image.setDeviceBoxImage(deviceBoxImageFile.getBytes());

                if(deviceAccessoriesImageFile != null) image.setDeviceAccessoriesImageName(deviceAccessoriesImageFile.getOriginalFilename());
                if(deviceAccessoriesImageFile != null) image.setDeviceAccessoriesImageType(deviceAccessoriesImageFile.getContentType());
                if(deviceAccessoriesImageFile != null) image.setDeviceAccessoriesImage(deviceAccessoriesImageFile.getBytes());

                imageService.saveImage(image);

                return new ResponseEntity<ImageUploadResponse>(new ImageUploadResponse("Image uploaded successfully", image.getTicketID(), image.getShipmentLabel(), image.getDeviceImageName(), image.getDeviceBoxImageName(), image.getDeviceAccessoriesImageName()), HttpStatus.OK);
        }

        @GetMapping(path = {"get/image/{id}" })
        public ResponseEntity<Image> getImageDetails(@PathVariable("id") String ticketID) throws IOException {

                Image dbImage = imageService.getImageById(ticketID);

                return new ResponseEntity<Image>(dbImage, HttpStatus.OK);
        }

        @GetMapping(path = { "get/image/{id}/{name}" })
        public ResponseEntity getImage(@PathVariable("id") String ticketID, @PathVariable("name") String imageName) throws IOException {

                Image dbImage = imageService.getImageById(ticketID);

                if(imageName.equals(dbImage.getDeviceImageName())){
                        return ResponseEntity
                                .ok()
                                .contentType(MediaType.valueOf(dbImage.getDeviceImageType()))
                                .body(dbImage.getDeviceImage());
                }
                else if(imageName.equals(dbImage.getDeviceBoxImageName())){
                        return ResponseEntity
                        .ok()
                        .contentType(MediaType.valueOf(dbImage.getDeviceBoxImageType()))
                        .body(dbImage.getDeviceBoxImage());
                } 
                else if(imageName.equals(dbImage.getDeviceAccessoriesImageName())){
                        return ResponseEntity
                        .ok()
                        .contentType(MediaType.valueOf(dbImage.getDeviceAccessoriesImageType()))
                        .body(dbImage.getDeviceAccessoriesImage());
                }
                return new ResponseEntity<String>("Image Not Found", HttpStatus.NOT_FOUND);
        }
}