package com.aurusinc.depotworkflow.restapi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurusinc.depotworkflow.restapi.exception.ResourceNotFoundException;
import com.aurusinc.depotworkflow.restapi.model.Device;
import com.aurusinc.depotworkflow.restapi.service.DeviceService;
import com.aurusinc.depotworkflow.restapi.util.DeviceUtility;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {
	
	private DeviceService deviceService;

	public DeviceController(DeviceService deviceService) {
		super();
		this.deviceService = deviceService;
	}
	
	// build create device REST API
	@PostMapping()
	public ResponseEntity<Device> saveDevice(@RequestBody Device device) throws ResourceNotFoundException{

		if(device.getDummyTID() == null || device.getDummyTID().isEmpty()){
			device.setDummyTID(DeviceUtility.getDeviceUtility().getDummyTID());
		}
		return new ResponseEntity<Device>(deviceService.saveDevice(device), HttpStatus.CREATED);
	}
	
	// // build get all devices REST API
	// @GetMapping
	// public List<Device> getAllDevices(){
	// 	return deviceService.getAllDevices();
	// }
	
	// // build get device by id REST API
	// // http://localhost:8080/api/devices/1
	// @GetMapping("{id}")
	// public ResponseEntity<Device> getDeviceById(@PathVariable("id") String deviceId) throws ResourceNotFoundException{
	// 	return new ResponseEntity<Device>(deviceService.getDeviceById(deviceId), HttpStatus.OK);
	// }

	// build get ticket by id REST API
	// http://localhost:8080/api/tickets/1
	@GetMapping(path = {"", "{id}"})
	public ResponseEntity getDeviceById(@RequestParam(required=true) Map<String, String> qParamsMap, Device device) throws ResourceNotFoundException{
		if(qParamsMap != null && qParamsMap.size() != 0){
			return new ResponseEntity<List<Device>>(deviceService.getDeviceByObject(device), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Device>>(deviceService.getAllDevices(), HttpStatus.OK);
		}
	}
	
	// build update device REST API
	// http://localhost:8080/api/devices/1
	@PutMapping("{id}")
	public ResponseEntity<Device> updateDevice(@PathVariable("id") String id ,@RequestBody Device device) throws ResourceNotFoundException{
		
		if(device.getDummyTID() == null || device.getDummyTID().isEmpty()){
			device.setDummyTID(DeviceUtility.getDeviceUtility().getDummyTID());
		}
		return new ResponseEntity<Device>(deviceService.updateDevice(device, id), HttpStatus.OK);
	}
	
	// build delete device REST API
	// http://localhost:8080/api/devices/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteDevice(@PathVariable("id") String id) throws ResourceNotFoundException{
		
		// delete device from DB
		deviceService.deleteDevice(id);
		
		return new ResponseEntity<String>("Device deleted successfully!.", HttpStatus.OK);
	}
}
