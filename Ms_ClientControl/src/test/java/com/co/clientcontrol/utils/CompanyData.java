package com.co.clientcontrol.utils;

import java.util.List;
import java.util.Optional;

import com.co.clientcontrol.model.Company;

public class CompanyData {
	
	public final static Company COMPANY_MODEL_TEST = new Company(1, 1089923123L, "Raul SAS", "Cll 21A # 44 - 32", "raul@mail.com");
	
	public final static List<Company> COMPANY_LIST = List.of(
			new Company(1, 1089923123L, "Raul SAS", "Cll 21A # 44 - 32", "raul@mail.com"),
			new Company(2, 8992123122L, "Maintenance test", "Cr 44 # 33 - 22", "maintenance@mail.com"),
			new Company(3, 9877123443L, "Test SAS", "Cll 33 # 44b - 32", "test@mail.com")
		);
		
	public final static Optional<Company> GET_COMPANY_ID = Optional.ofNullable(new Company(5, 44123123L, "Test Get SAS", "Cll 33 # 44b - 32", "testGet@mail.com"));
	
	public final static Company COMPANY_CREATED = new Company(6, 5551231231L, "Test create SAS", "Cll 20 # 32 - 07", "testCreate@mail.com");
	
	public final static Company COMPANY_UPDATED = new Company(7, 9910443123L, "Test update SAS", "Cll 12 # 35b - 04", "testUpdate@mail.com");

}
