package com.co.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.users.models.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {

}
