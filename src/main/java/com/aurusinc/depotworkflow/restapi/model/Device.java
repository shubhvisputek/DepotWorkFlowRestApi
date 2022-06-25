package com.aurusinc.depotworkflow.restapi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Devices")
public class Device {

	@Id
    @Column(name = "SerialNumber", nullable = false, unique=true)
	private String serialNumber;

    @Column(name = "FullSerialNumber", nullable = false)
	private String fullSerialNumber;

    @Column(name = "InjectedSerialNumber", nullable = false)
	private String injectedSerialNumber;

    @Column(name = "MACAddress", nullable = false)
	private String mACAddress;

	@Column(name = "DeviceName")
	private String deviceName;

    @Column(name = "DeviceType")
    private String deviceType;

    @Column(name = "NetworkMode")
    private String networkMode;

    @Column(name = "KeysInfo")
    private String keysInfo;

    @Column(name = "KTK")
    private String kTK;

    @Column(name = "AppVersion")
    private String appVersion;

    @Column(name = "FirmwareVersion")
    private String firmwareVersion;

    @Column(name = "OSVersion")
    private String oSVersion;

    @Column(name = "StoreID")
	private String storeID;
	
    @Column(name = "LaneNumber")
	private String laneNumber;

    @Column(name = "ZipCode")
	private String zipCode;

    @Column(name = "DummyTID")
	private String dummyTID;

    @Column(name = "DeviceStatus")
	private String deviceStatus;

    @Column(name = "TicketID")
    private String ticketID;
}
