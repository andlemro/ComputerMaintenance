package com.co.clientcontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.clientcontrol.model.MaintenanceKind;

public interface MaintenanceKindRepository extends JpaRepository<MaintenanceKind, Integer> {

}
