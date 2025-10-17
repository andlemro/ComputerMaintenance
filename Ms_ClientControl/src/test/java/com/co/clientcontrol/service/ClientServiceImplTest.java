package com.co.clientcontrol.service;

import static com.co.clientcontrol.utils.ClientData.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.co.clientcontrol.model.Client;
import com.co.clientcontrol.repository.ClientRepository;

@Tag("serviceImplTest")
@ExtendWith(MockitoExtension.class)
public class ClientServiceImplTest {
	
	@Mock
	ClientRepository clientRepository;
	
	@InjectMocks
	ClientServiceImpl clientServiceImpl;
	
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
	@DisplayName("Validation the List Client Service in ClientServiceImplTest Class")
	void listClientsTest() {
		when(this.clientRepository.findAll()).thenReturn(CLIENT_LIST);
		List<Client> listClients = this.clientServiceImpl.listClients().getBody();

		assertAll(
			() -> assertNotNull(listClients, () -> "The listClients cannot be null."),
			() -> assertEquals(3, listClients.size(), () -> "The size of listClients is not 3.")
		);
		
		verify(this.clientRepository).findAll();
	}

	/**************************************************/
	
	@Test
	@DisplayName("Validation the Get Client Service in ClientServiceImplTest Class")
	void getClientByIdTest() {
		when(this.clientRepository.findById(anyInt())).thenReturn(GET_CLIENT_ID);
		Client clientById = this.clientServiceImpl.getClientById(anyInt()).getBody();
		
		assertAll(
			() -> assertNotNull(clientById.getIdClient(), () -> "The IdClient field cannot be null."),
			() -> assertEquals(4, clientById.getIdClient(), () -> "The IdClient field is " + clientById.getIdClient() + " should be 4"),
			() -> assertEquals("Miguel", clientById.getName(), () -> "The Name field is " + clientById.getName() + " should be Miguel"),
			() -> assertEquals("Torres", clientById.getLastName(), () -> "The LastName field is " + clientById.getLastName() + " should be Torres"),
			() -> assertEquals("3214421452", clientById.getPhoneNumber(), () -> "The PhoneNumber field is " + clientById.getPhoneNumber() + " should be 3214421452"),
			() -> assertEquals("mighel@test.com", clientById.getEmail(), () -> "The Email field is " + clientById.getEmail() + " should be mighel@test.com"),
			() -> assertEquals("calle 51A # 11 - 34", clientById.getAddress(), () -> "The Address field is " + clientById.getAddress() + " should be calle 51A # 11 - 34"),
			() -> assertEquals("Colombia", clientById.getNeighborhood(), () -> "The Neighborhood field is " + clientById.getNeighborhood() + " should be Colombia")
		);
		
		verify(this.clientRepository).findById(anyInt());
	}
	
	/**************************************************/

	@Test
	@DisplayName("Validation the Create Client Service in ClientServiceImplTest Class")
	void createClientTest() {
		when(this.clientRepository.save(any(Client.class))).thenReturn(CLIENT_CREATED);
		Client newClient = this.clientServiceImpl.createClient(CLIENT_CREATED).getBody();
		
		assertAll(
			() -> assertNotNull(newClient.getIdClient(), () -> "The IdClient field cannot be null."),
			() -> assertEquals(5, newClient.getIdClient(), () -> "The IdClient field is " + newClient.getIdClient() + " should be 5"),
			() -> assertEquals("Carla", newClient.getName(), () -> "The Name field is " + newClient.getName() + " should be Carla"),
			() -> assertEquals("Gutierrez", newClient.getLastName(), () -> "The LastName field is " + newClient.getLastName() + " should be Gutierrez"),
			() -> assertEquals("3432239143", newClient.getPhoneNumber(), () -> "The PhoneNumber field is " + newClient.getPhoneNumber() + " should be 3432239143"),
			() -> assertEquals("carla@test.com", newClient.getEmail(), () -> "The Email field is " + newClient.getEmail() + " should be carla@test.com"),
			() -> assertEquals("calle 12A # 34 - 82", newClient.getAddress(), () -> "The Address field is " + newClient.getAddress() + " should be calle 12A # 34 - 82"),
			() -> assertEquals("Robles", newClient.getNeighborhood(), () -> "The Neighborhood field is " + newClient.getNeighborhood() + " should be Robles")
		);
		
		verify(this.clientRepository).save(any(Client.class));
	}
	
	/**************************************************/

	@Test
	@DisplayName("Validation the Update Client Service in ClientServiceImplTest Class")
	void updateClientTest() {
		when(this.clientRepository.save(any(Client.class))).thenReturn(CLIENT_UPDATED);
		Client updatedClient = this.clientServiceImpl.updateClient(CLIENT_UPDATED).getBody();
		
		assertAll(
			() -> assertNotNull(updatedClient.getIdClient(), () -> "The IdClient field cannot be null."),
			() -> assertEquals(6, updatedClient.getIdClient(), () -> "The IdClient field is " + updatedClient.getIdClient() + " should be 6"),
			() -> assertEquals("Jhon", updatedClient.getName(), () -> "The Name field is " + updatedClient.getName() + " should be Jhon"),
			() -> assertEquals("Bente", updatedClient.getLastName(), () -> "The LastName field is " + updatedClient.getLastName() + " should be Bente"),
			() -> assertEquals("3223415621", updatedClient.getPhoneNumber(), () -> "The PhoneNumber field is " + updatedClient.getPhoneNumber() + " should be 3223415621"),
			() -> assertEquals("jhon@test.com", updatedClient.getEmail(), () -> "The Email field is " + updatedClient.getEmail() + " should be jhon@test.com"),
			() -> assertEquals("carrera 42A # 21 - 58", updatedClient.getAddress(), () -> "The Address field is " + updatedClient.getAddress() + " should be carrera 42A # 21 - 58"),
			() -> assertEquals("Libertadores", updatedClient.getNeighborhood(), () -> "The Neighborhood field is " + updatedClient.getNeighborhood() + " should be Libertadores")
		);
		
		verify(this.clientRepository).save(any(Client.class));
	}
	
	/**************************************************/

}
