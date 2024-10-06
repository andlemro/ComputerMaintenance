package com.co.cliencontrol.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.cliencontrol.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

	Optional<Invoice> findByInvoiceNumber(Long invoiceNumber);
	
	void deleteByInvoiceNumber(Long invoiceNumber);
	
}
