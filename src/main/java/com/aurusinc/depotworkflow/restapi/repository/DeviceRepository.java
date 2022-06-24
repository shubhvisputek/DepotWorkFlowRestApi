package com.aurusinc.depotworkflow.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurusinc.depotworkflow.restapi.model.Device;

public interface DeviceRepository extends JpaRepository<Device, String>{

}