package com.co.cliencontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.cliencontrol.model.Device;

public interface DeviceRepository extends JpaRepository<Device, Integer> {

}
