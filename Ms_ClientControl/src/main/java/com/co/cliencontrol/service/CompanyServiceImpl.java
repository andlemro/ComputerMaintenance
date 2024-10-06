package com.co.cliencontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.cliencontrol.interfaces.ICompanyService;
import com.co.cliencontrol.model.Company;
import com.co.cliencontrol.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements ICompanyService {

	@Autowired
	CompanyRepository companyRepository;
	
	/**************************************************/
	
	@Override
	public List<Company> listCompanies() {
		return this.companyRepository.findAll();
	}
	
	/**************************************************/

	@Override
	public Company getCompanyById(Integer idCompany) {
		return this.companyRepository.findById(idCompany).get();
	}

	@Override
	public void saveCompany(Company company) {
		this.companyRepository.save(company);
	}
	
	/**************************************************/

	@Override
	public void deleteCompanyById(Integer idCompany) {
		this.companyRepository.deleteById(idCompany);
	}
	
	/**************************************************/

	@Override
	public Company updateCompay(Company company) {
		return this.companyRepository.save(company);
	}

}
