package com.co.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.co.users.interfaces.IUserService;
import com.co.users.models.User;
import com.co.users.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	/**************************************************/

	@Override
	public ResponseEntity<List<User>> listUsers() {
		try {
			return new ResponseEntity<>(this.userRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<User> getUserById(Integer idUser) {
		try {
			return new ResponseEntity<User>(this.userRepository.findById(idUser).orElseThrow(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<User> createUser(User user) {
		try {
			return new ResponseEntity<User>(this.userRepository.save(user), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<Void> deleteUserById(Integer idUser) {
		try {
			this.userRepository.deleteById(idUser);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<User> updateUser(User user) {
		try {
			return new ResponseEntity<User>(this.userRepository.save(user), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
	}

}
