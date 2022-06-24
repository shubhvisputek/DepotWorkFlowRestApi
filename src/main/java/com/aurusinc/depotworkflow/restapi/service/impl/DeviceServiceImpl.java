package com.aurusinc.depotworkflow.restapi.service.impl;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.aurusinc.depotworkflow.restapi.exception.ResourceNotFoundException;
import com.aurusinc.depotworkflow.restapi.model.Device;
import com.aurusinc.depotworkflow.restapi.repository.DeviceRepository;
import com.aurusinc.depotworkflow.restapi.service.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService{

	private DeviceRepository deviceRepository;
	
	public DeviceServiceImpl(DeviceRepository deviceRepository) {
		super();
		this.deviceRepository = deviceRepository;
	}

	@Override
	public Device saveDevice(Device device) {
		return deviceRepository.save(device);
	}

	@Override
	public List<Device> getAllDevices() {
		return deviceRepository.findAll();
	}

	@Override
	public Device getDeviceById(String id) {
		return deviceRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Device")); 
		
	}

	@Override
	public Device getDeviceByObject(Device device) {
		return deviceRepository.findOne(Example.of(device)).orElseThrow(
			() -> new ResourceNotFoundException("Ticket")); 
	}

	@Override
	public Device updateDevice(Device device, String id) {
		
		// we need to check whether device with given id is exist in DB or not
		Device existingDevice = deviceRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Device")); 

        if(device.getSerialNumber() != null) existingDevice.setSerialNumber(device.getSerialNumber());
        if(device.getFullSerialNumber() != null) existingDevice.setFullSerialNumber(device.getFullSerialNumber());
        if(device.getInjectedSerialNumber() != null) existingDevice.setInjectedSerialNumber(device.getInjectedSerialNumber());
        if(device.getMACAddress() != null) existingDevice.setMACAddress(device.getMACAddress());
        if(device.getDeviceName() != null) existingDevice.setDeviceName(device.getDeviceName());
        if(device.getDeviceType() != null) existingDevice.setDeviceType(device.getDeviceType());
        if(device.getNetworkMode() != null) existingDevice.setNetworkMode(device.getNetworkMode());
        if(device.getKeysInfo() != null) existingDevice.setKeysInfo(device.getKeysInfo());
        if(device.getKTK() != null) existingDevice.setKTK(device.getKTK());
        if(device.getAppVersion() != null) existingDevice.setAppVersion(device.getAppVersion());
        if(device.getFirmwareVersion() != null) existingDevice.setFirmwareVersion(device.getFirmwareVersion());
        if(device.getOSVersion() != null) existingDevice.setOSVersion(device.getOSVersion());
        if(device.getStoreID() != null) existingDevice.setStoreID(device.getStoreID());
        if(device.getLaneNumber() != null) existingDevice.setLaneNumber(device.getLaneNumber());
        if(device.getZipCode() != null) existingDevice.setZipCode(device.getZipCode());
        if(device.getDummyTID() != null) existingDevice.setDummyTID(device.getDummyTID());
        if(device.getDeviceStatus() != null) existingDevice.setDeviceStatus(device.getDeviceStatus());
        if(device.getTicketID() != null) existingDevice.setTicketID(device.getTicketID());

		// save existing device to DB
		deviceRepository.save(existingDevice);
		return existingDevice;
	}

	@Override
	public void deleteDevice(String id) {
		
		// check whether a device exist in a DB or not
		deviceRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Device"));
                                deviceRepository.deleteById(id);
	}
	
}