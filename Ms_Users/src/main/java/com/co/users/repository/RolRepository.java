package com.co.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.users.models.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {

}
