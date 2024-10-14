package com.co.users.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "roles")
public class Rol {

	@Id
	@Column(name = "id_rol", unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idRol;

	@Column(name = "rol_name", nullable = false, length = 20)
	private String rolName;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "roles_permissions", joinColumns = @JoinColumn(name = "id_rol"), inverseJoinColumns = @JoinColumn(name = "id_permission"))
	private Set<Permission> permissions;

}
