package com.co.cliencontrol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.cliencontrol.interfaces.IInvoiceService;
import com.co.cliencontrol.model.Invoice;

import jakarta.websocket.server.PathParam;

@RestController
@CrossOrigin("*")
@RequestMapping("/invoices")
public class InvoiceController {

	@Autowired
	IInvoiceService invoiceService;

	/**************************************************/

	@GetMapping()
	public ResponseEntity<List<Invoice>> listInvoices() {
		return this.invoiceService.listInvoices();
	}

	/**************************************************/

	@GetMapping(value = "/{invoiceNumber}")
	public ResponseEntity<Invoice> getInvoiceByInvoiceNumber(@PathVariable("invoiceNumber") Long invoiceNumber) {
		return this.invoiceService.getInvoiceByInvoiceNumber(invoiceNumber);
	}

	/**************************************************/

	@PostMapping(value = "/create")
	public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
		return this.invoiceService.createInvoice(invoice);
	}

	/**************************************************/

	@DeleteMapping(value = "/delete")
	public ResponseEntity<Void> deleteInvoice(@PathParam("invoiceNumber") Long invoiceNumber) {
		return this.invoiceService.deleteInvoiceByInvoiceNumber(invoiceNumber);
	}

	/**************************************************/

	@PutMapping(value = "/update")
	public ResponseEntity<Invoice> updateInvoice(@RequestBody Invoice invoice) {
		return this.invoiceService.updateInvoice(invoice);
	}
}
