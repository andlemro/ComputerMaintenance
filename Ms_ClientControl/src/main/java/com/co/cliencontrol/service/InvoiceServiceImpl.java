package com.co.cliencontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.cliencontrol.interfaces.IInvoiceService;
import com.co.cliencontrol.model.Invoice;
import com.co.cliencontrol.repository.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements IInvoiceService {

	@Autowired
	InvoiceRepository invoiceRepository;
	
	/**************************************************/
	
	@Override
	public List<Invoice> listInvoices() {
		return this.invoiceRepository.findAll();
	}
	
	/**************************************************/

	@Override
	public Invoice getInvoiceByInvoiceNumber(Long invoiceNumber) {
		return this.invoiceRepository.findByInvoiceNumber(invoiceNumber).get();
	}
	
	/**************************************************/

	@Override
	public void saveInvoice(Invoice invoice) {
		this.invoiceRepository.save(invoice);
	}
	
	/**************************************************/

	@Override
	public void deleteInvoiceByInvoiceNumber(Long invoiceNumber) {
		this.invoiceRepository.deleteByInvoiceNumber(invoiceNumber);

	}
	
	/**************************************************/

	@Override
	public Invoice updateInvoice(Invoice invoice) {
		return this.invoiceRepository.save(invoice);
	}

}
