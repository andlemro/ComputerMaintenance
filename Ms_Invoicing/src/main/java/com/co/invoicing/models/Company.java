package com.co.invoicing.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "company")
public class Company {

	@Id
	@Column(name = "id_company", unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idCompany;

	@Column(name = "nit", nullable = false, unique = true)
	private Long nit;

	@Column(name = "company_name", nullable = false, length = 40)
	private String companyName;

	@Column(name = "address", nullable = false, length = 40)
	private String address;

	@Column(name = "email", nullable = false, length = 50)
	private String email;

}
