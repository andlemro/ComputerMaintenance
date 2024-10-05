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
@Table(name = "type_device")
public class TypeDevice {

	@Id
	@Column(name = "id_type_device", unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idTypeDevice;

	@Column(name = "name", nullable = false, length = 30)
	private String name;

}
