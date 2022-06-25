package com.aurusinc.depotworkflow.restapi.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageUploadResponse {
    private String message;
    private String ticketID;
    private String shipmentLabel;
    private String deviceImageName;
    private String deviceBoxImageName;
    private String deviceAccessoriesImageName;

    public ImageUploadResponse(String message, String ticketID, String shipmentLabel, String deviceImageName,
            String deviceBoxImageName, String deviceAccessoriesImageName) {
        this.message = message;
        this.ticketID = ticketID;
        this.shipmentLabel = shipmentLabel;
        this.deviceImageName = deviceImageName;
        this.deviceBoxImageName = deviceBoxImageName;
        this.deviceAccessoriesImageName = deviceAccessoriesImageName;
    }
}