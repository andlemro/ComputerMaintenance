package com.co.cliencontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.cliencontrol.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
