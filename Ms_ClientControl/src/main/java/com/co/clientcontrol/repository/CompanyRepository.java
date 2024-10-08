package com.co.clientcontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.clientcontrol.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
