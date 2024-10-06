package com.co.cliencontrol.interfaces;

import java.util.List;

import com.co.cliencontrol.model.Invoice;

public interface IInvoiceService {

	public List<Invoice> listInvoices();

	public Invoice getInvoiceByInvoiceNumber(Long idInvoice);

	public void saveInvoice(Invoice invoice);

	public void deleteInvoiceByInvoiceNumber(Long invoiceNumber);

	public Invoice updateInvoice(Invoice invoice);
}
