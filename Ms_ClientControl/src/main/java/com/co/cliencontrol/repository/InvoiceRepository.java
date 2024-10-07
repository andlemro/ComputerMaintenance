package com.co.cliencontrol.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.cliencontrol.model.Invoice;

import jakarta.transaction.Transactional;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

	Optional<Invoice> findByInvoiceNumber(Long invoiceNumber);
	
	@Transactional
	void deleteByInvoiceNumber(Long invoiceNumber);
	
}
