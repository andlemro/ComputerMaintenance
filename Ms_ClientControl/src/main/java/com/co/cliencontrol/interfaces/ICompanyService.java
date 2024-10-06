package com.co.cliencontrol.interfaces;

import java.util.List;

import com.co.cliencontrol.model.Company;

public interface ICompanyService {

	public List<Company> listCompanies();

	public Company getCompanyById(Integer idCompany);

	public void saveCompany(Company company);

	public void deleteCompanyById(Integer idCompany);

	public Company updateCompay(Company company);
}
