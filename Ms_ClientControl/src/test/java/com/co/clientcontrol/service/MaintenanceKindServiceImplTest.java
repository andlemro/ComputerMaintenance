package com.co.clientcontrol.service;

import static com.co.clientcontrol.utils.MaintenanceKindData.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.co.clientcontrol.model.MaintenanceKind;
import com.co.clientcontrol.repository.MaintenanceKindRepository;

@Tag("serviceImplTest")
@ExtendWith(MockitoExtension.class)
public class MaintenanceKindServiceImplTest {

	@Mock
	MaintenanceKindRepository maintenanceKindRepository;
	
	@InjectMocks
	MaintenanceKindServiceImpl maintenanceKindServiceImpl;
	
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
	@DisplayName("Validation the List MaintenanceKind Service in MaintenanceKindServiceImplTest Class")
	void listMaintenanceKindTest() {
		when(this.maintenanceKindRepository.findAll()).thenReturn(MAINTENANCE_KIND_LIST);
		List<MaintenanceKind> listMaintenanceKind = this.maintenanceKindServiceImpl.listMaintenanceKinds().getBody();

		assertAll(
			() -> assertNotNull(listMaintenanceKind, () -> "The listMaintenanceKind cannot be null."),
			() -> assertEquals(2, listMaintenanceKind.size(), () -> "The size of listMaintenanceKind is not 3.")
		);
		
		verify(this.maintenanceKindRepository).findAll();
	}

	/**************************************************/
	
	@Test
	@DisplayName("Validation the Get MaintenanceKind Service in MaintenanceKindServiceImplTest Class")
	void getMaintenanceKindByIdTest() {
		when(this.maintenanceKindRepository.findById(anyInt())).thenReturn(GET_MAINTENANCE_KIND_ID);
		MaintenanceKind maintenanceKindById = this.maintenanceKindServiceImpl.getMaintenanceKindById(anyInt()).getBody();
		
		assertAll(
			() -> assertNotNull(maintenanceKindById.getIdMaintenanceKind(), () -> "The IdMaintenanceKind field cannot be null."),
			() -> assertEquals(4, maintenanceKindById.getIdMaintenanceKind(), () -> "The IdMaintenanceKind field is " + maintenanceKindById.getIdMaintenanceKind() + " should be 4"),
			() -> assertEquals("Predictivo", maintenanceKindById.getKind(), () -> "The KindName field is " + maintenanceKindById.getKind() + " should be Predictivo")
		);
		
		verify(this.maintenanceKindRepository).findById(anyInt());
	}
	
	/**************************************************/

	@Test
	@DisplayName("Validation the Create MaintenanceKind Service in MaintenanceKindServiceImplTest Class")
	void createMaintenanceKindTest() {
		when(this.maintenanceKindRepository.save(any(MaintenanceKind.class))).thenReturn(MAINTENANCE_KIND_CREATED);
		MaintenanceKind newMaintenanceKind = this.maintenanceKindServiceImpl.createMaintenanceKind(MAINTENANCE_KIND_CREATED).getBody();
		
		assertAll(
			() -> assertNotNull(newMaintenanceKind.getIdMaintenanceKind(), () -> "The IdMaintenanceKind field cannot be null."),
			() -> assertEquals(5, newMaintenanceKind.getIdMaintenanceKind(), () -> "The IdMaintenanceKind field is " + newMaintenanceKind.getIdMaintenanceKind() + " should be 5"),
			() -> assertEquals("Proactivo", newMaintenanceKind.getKind(), () -> "The MarkName field is " + newMaintenanceKind.getKind() + " should be Proactivo")
		);
		
		verify(this.maintenanceKindRepository).save(any(MaintenanceKind.class));
	}
	
	/**************************************************/

	@Test
	@DisplayName("Validation the Update MaintenanceKind Service in MaintenanceKindServiceImplTest Class")
	void updateMaintenanceKindTest() {
		when(this.maintenanceKindRepository.save(any(MaintenanceKind.class))).thenReturn(MAINTENANCE_KIND_UPDATED);
		MaintenanceKind updatedMaintenanceKind = this.maintenanceKindServiceImpl.updateMaintenanceKind(MAINTENANCE_KIND_UPDATED).getBody();
		
		assertAll(
			() -> assertNotNull(updatedMaintenanceKind.getIdMaintenanceKind(), () -> "The IdClient field cannot be null."),
			() -> assertEquals(6, updatedMaintenanceKind.getIdMaintenanceKind(), () -> "The IdClient field is " + updatedMaintenanceKind.getIdMaintenanceKind() + " should be 6"),
			() -> assertEquals("Inspeccion", updatedMaintenanceKind.getKind(), () -> "The Name field is " + updatedMaintenanceKind.getKind() + " should be Inspeccion")
		);
		
		verify(this.maintenanceKindRepository).save(any(MaintenanceKind.class));
	}
	
	/**************************************************/
	
	
}
