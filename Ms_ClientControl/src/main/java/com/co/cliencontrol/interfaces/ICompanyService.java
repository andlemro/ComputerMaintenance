package com.co.cliencontrol.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.co.cliencontrol.model.Company;

public interface ICompanyService {

	public ResponseEntity<List<Company>> listCompanies();

	public ResponseEntity<Company> getCompanyById(Integer idCompany);

	public ResponseEntity<Company> createCompany(Company company);

	public ResponseEntity<Void> deleteCompanyById(Integer idCompany);

	public ResponseEntity<Company> updateCompay(Company company);
}
