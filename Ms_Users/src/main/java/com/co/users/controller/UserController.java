package com.co.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.users.interfaces.IUserService;
import com.co.users.models.User;

import jakarta.websocket.server.PathParam;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {

	@Autowired
	IUserService userService;

	/**************************************************/

	@GetMapping
	public ResponseEntity<List<User>> listUsers() {
		return this.userService.listUsers();
	}

	/**************************************************/

	@GetMapping(value = "/{idUser}")
	public ResponseEntity<User> getUserById(@PathVariable("idUser") Integer idUser) {
		return this.userService.getUserById(idUser);
	}

	/**************************************************/

	@PostMapping(value = "/create")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return this.userService.createUser(user);
	}

	/**************************************************/

	@DeleteMapping(value = "/detele")
	public ResponseEntity<Void> deleteUserById(@PathParam("idUser") Integer idUser) {
		return this.userService.deleteUserById(idUser);
	}

	/**************************************************/

	@PutMapping(value = "/upate")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return this.userService.updateUser(user);
	}
}
