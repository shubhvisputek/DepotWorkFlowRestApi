package com.aurusinc.depotworkflow.restapi.service;

import java.util.List;

import com.aurusinc.depotworkflow.restapi.model.Device;

public interface DeviceService {
	Device saveDevice(Device device);
	List<Device> getAllDevices();
	Device getDeviceById(String id);
	Device getDeviceByObject(Device device);
	Device updateDevice(Device device, String id);
	void deleteDevice(String id);
}
