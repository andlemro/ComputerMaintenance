package com.co.cliencontrol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.cliencontrol.interfaces.ICompanyService;
import com.co.cliencontrol.model.Company;

import jakarta.websocket.server.PathParam;

@RestController
@CrossOrigin("*")
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	ICompanyService companyService;
	
	/**************************************************/
	
	@GetMapping()
	public ResponseEntity<List<Company>> listCompanies() {
		return this.companyService.listCompanies();
	}
	
	/**************************************************/
	
	@GetMapping(value = "/{idCompany}")
	public ResponseEntity<Company>  getCompanyById(@PathVariable("idCompany") Integer idCompany) {
		return this.companyService.getCompanyById(idCompany);
	}
	
	/**************************************************/
	
	@PostMapping(value = "/create")
	public ResponseEntity<Company> createCompany(@RequestBody Company company) {
		return this.companyService.createCompany(company);
	}
	
	/**************************************************/
	
	@DeleteMapping(value = "/delete")
	public ResponseEntity<Void> deleteCompany(@PathParam("idCompany") Integer idCompany) {
		return this.companyService.deleteCompanyById(idCompany);
	}
	
	/**************************************************/
	
	@PutMapping(value = "/update")
	public ResponseEntity<Company> updateCompany(@RequestBody Company company) {
		return this.companyService.updateCompay(company);
	}
}
