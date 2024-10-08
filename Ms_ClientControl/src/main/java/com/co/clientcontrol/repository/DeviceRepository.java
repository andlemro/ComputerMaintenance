package com.co.clientcontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.clientcontrol.model.Device;

public interface DeviceRepository extends JpaRepository<Device, Integer> {

}
