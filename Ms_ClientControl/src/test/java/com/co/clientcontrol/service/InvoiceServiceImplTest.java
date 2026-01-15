package com.co.clientcontrol.service;

import static com.co.clientcontrol.utils.InvoiceData.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	
	DateTimeFormatter FORMATTER;
	
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
		
		this.FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	}

	/**************************************************/
	
	@Test
	@DisplayName("Validation the List Invoices Service in InvoiceServiceImplTest Class")
	void listInvoicesTest() {
		
		// Given
		when(this.invoiceRepository.findAll()).thenReturn(INVOICES_LIST);
		
		// When
		List<Invoice> listInvoices = this.invoiceServiceImpl.listInvoices().getBody();

		// Then
		assertAll(
			() -> assertNotNull(listInvoices, () -> "The listInvoices cannot be null."),
			() -> assertEquals(3, listInvoices.size(), () -> "The size of listInvoices is not 3.")
		);
		
		verify(this.invoiceRepository).findAll();
	}

	/**************************************************/
	
	@Test
	@DisplayName("Validation the Get Invoice Service in InvoiceServiceImplTest Class")
	void getInvoiceByInvoiceNumberTest() {
		
		// Given
		LocalDateTime dateRegistered = LocalDateTime.parse("10/09/2025 10:00", this.FORMATTER);
		when(this.invoiceRepository.findByInvoiceNumber(anyLong())).thenReturn(GET_INVOICE_NUMBER);		
		
		// When
		Invoice invoiceById = this.invoiceServiceImpl.getInvoiceByInvoiceNumber(anyLong()).getBody();
		
		// Then
		assertAll(
			() -> assertNotNull(invoiceById.getIdInvoice(), () -> "The IdInvoice field cannot be null."),
			() -> assertEquals(4, invoiceById.getIdInvoice(), () -> "The Invoice field is " + invoiceById.getIdInvoice() + " should be 4"),
			() -> assertEquals(872400123L, invoiceById.getInvoiceNumber(), () -> "The InvoiceNumber field is " + invoiceById.getInvoiceNumber() + " should be 872400123"),
			() -> assertEquals("Mantinimiento Correctivo", invoiceById.getServiceDescription(), () -> "The ServiceDescription field is " + invoiceById.getServiceDescription() + " should be 'Mantinimiento Correctivo'"),
			() -> assertEquals(dateRegistered, invoiceById.getDateRegistered(), () -> "The DateRegistered field is " + invoiceById.getDateRegistered() + " should be '10/09/2025 10:00'"),
			() -> assertEquals(new BigDecimal("145000"), invoiceById.getSubtotalCost(), () -> "The SubtotalCost field is " + invoiceById.getSubtotalCost() + " should be 145000"),
			() -> assertEquals(new BigDecimal("27550"), invoiceById.getIvaCost(), () -> "The IvaCost field is " + invoiceById.getIvaCost() + " should be 27550"),
			() -> assertEquals(new BigDecimal("172550"), invoiceById.getTotalCost(), () -> "The TotalCost field is " + invoiceById.getTotalCost() + " should be 172550")
		);
		
		verify(this.invoiceRepository).findByInvoiceNumber(anyLong());
	}
	
	/**************************************************/

	@Test
	@DisplayName("Validation the Create Invoice Service in InvoiceServiceImplTest Class")
	void createInvoiceTest() {
		
		// Given
		LocalDateTime dateRegistered = LocalDateTime.parse("19/10/2025 15:30", this.FORMATTER);
		when(this.invoiceRepository.save(any(Invoice.class))).thenReturn(INVOICE_CREATED);
		
		// When
		Invoice newInvoice = this.invoiceServiceImpl.createInvoice(INVOICE_CREATED).getBody();
		
		// Then
		assertAll(
			() -> assertNotNull(newInvoice.getIdInvoice(), () -> "The IdInvoice field cannot be null."),
			() -> assertEquals(5, newInvoice.getIdInvoice(), () -> "The IdInvoice field is " + newInvoice.getIdInvoice() + " should be 5"),
			() -> assertEquals(9200432132L, newInvoice.getInvoiceNumber(), () -> "The InvoiceNumber field is " + newInvoice.getInvoiceNumber() + " should be 9200432132"),
			() -> assertEquals("Mantinimiento preventivo", newInvoice.getServiceDescription(), () -> "The ServiceDescription field is " + newInvoice.getServiceDescription() + " should be 'Mantinimiento preventivo'"),
			() -> assertEquals(dateRegistered, newInvoice.getDateRegistered(), () -> "The DateRegistered field is " + newInvoice.getDateRegistered() + " should be '19/10/2025 15:30'"),
			() -> assertEquals(new BigDecimal("80000"), newInvoice.getSubtotalCost(), () -> "The SubtotalCost field is " + newInvoice.getSubtotalCost() + " should be 80000"),
			() -> assertEquals(new BigDecimal("15200"), newInvoice.getIvaCost(), () -> "The IvaCost field is " + newInvoice.getIvaCost() + " should be 15200"),
			() -> assertEquals(new BigDecimal("95200"), newInvoice.getTotalCost(), () -> "The TotalCost field is " + newInvoice.getTotalCost() + " should be 95200")
		);
		
		verify(this.invoiceRepository).save(any(Invoice.class));
	}
	
	/**************************************************/

	@Test
	@DisplayName("Validation the Update Invoice Service in InvoiceServiceImplTest Class")
	void updateInvoiceTest() {
		
		// Given
		LocalDateTime dateRegistered = LocalDateTime.parse("27/09/2025 11:49", this.FORMATTER);
		when(this.invoiceRepository.save(any(Invoice.class))).thenReturn(INVOICE_UPDATED);
		
		// When
		Invoice newInvoice = this.invoiceServiceImpl.createInvoice(INVOICE_UPDATED).getBody();
		
		// Then
		assertAll(
			() -> assertNotNull(newInvoice.getIdInvoice(), () -> "The IdInvoice field cannot be null."),
			() -> assertEquals(6, newInvoice.getIdInvoice(), () -> "The IdInvoice field is " + newInvoice.getIdInvoice() + " should be 6"),
			() -> assertEquals(910234113L, newInvoice.getInvoiceNumber(), () -> "The InvoiceNumber field is " + newInvoice.getInvoiceNumber() + " should be 910234113"),
			() -> assertEquals("Revision", newInvoice.getServiceDescription(), () -> "The ServiceDescription field is " + newInvoice.getServiceDescription() + " should be 'Revision'"),
			() -> assertEquals(dateRegistered, newInvoice.getDateRegistered(), () -> "The DateRegistered field is " + newInvoice.getDateRegistered() + " should be '27/09/2025 11:49'"),
			() -> assertEquals(new BigDecimal("25000"), newInvoice.getSubtotalCost(), () -> "The SubtotalCost field is " + newInvoice.getSubtotalCost() + " should be 25000"),
			() -> assertEquals(new BigDecimal("4750"), newInvoice.getIvaCost(), () -> "The IvaCost field is " + newInvoice.getIvaCost() + " should be 4750"),
			() -> assertEquals(new BigDecimal("29750"), newInvoice.getTotalCost(), () -> "The TotalCost field is " + newInvoice.getTotalCost() + " should be 29750")
		);
		
		verify(this.invoiceRepository).save(any(Invoice.class));
	}
	
	/**************************************************/

}
