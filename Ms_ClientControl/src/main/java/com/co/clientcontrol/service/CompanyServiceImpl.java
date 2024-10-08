package com.co.clientcontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.co.clientcontrol.interfaces.ICompanyService;
import com.co.clientcontrol.model.Company;
import com.co.clientcontrol.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements ICompanyService {

	@Autowired
	CompanyRepository companyRepository;

	/**************************************************/

	@Override
	public ResponseEntity<List<Company>> listCompanies() {
		try {
			return new ResponseEntity<>(this.companyRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<Company> getCompanyById(Integer idCompany) {
		try {
			return new ResponseEntity<Company>(this.companyRepository.findById(idCompany).get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**************************************************/

	@Override
	public ResponseEntity<Company> createCompany(Company company) {
		try {
			return new ResponseEntity<Company>(this.companyRepository.save(company), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Company>(HttpStatus.BAD_REQUEST);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<Void> deleteCompanyById(Integer idCompany) {
		try {
			this.companyRepository.deleteById(idCompany);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<Company> updateCompay(Company company) {
		try {
			return new ResponseEntity<Company>(this.companyRepository.save(company), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Company>(HttpStatus.BAD_REQUEST);
		}
	}

}
