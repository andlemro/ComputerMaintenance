package com.co.clientcontrol.utils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static com.co.clientcontrol.utils.ClientData.*;
import static com.co.clientcontrol.utils.CompanyData.*;

import com.co.clientcontrol.model.Invoice;

public class InvoiceData {
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	public final static Invoice INVOICE_MODEL_TEST = new Invoice(
		1, 
		00000123L, 
		"Mantinimiento preventivo", 
		LocalDateTime.parse("11/10/2025 14:30", FORMATTER), 
		new BigDecimal("80000"), 
		new BigDecimal("15200"),
		new BigDecimal("95200"),
		CLIENT_MODEL_TEST,
		COMPANY_MODEL_TEST
	);
	
	// --------------------------------------------------------
	
	public final static List<Invoice> INVOICE_LIST = List.of(
		new Invoice(
			1, 
			860001942L, 
			"Mantinimiento Correctivo", 
			LocalDateTime.parse("20/10/2025 14:15", FORMATTER), 
			new BigDecimal("240000"), 
			new BigDecimal("45600"),
			new BigDecimal("285600"),
			CLIENT_MODEL_TEST,
			COMPANY_MODEL_TEST
		),
		new Invoice(
			2, 
			930123134L, 
			"Mantinimiento preventivo", 
			LocalDateTime.parse("05/11/2025 16:25", FORMATTER), 
			new BigDecimal("75000"), 
			new BigDecimal("14250"),
			new BigDecimal("89250"),
			CLIENT_MODEL_TEST,
			COMPANY_MODEL_TEST
		),
		new Invoice(
			3, 
			783139012L, 
			"Revision", 
			LocalDateTime.parse("23/11/2025 09:30", FORMATTER), 
			new BigDecimal("15000"), 
			new BigDecimal("2850"),
			new BigDecimal("17850"),
			CLIENT_MODEL_TEST,
			COMPANY_MODEL_TEST
		)
	);
	
	// --------------------------------------------------------
		
	public final static Optional<Invoice> GET_INVOICE_ID = Optional.ofNullable(new Invoice(
		4, 
		872400123L, 
		"Mantinimiento Correctivo", 
		LocalDateTime.parse("10/09/2025 10:00", FORMATTER), 
		new BigDecimal("145000"), 
		new BigDecimal("27550"),
		new BigDecimal("172550"),
		CLIENT_MODEL_TEST,
		COMPANY_MODEL_TEST
	));
	
	// --------------------------------------------------------
	
	public final static Invoice INVOICE_CREATED = new Invoice(
		5, 
		9200432132L, 
		"Mantinimiento preventivo", 
		LocalDateTime.parse("19/10/2025 15:30", FORMATTER), 
		new BigDecimal("80000"), 
		new BigDecimal("15200"),
		new BigDecimal("95200"),
		CLIENT_MODEL_TEST,
		COMPANY_MODEL_TEST
	);
	
	// --------------------------------------------------------
	
	public final static Invoice INVOICE_UPDATED = new Invoice(
		6, 
		910234113L, 
		"Revision", 
		LocalDateTime.parse("27/09/2025 11:49", FORMATTER), 
		new BigDecimal("25000"), 
		new BigDecimal("4750"),
		new BigDecimal("29750"),
		CLIENT_MODEL_TEST,
		COMPANY_MODEL_TEST
	);
	
}
