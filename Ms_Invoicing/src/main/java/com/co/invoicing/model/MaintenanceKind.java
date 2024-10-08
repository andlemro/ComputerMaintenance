package com.co.invoicing.model;

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
@Table(name = "maintenance_kind")
public class MaintenanceKind {

	@Id
	@Column(name = "id_maintenance_kind", unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "maintenance_kind_generator")
	@SequenceGenerator(name = "maintenance_kind_generator", sequenceName = "maintenance_kind_seq", allocationSize = 1)
	private Integer idMaintenanceKind;

	@Column(name = "kind", nullable = false, length = 30)
	private String kind;

}
