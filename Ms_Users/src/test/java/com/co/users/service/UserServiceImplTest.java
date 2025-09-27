package com.co.users.service;

import static com.co.users.utils.UserData.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
	
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.co.users.models.User;
import com.co.users.repository.UserRepository;

@Tag("serviceImplTest")
@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

	@Mock
	UserRepository userRepository;

	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	/**************************************************/
	
	@BeforeEach
	void initTest(TestInfo testInfo, TestReporter testReporter) {
		testReporter.publishEntry(
				"Running: " + 
				testInfo.getDisplayName() +
				" - " +
				testInfo.getTestMethod().orElse(null).getName() +
				" with the Tag: " +
				testInfo.getTags()
		);
	}

	/**************************************************/
	
	@Test
	@DisplayName("Validation the User List Service in UserServiceImplTest")
	void listUsersTest() {
		when(this.userRepository.findAll()).thenReturn(USERS_LIST);
		List<User> listUsers = this.userServiceImpl.listUsers().getBody();

		assertAll(
			() -> assertNotNull(listUsers, () -> "The listUsers cannot be null."),
			() -> assertEquals(2, listUsers.size(), () -> "The size of listUsers is not 2.")
		);
		
		verify(this.userRepository).findAll();
	}

	/**************************************************/
	
	@Test
	@DisplayName("Validation the User Get Service in UserServiceImplTest")
	void getUserByIdTest() {
		when(this.userRepository.findById(anyInt())).thenReturn(GET_USER_ID);
		User userById = this.userServiceImpl.getUserById(anyInt()).getBody();
		
		assertAll(
			() -> assertNotNull(userById.getIdUser(), () -> "The IdUser field cannot be null."),
			() -> assertNotNull(userById.getRoles(), () -> "The Roles field cannot be null."),
			() -> assertEquals(3, userById.getIdUser(), () -> "The IdUser field is not 3."),
			() -> assertEquals("get_user_id", userById.getUsername(), () -> "The UserName field is not get_user_id."),
			() -> assertEquals("4321", userById.getPass(), () -> "The Password is not correct."),
			() -> assertEquals(1, userById.getRoles().size(), () -> "The size of Roles is 1.")
		);
		
		verify(this.userRepository).findById((anyInt()));
	}
	
/**************************************************/
	
	@Test
	@DisplayName("Validation the User Create Service in UserServiceImplTest")
	void createUserTest() {
		when(this.userRepository.save(any(User.class))).thenReturn(USER_CREATED);
		User newUser = this.userServiceImpl.createUser(USER_CREATED).getBody();
		
		assertAll(
			() -> assertNotNull(newUser.getIdUser(), () -> "The IdUser field cannot be null."),
			() -> assertNotNull(newUser.getRoles(), () -> "The Roles field cannot be null."),
			() -> assertEquals(4, newUser.getIdUser(), () -> "The IdUser field is not 4."),
			() -> assertEquals("user_create_new", newUser.getUsername(), () -> "The RolName field is not rol_create_new."),
			() -> assertEquals("6543", newUser.getPass(), () -> "The Password is not correct."),
			() -> assertEquals(1, newUser.getRoles().size(), () -> "The size of Roles is 1.")
		);
		
		verify(this.userRepository).save(any(User.class));
	}
	
/**************************************************/
	
	@Test
	@DisplayName("Validation the User Update Service in UserServiceImplTest")
	void updateUserTest() {
		when(this.userRepository.save(any(User.class))).thenReturn(USER_UPDATED);
		User updatedUser = this.userServiceImpl.updateUser(USER_UPDATED).getBody();
		
		assertAll(
			() -> assertNotNull(updatedUser.getIdUser(), () -> "The IdRol IdUser cannot be null."),
			() -> assertNotNull(updatedUser.getRoles(), () -> "The Roles field cannot be null."),
			() -> assertEquals(5, updatedUser.getIdUser(), () -> "The IdUser field is not 5."),
			() -> assertEquals("user_update", updatedUser.getUsername(), () -> "The UserName field is not rol_update."),
			() -> assertEquals("0987", updatedUser.getPass(), () -> "The Password is not correct."),
			() -> assertEquals(1, updatedUser.getRoles().size(), () -> "The size of Roles is 1.")
		);
		
		verify(this.userRepository).save(any(User.class));
	}
	
	/**************************************************/	
	
}
