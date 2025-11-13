package com.co.clientcontrol.service;

import static com.co.clientcontrol.utils.CompanyData.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.co.clientcontrol.model.Company;
import com.co.clientcontrol.repository.CompanyRepository;

@Tag("serviceImplTest")
@ExtendWith(MockitoExtension.class)
public class CompanyServiceImplTest {
	
	@Mock
	CompanyRepository companyRepository;
	
	@InjectMocks
	CompanyServiceImpl companyServiceImpl;
	
	/**************************************************/
	
	@BeforeEach
	void initTest(TestInfo testInfo, TestReporter testReporter) {
		testReporter.publishEntry(
				"Running: " + 
				testInfo.getDisplayName() +
				" - " +
				testInfo.getTestMethod().orElse(null).getName() +
				" with the Tag: " +
				testInfo.getTags()
		);
	}

	/**************************************************/
	
	@Test
	@DisplayName("Validation the List Companies Service in CompanyServiceImplTest Class")
	void listCompaniesTest() {
		when(this.companyRepository.findAll()).thenReturn(COMPANY_LIST);
		List<Company> listCompanies = this.companyServiceImpl.listCompanies().getBody();

		assertAll(
			() -> assertNotNull(listCompanies, () -> "The listCompaniesTest cannot be null."),
			() -> assertEquals(3, listCompanies.size(), () -> "The size of listCompaniesTest is not 3.")
		);
		
		verify(this.companyRepository).findAll();
	}

	/**************************************************/
	
	@Test
	@DisplayName("Validation the Get Company Service in CompanyServiceImplTest Class")
	void getCompanyByIdTest() {
		when(this.companyRepository.findById(anyInt())).thenReturn(GET_COMPANY_ID);
		Company companyById = this.companyServiceImpl.getCompanyById(anyInt()).getBody();
		
		assertAll(
			() -> assertNotNull(companyById.getIdCompany(), () -> "The IdCompany field cannot be null."),
			() -> assertEquals(5, companyById.getIdCompany(), () -> "The IdCompany field is " + companyById.getIdCompany() + " should be 5"),
			() -> assertEquals(44123123L, companyById.getNit(), () -> "The Nit field is " + companyById.getNit() + " should be 44123123L"),
			() -> assertEquals("Test Get SAS", companyById.getCompanyName(), () -> "The CompanyName field is " + companyById.getCompanyName() + " should be Test Get SAS"),
			() -> assertEquals("Cll 33 # 44b - 32", companyById.getAddress(), () -> "The Address field is " + companyById.getAddress() + " should be Cll 33 # 44b - 32"),
			() -> assertEquals("testGet@mail.com", companyById.getEmail(), () -> "The Email field is " + companyById.getEmail() + " should be testGet@mail.com")
		);
		
		verify(this.companyRepository).findById(anyInt());
	}
	
	/**************************************************/

	@Test
	@DisplayName("Validation the Create Company Service in CompanyServiceImplTest Class")
	void createCompanyTest() {
		when(this.companyRepository.save(any(Company.class))).thenReturn(COMPANY_CREATED);
		Company newCompany = this.companyServiceImpl.createCompany(COMPANY_CREATED).getBody();
		
		assertAll(
			() -> assertNotNull(newCompany.getIdCompany(), () -> "The IdCompany field cannot be null."),
			() -> assertEquals(6, newCompany.getIdCompany(), () -> "The IdCompany field is " + newCompany.getIdCompany() + " should be 6"),
			() -> assertEquals(5551231231L, newCompany.getNit(), () -> "The Nit field is " + newCompany.getNit() + " should be 5551231231L"),
			() -> assertEquals("Test create SAS", newCompany.getCompanyName(), () -> "The CompanyName field is " + newCompany.getCompanyName() + " should be Test create SAS"),
			() -> assertEquals("Cll 20 # 32 - 07", newCompany.getAddress(), () -> "The Address field is " + newCompany.getAddress() + " should be Cll 20 # 32 - 07"),
			() -> assertEquals("testCreate@mail.com", newCompany.getEmail(), () -> "The Email field is " + newCompany.getEmail() + " should be testCreate@mail.com")
		);
		
		verify(this.companyRepository).save(any(Company.class));
	}
	
	/**************************************************/

	@Test
	@DisplayName("Validation the Update Company Service in CompanyServiceImplTest Class")
	void updateCompanyTest() {
		when(this.companyRepository.save(any(Company.class))).thenReturn(COMPANY_UPDATED);
		Company newCompany = this.companyServiceImpl.createCompany(COMPANY_UPDATED).getBody();
		
		assertAll(
			() -> assertNotNull(newCompany.getIdCompany(), () -> "The IdCompany field cannot be null."),
			() -> assertEquals(7, newCompany.getIdCompany(), () -> "The IdCompany field is " + newCompany.getIdCompany() + " should be 7"),
			() -> assertEquals(9910443123L, newCompany.getNit(), () -> "The Nit field is " + newCompany.getNit() + " should be 9910443123L"),
			() -> assertEquals("Test update SAS", newCompany.getCompanyName(), () -> "The CompanyName field is " + newCompany.getCompanyName() + " should be Test update SASS"),
			() -> assertEquals("Cll 12 # 35b - 04", newCompany.getAddress(), () -> "The Address field is " + newCompany.getAddress() + " should be Cll 12 # 35b - 04"),
			() -> assertEquals("testUpdate@mail.com", newCompany.getEmail(), () -> "The Email field is " + newCompany.getEmail() + " should be testUpdate@mail.com")
		);
		
		verify(this.companyRepository).save(any(Company.class));
	}
	
	/**************************************************/

}
