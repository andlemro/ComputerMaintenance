package com.co.clientcontrol.service;

import static com.co.clientcontrol.utils.DeviceTypeData.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.co.clientcontrol.model.DeviceType;
import com.co.clientcontrol.repository.DeviceTypeRepository;

@Tag("serviceImplTest")
@ExtendWith(MockitoExtension.class)
public class DeviceTypeServiceImplTest {

	@Mock
	DeviceTypeRepository deviceTypeRepository;
	
	@InjectMocks
	DeviceTypeServiceImpl deviceTypeServiceImpl;
	
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
	@DisplayName("Validation the List DevicesTypes Service in DeviceTypeServiceImplTest Class")
	void listDevicesTypesTest() {
		when(this.deviceTypeRepository.findAll()).thenReturn(DEVICE_TYPE_LIST);
		List<DeviceType> listDevicesTypes = this.deviceTypeServiceImpl.listDevicesTypes().getBody();

		assertAll(
			() -> assertNotNull(listDevicesTypes, () -> "The listDevicesTypes cannot be null."),
			() -> assertEquals(2, listDevicesTypes.size(), () -> "The size of listDevicesTypes is not 3.")
		);
		
		verify(this.deviceTypeRepository).findAll();
	}

	/**************************************************/
	
	@Test
	@DisplayName("Validation the Get DeviceType Service in DeviceTypeServiceImplTest Class")
	void getDeviceTypeByIdTest() {
		when(this.deviceTypeRepository.findById(anyInt())).thenReturn(GET_DEVICE_TYPE_ID);
		DeviceType deviceTypeById = this.deviceTypeServiceImpl.getDeviceTypeById(anyInt()).getBody();
		
		assertAll(
			() -> assertNotNull(deviceTypeById.getIdDeviceType(), () -> "The IdDeviceType field cannot be null."),
			() -> assertEquals(4, deviceTypeById.getIdDeviceType(), () -> "The IdDeviceType field is " + deviceTypeById.getIdDeviceType() + " should be 4"),
			() -> assertEquals("Torre", deviceTypeById.getDeviceTypeName(), () -> "The DeviceType field is " + deviceTypeById.getDeviceTypeName() + " should be Torre")
		);
		
		verify(this.deviceTypeRepository).findById(anyInt());
	}
	
	/**************************************************/

	@Test
	@DisplayName("Validation the Create DeviceType Service in DeviceTypeServiceImplTest Class")
	void createDeviceTypeTest() {
		when(this.deviceTypeRepository.save(any(DeviceType.class))).thenReturn(DEVICE_TYPE_CREATED);
		DeviceType newDeviceType = this.deviceTypeServiceImpl.createDeviceType(DEVICE_TYPE_CREATED).getBody();
		
		assertAll(
			() -> assertNotNull(newDeviceType.getIdDeviceType(), () -> "The IdDeviceType field cannot be null."),
			() -> assertEquals(5, newDeviceType.getIdDeviceType(), () -> "The IdDeviceType field is " + newDeviceType.getIdDeviceType() + " should be 5"),
			() -> assertEquals("Todo en uno", newDeviceType.getDeviceTypeName(), () -> "The DeviceTypeName field is " + newDeviceType.getDeviceTypeName() + " should be Todo en uno")
		);
		
		verify(this.deviceTypeRepository).save(any(DeviceType.class));
	}
	
	/**************************************************/

	@Test
	@DisplayName("Validation the Update DeviceType Service in DeviceTypeServiceImplTest Class")
	void updateDeviceTypeTest() {
		when(this.deviceTypeRepository.save(any(DeviceType.class))).thenReturn(DEVICE_TYPE_UPDATED);
		DeviceType updatedDeviceType = this.deviceTypeServiceImpl.uptadeDeviceType(DEVICE_TYPE_UPDATED).getBody();
		
		assertAll(
			() -> assertNotNull(updatedDeviceType.getIdDeviceType(), () -> "The IdClient field cannot be null."),
			() -> assertEquals(6, updatedDeviceType.getIdDeviceType(), () -> "The IdClient field is " + updatedDeviceType.getIdDeviceType() + " should be 6"),
			() -> assertEquals("Laptop", updatedDeviceType.getDeviceTypeName(), () -> "The Name field is " + updatedDeviceType.getDeviceTypeName() + " should be Laptop")
		);
		
		verify(this.deviceTypeRepository).save(any(DeviceType.class));
	}
	
	/**************************************************/
}
