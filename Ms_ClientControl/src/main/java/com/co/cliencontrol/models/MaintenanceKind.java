package com.co.cliencontrol.models;

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
@Table(name = "maintenance_kind")
public class MaintenanceKind {

	@Id
	@Column(name = "id_maintenance_kind", unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idMaintenanceKind;

	@Column(name = "kind", nullable = false, length = 50)
	private String kind;

}
