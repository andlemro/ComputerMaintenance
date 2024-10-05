package com.co.users.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "users")
public class User {

	@Id
	@Column(name = "id_user", unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idUser;

	@Column(name = "username", nullable = false, length = 30)
	private String username;

	@Column(name = "password", nullable = false, length = 20)
	private String password;

	@ManyToMany
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_rol"))
	private Set<Rol> roles;

}
