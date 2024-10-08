package com.co.clientcontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.clientcontrol.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
