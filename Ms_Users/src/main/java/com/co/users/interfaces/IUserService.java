package com.co.users.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.co.users.models.User;

public interface IUserService {

	public ResponseEntity<List<User>> listUsers();

	public ResponseEntity<User> getUserById(Integer idUser);

	public ResponseEntity<User> createUser(User user);

	public ResponseEntity<Void> deleteUserById(Integer idUser);

	public ResponseEntity<User> updateUser(User user);
}
