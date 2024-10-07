package com.co.cliencontrol.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "clients")
public class Client {

	@Id
	@Column(name = "id_client", unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_generator")
	@SequenceGenerator(name = "client_generator", sequenceName = "clients_seq", allocationSize = 1)
	private Integer idClient;

	@Column(name = "client_name", nullable = false, length = 40)
	private String name;

	@Column(name = "client_last_name", nullable = false, length = 40)
	private String lastName;

	@Column(name = "phone_number", nullable = false, length = 12)
	private String phoneNumber;

	@Column(name = "email", nullable = false, length = 40)
	private String email;

	@Column(name = "address", nullable = false, length = 30)
	private String address;

	@Column(name = "neighborhood", nullable = false, length = 50)
	private String neighborhood;

//	@OneToMany(mappedBy = "idDevice")
//	private List<Device> devicesList;
}
