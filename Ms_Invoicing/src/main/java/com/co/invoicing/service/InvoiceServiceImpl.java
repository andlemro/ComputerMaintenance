package com.co.invoicing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.co.invoicing.interfaces.IInvoiceService;
import com.co.invoicing.model.Invoice;
import com.co.invoicing.repository.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements IInvoiceService {

	@Autowired
	InvoiceRepository invoiceRepository;

	/**************************************************/

	@Override
	public ResponseEntity<List<Invoice>> listInvoices() {
		try {
			return new ResponseEntity<>(this.invoiceRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<Invoice> getInvoiceByInvoiceNumber(Long invoiceNumber) {
		try {
			return new ResponseEntity<Invoice>(this.invoiceRepository.findByInvoiceNumber(invoiceNumber).get(),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Invoice>(HttpStatus.NOT_FOUND);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<Invoice> createInvoice(Invoice invoice) {
		try {
			return new ResponseEntity<Invoice>(this.invoiceRepository.save(invoice), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Invoice>(HttpStatus.BAD_REQUEST);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<Void> deleteInvoiceByInvoiceNumber(Long invoiceNumber) {
		try {
			this.invoiceRepository.deleteByInvoiceNumber(invoiceNumber);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<Invoice> updateInvoice(Invoice invoice) {
		try {
			return new ResponseEntity<Invoice>(this.invoiceRepository.save(invoice), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Invoice>(HttpStatus.BAD_REQUEST);
		}
	}

}
