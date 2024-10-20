package com.co.users.models;

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
@Table(name = "permissions")
public class Permission {

	@Id
	@Column(name = "id_permission", unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permissions_generator")
	@SequenceGenerator(name = "permissions_generator", sequenceName = "permissions_seq", allocationSize = 1)
	private Integer idPermission;

	@Column(name = "permission_name", nullable = false, length = 25)
	private String permissionName;

	@Column(name = "description", nullable = false, length = 40)
	private String description;

}
