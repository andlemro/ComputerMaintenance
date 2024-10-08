package com.co.invoicing.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.co.invoicing.model.Invoice;

public interface IInvoiceService {

	public ResponseEntity<List<Invoice>> listInvoices();

	public ResponseEntity<Invoice> getInvoiceByInvoiceNumber(Long idInvoice);

	public ResponseEntity<Invoice> createInvoice(Invoice invoice);

	public ResponseEntity<Void> deleteInvoiceByInvoiceNumber(Long invoiceNumber);

	public ResponseEntity<Invoice> updateInvoice(Invoice invoice);
}
