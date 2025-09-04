package com.co.invoicing.model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

@Tag("modelTest")
public class InvoiceTest {
	
	private Client client;
	private Company company;
	private Invoice invoice;
	
	/**************************************************/
	
	@BeforeEach
	void initTest(TestInfo testInfo, TestReporter testReporter) {
		
		this.client = new Client(3, "Carlos", "Narvaez", 
				"3014897732", "Carlos.Narvaez@mail.com",
				"Calle 12 # 44 - 23", "Rivera");
		
		this.company = new Company(2, 1234L, "TestCord", 
				"calle 27 # 33 - 44", "CumpoCord@mail.com");
		
		this.invoice = new Invoice(
				1, 1004L, 
				"Se realiza Mantenimiento Preventivo.",
				LocalDateTime.now(), 
				new BigDecimal("5000.00"),
				new BigDecimal("950.00"), 
				new BigDecimal("5950.00"), 
				this.client, 
				this.company);
		
		testReporter.publishEntry(
				"Running: " + 
				testInfo.getDisplayName() +
				" - " +
				testInfo.getTestMethod().orElse(null) +
				" with the Tag: " +
				testInfo.getTags()
		);
	}
	
	/**************************************************/
	
	@Test
	void notNullInvoiceTest() {
		assertAll(
			// not null validations
			() -> assertNotNull(this.invoice.getInvoiceNumber(),
					() -> "The invoiceNumber field cannot be null."),
			() -> assertNotNull(this.invoice.getServiceDescription(), 
					() -> "The serviceDescription field cannot be null."),
			() -> assertNotNull(this.invoice.getDateRegistered(), 
					() -> "The dateRegistered field cannot be null."),
			() -> assertNotNull(this.invoice.getSubtotalCost(), 
					() -> "The subtotalCost field cannot be null."),
			() -> assertNotNull(this.invoice.getIvaCost(), 
					() -> "The ivaCost field cannot be null."),
			() -> assertNotNull(this.invoice.getTotalCost(),
					() -> "The totalCost field cannot be null."),
			() -> assertNotNull(this.invoice.getIdClient(), 
					() -> "The idClient field cannot be null."),
			() -> assertNotNull(this.invoice.getIdCompany(), 
					() -> "The idCompany field cannot be null.")
		);
	}
	
	/**************************************************/
	
	@Test
	void validateLengthTest() {
		int serviceDescriptionLimit = 40;
		int subtotalCostWholePartLimit = 15;
		int subtotalCostDecimalPartLimit = 2;
		int ivaCostWholePartLimit = 15;
		int ivaCostDecimalPartLimit = 2;
		int totalCostWholePartLimit = 15;
		int totalCostDecimalPartLimit = 2;
		
		assertAll(
			() -> assertTrue(this.invoice.getServiceDescription().length() < serviceDescriptionLimit,
					() -> "The serviceDescription field exceeded the " + serviceDescriptionLimit + " character limit"),
			() -> {
				String[] subtotalCostParts = this.invoice.getSubtotalCost().toPlainString().split("\\.");
				String subtotalCostWholePart = subtotalCostParts[0];
				String subtotalCostDecimalPart = subtotalCostParts[1];
				assertTrue(subtotalCostWholePart.length() <= subtotalCostWholePartLimit,
						() -> "The Whole part of SubtotalCost field exceeded the " + subtotalCostWholePartLimit + " character limit");
				assertTrue(subtotalCostDecimalPart.length() <= subtotalCostDecimalPartLimit,
						() -> "The Decimal part of SubtotalCost field exceeded the " + subtotalCostDecimalPartLimit + " character limit");
			},
			() -> {
				String[] ivaCostParts = this.invoice.getIvaCost().toPlainString().split("\\.");
				String ivaCostWholePart = ivaCostParts[0];
				String ivaCostDecimalPart = ivaCostParts[1];
				assertTrue(ivaCostWholePart.length() <= ivaCostWholePartLimit,
						() -> "The Whole part of ivaCost field exceeded the " + ivaCostWholePartLimit + " character limit");
				assertTrue(ivaCostDecimalPart.length() <= ivaCostDecimalPartLimit,
						() -> "The Decimal part of ivaCost field exceeded the " + ivaCostDecimalPartLimit + " character limit");
			},
			() -> {
				String[] totalCostParts = this.invoice.getTotalCost().toPlainString().split("\\.");
				String totalCostWholePart = totalCostParts[0];
				String totalCostDecimalPart = totalCostParts[1];
				assertTrue(totalCostWholePart.length() <= totalCostWholePartLimit,
						() -> "The Whole part of totalCost field exceeded the " + totalCostWholePartLimit + " character limit");
				assertTrue(totalCostDecimalPart.length() <= totalCostDecimalPartLimit,
						() -> "The Decimal part of totalCost field exceeded the " + totalCostDecimalPartLimit + " character limit");
			}
		);
	}
	
	/**************************************************/
	
	@Test
	void calculateCostTest( ) {
		BigDecimal subTotal = this.invoice.getSubtotalCost();
		BigDecimal iva = this.invoice.getIvaCost();
		BigDecimal result = subTotal.add(iva);
		
		assertEquals(5000.00, this.invoice.getSubtotalCost().doubleValue());
		assertEquals(950.00, this.invoice.getIvaCost().doubleValue());
		assertEquals(this.invoice.getTotalCost(), result);
	}
	
	/**************************************************/
	
	@Test
	void costGreaterThanZeroTest( ) {
		// validation of cost greater than zero
		assertFalse(this.invoice.getSubtotalCost().compareTo(BigDecimal.ZERO) < 0);
		assertFalse(this.invoice.getIvaCost().compareTo(BigDecimal.ZERO) < 0);
		assertFalse(this.invoice.getTotalCost().compareTo(BigDecimal.ZERO) < 0);		
	}

}
