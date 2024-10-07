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
@Table(name = "devices_types")
public class DeviceType {

	@Id
	@Column(name = "id_device_type", unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idDeviceType;

	@Column(name = "device_type_name", nullable = false, length = 30)
	private String deviceTypeName;

}
