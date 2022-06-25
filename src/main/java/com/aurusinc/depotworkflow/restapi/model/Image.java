package com.aurusinc.depotworkflow.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.aurusinc.depotworkflow.restapi.util.ImageUtility;

@Data
@Entity
@Table(name = "images")
public class Image {

	@Id
	@Column(name = "ticketID")
	private String ticketID;

	@Column(name = "shipmentLabel")
	private String shipmentLabel;

	@Column(name = "deviceImageName")
	private String deviceImageName;

	@Column(name = "deviceImageType")
	private String deviceImageType;

	@Column(name = "deviceImage", length = 10000000)
	private byte[] deviceImage;

	@Column(name = "deviceBoxImageName")
	private String deviceBoxImageName;

	@Column(name = "deviceBoxImageType")
	private String deviceBoxImageType;

	@Column(name = "deviceBoxImage", length = 10000000)
	private byte[] deviceBoxImage;

	@Column(name = "deviceAccessoriesImageName")
	private String deviceAccessoriesImageName;

	@Column(name = "deviceAccessoriesImageType")
	private String deviceAccessoriesImageType;

	@Column(name = "deviceAccessoriesImage", length = 10000000)
	private byte[] deviceAccessoriesImage;

	public byte[] getDeviceImage() {
		return ImageUtility.decompressImage(this.deviceImage);
	}

	public void setDeviceImage(byte[] deviceImage) {
		this.deviceImage = ImageUtility.compressImage(deviceImage);
	}

	public byte[] getDeviceBoxImage() {
		return ImageUtility.decompressImage(this.deviceBoxImage);
	}

	public void setDeviceBoxImage(byte[] deviceBoxImage) {
		this.deviceBoxImage = ImageUtility.compressImage(deviceBoxImage);
	}

	public byte[] getDeviceAccessoriesImage() {
		return ImageUtility.decompressImage(this.deviceAccessoriesImage);
	}

	public void setDeviceAccessoriesImage(byte[] deviceAccessoriesImage) {
		this.deviceAccessoriesImage = ImageUtility.compressImage(deviceAccessoriesImage);
	}
}