package com.co.clientcontrol.service;

import static com.co.clientcontrol.utils.InvoiceData.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.co.clientcontrol.model.Invoice;
import com.co.clientcontrol.repository.InvoiceRepository;

@Tag("serviceImplTest")
@ExtendWith(MockitoExtension.class)
public class InvoiceServiceImplTest {
	
	@Mock
	InvoiceRepository invoiceRepository;
	
	@InjectMocks
	InvoiceServiceImpl invoiceServiceImpl;
	
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
	@DisplayName("Validation the List Invoices Service in InvoiceServiceImplTest Class")
	void listInvoicesTest() {
		when(this.invoiceRepository.findAll()).thenReturn(INVOICE_LIST);
		List<Invoice> listInvoices = this.invoiceServiceImpl.listInvoices().getBody();

		assertAll(
			() -> assertNotNull(listInvoices, () -> "The listInvoices cannot be null."),
			() -> assertEquals(3, listInvoices.size(), () -> "The size of listInvoices is not 3.")
		);
		
		verify(this.invoiceRepository).findAll();
	}

	/**************************************************/

}
