package com.co.cliencontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.cliencontrol.model.MaintenanceKind;

public interface MaintenanceKindRepository extends JpaRepository<MaintenanceKind, Integer> {

}
