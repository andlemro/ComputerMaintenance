package com.co.cliencontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.cliencontrol.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
