package com.co.invoicing.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "invoices")
public class Invoice {

	@Id
	@Column(name = "id_invoice", unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_generator")
	@SequenceGenerator(name = "invoice_generator", sequenceName = "invoices_seq", allocationSize = 1)
	private Integer idInvoice;

	@Column(name = "invoice_number", nullable = false)
	private Long invoiceNumber;

	@Column(name = "service_description", nullable = false, length = 40)
	private String serviceDescription;

	@Column(name = "date_registered")
	private LocalDateTime dateRegistered;

	@Column(name = "subtotal_cost", precision = 15, scale = 2, nullable = false)
	private BigDecimal subtotalCost;

	@Column(name = "iva_cost", precision = 15, scale = 2, nullable = false)
	private BigDecimal ivaCost;

	@Column(name = "total_cost", precision = 15, scale = 2, nullable = false)
	private BigDecimal totalCost;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_client", referencedColumnName = "id_client", nullable = false)
	private Client idClient;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_company", referencedColumnName = "id_company", nullable = false)
	private Company idCompany;

}
