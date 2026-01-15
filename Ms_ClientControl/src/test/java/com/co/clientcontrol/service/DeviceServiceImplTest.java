package com.co.clientcontrol.service;

import static com.co.clientcontrol.utils.DeviceData.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.co.clientcontrol.model.Device;
import com.co.clientcontrol.repository.DeviceRepository;

@Tag("serviceImplTest")
@ExtendWith(MockitoExtension.class)
public class DeviceServiceImplTest {
	
	@Mock
	DeviceRepository deviceRepository;
	
	@InjectMocks
	DeviceServiceImpl deviceServiceImpl;
	
	DateTimeFormatter FORMATTER;
	
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
		
		this.FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	}

	/**************************************************/
	
	@Test
	@DisplayName("Validation the List Devices Service in DeviceServiceImplTest Class")
	void listDevicesTest() {
		
		// Given
		when(this.deviceRepository.findAll()).thenReturn(DEVICES_LIST);
		
		// When
		List<Device> listInvoices = this.deviceServiceImpl.listDevices().getBody();

		// Then
		assertAll(
			() -> assertNotNull(listInvoices, () -> "The listInvoices cannot be null."),
			() -> assertEquals(3, listInvoices.size(), () -> "The size of listInvoices is not 3.")
		);
		
		verify(this.deviceRepository).findAll();
	}

	/**************************************************/
	
	@Test
	@DisplayName("Validation the Get Device Service in DeviceServiceImplTest Class")
	void getDeviceByIdTest() {
		
		// Given
		LocalDateTime dateRegistered = LocalDateTime.parse("05/11/2025 16:30", this.FORMATTER);
		when(this.deviceRepository.findById(anyInt())).thenReturn(GET_DEVICE_ID);
		
		// When
		Device deviceById = this.deviceServiceImpl.getDeviceById(anyInt()).getBody();
		
		// Then
		assertAll(
			() -> assertNotNull(deviceById.getIdDevice(), () -> "The IdDevice field cannot be null."),
			() -> assertEquals(4, deviceById.getIdDevice(), () -> "The IdDevice field is " + deviceById.getIdDevice() + " should be 4"),
			() -> assertEquals(dateRegistered, deviceById.getMaintenanceDate(), () -> "The MaintenanceDate field is " + deviceById.getMaintenanceDate() + " should be '05/11/2025 16:30'"),
			() -> assertEquals("Revision de Torre", deviceById.getDescription(), () -> "The Description field is " + deviceById.getDescription() + " should be 'Revision de Torre'"),
			() -> assertEquals("T120-DA", deviceById.getModel(), () -> "The Model field is " + deviceById.getModel() + " should be 'T120-DA'"),
			() -> assertEquals(1, deviceById.getIdClient().getIdClient(), () -> "The IdClient field is " + deviceById.getIdClient().getIdClient() + " should be 1"),
			() -> assertEquals("Maria", deviceById.getIdClient().getName(), () -> "The name client field is " + deviceById.getIdClient().getName() + " should be 'Maria'"),
			() -> assertEquals("Perez", deviceById.getIdClient().getLastName(), () -> "The lastName client field is " + deviceById.getIdClient().getLastName() + " should be 'Perez'"),
			() -> assertEquals(1, deviceById.getIdTradeMark().getIdTradeMark(), () -> "The IdTradeMark field is " + deviceById.getIdTradeMark().getIdTradeMark() + " should be 1"),
			() -> assertEquals("Asus", deviceById.getIdTradeMark().getMarkName(), () -> "The MarkName field is " + deviceById.getIdTradeMark().getMarkName() + " should be 'Asus'"),
			() -> assertEquals(1, deviceById.getIdMaintenanceKind().getIdMaintenanceKind(), () -> "The IdMaintenanceKind field is " + deviceById.getIdMaintenanceKind().getIdMaintenanceKind() + " should be 1"),
			() -> assertEquals("Preventivo", deviceById.getIdMaintenanceKind().getKind(), () -> "The nameKind of MaintenanceKind field is " + deviceById.getIdMaintenanceKind().getKind() + " should be 'Preventivo'"),
			() -> assertEquals(1, deviceById.getIdDeviceType().getIdDeviceType(), () -> "The IdDeviceType field is " + deviceById.getIdDeviceType().getIdDeviceType() + " should be 1"),
			() -> assertEquals("Portatil", deviceById.getIdDeviceType().getDeviceTypeName(), () -> "The DeviceTypeName field is " + deviceById.getIdDeviceType().getDeviceTypeName() + " should be 'Portatil'")
		);
		
		verify(this.deviceRepository).findById(anyInt());
	}
	
	/**************************************************/
	
	@Test
	@DisplayName("Validation the create Device Service in DeviceServiceImplTest Class")
	void createDeviceTest() {
		
		// Given
		LocalDateTime dateRegistered = LocalDateTime.parse("09/11/2025 18:20", this.FORMATTER);
		when(this.deviceRepository.save(any(Device.class))).thenReturn(DEVICE_CREATED);
		
		// When
		Device newDevice = this.deviceServiceImpl.createDevice(DEVICE_CREATED).getBody();
		
		// Then
		assertAll(
			() -> assertNotNull(newDevice.getIdDevice(), () -> "The IdDevice field cannot be null."),
			() -> assertEquals(5, newDevice.getIdDevice(), () -> "The IdDevice field is " + newDevice.getIdDevice() + " should be 5"),
			() -> assertEquals(dateRegistered, newDevice.getMaintenanceDate(), () -> "The MaintenanceDate field is " + newDevice.getMaintenanceDate() + " should be '09/11/2025 18:20'"),
			() -> assertEquals("Fallo de bisagras portatil", newDevice.getDescription(), () -> "The Description field is " + newDevice.getDescription() + " should be 'Fallo de bisagras portatil'"),
			() -> assertEquals("LT-1524", newDevice.getModel(), () -> "The Model field is " + newDevice.getModel() + " should be 'LT-1524'"),
			() -> assertEquals(1, newDevice.getIdClient().getIdClient(), () -> "The IdClient field is " + newDevice.getIdClient().getIdClient() + " should be 1"),
			() -> assertEquals("Maria", newDevice.getIdClient().getName(), () -> "The name client field is " + newDevice.getIdClient().getName() + " should be 'Maria'"),
			() -> assertEquals("Perez", newDevice.getIdClient().getLastName(), () -> "The lastName client field is " + newDevice.getIdClient().getLastName() + " should be 'Perez'"),
			() -> assertEquals(1, newDevice.getIdTradeMark().getIdTradeMark(), () -> "The IdTradeMark field is " + newDevice.getIdTradeMark().getIdTradeMark() + " should be 1"),
			() -> assertEquals("Asus", newDevice.getIdTradeMark().getMarkName(), () -> "The MarkName field is " + newDevice.getIdTradeMark().getMarkName() + " should be 'Asus'"),
			() -> assertEquals(1, newDevice.getIdMaintenanceKind().getIdMaintenanceKind(), () -> "The IdMaintenanceKind field is " + newDevice.getIdMaintenanceKind().getIdMaintenanceKind() + " should be 1"),
			() -> assertEquals("Preventivo", newDevice.getIdMaintenanceKind().getKind(), () -> "The nameKind of MaintenanceKind field is " + newDevice.getIdMaintenanceKind().getKind() + " should be 'Preventivo'"),
			() -> assertEquals(1, newDevice.getIdDeviceType().getIdDeviceType(), () -> "The IdDeviceType field is " + newDevice.getIdDeviceType().getIdDeviceType() + " should be 1"),
			() -> assertEquals("Portatil", newDevice.getIdDeviceType().getDeviceTypeName(), () -> "The DeviceTypeName field is " + newDevice.getIdDeviceType().getDeviceTypeName() + " should be 'Portatil'")
		);
		
		verify(this.deviceRepository).save(any(Device.class));
	}
	
	/**************************************************/
	
	@Test
	@DisplayName("Validation the update Device Service in DeviceServiceImplTest Class")
	void updateDeviceTest() {
		
		// Given
		LocalDateTime dateRegistered = LocalDateTime.parse("14/11/2025 07:40", this.FORMATTER);
		when(this.deviceRepository.save(any(Device.class))).thenReturn(DEVICE_UPDATED);
		
		// When
		Device newDevice = this.deviceServiceImpl.createDevice(DEVICE_UPDATED).getBody();
		
		// Then
		assertAll(
			() -> assertNotNull(newDevice.getIdDevice(), () -> "The IdDevice field cannot be null."),
			() -> assertEquals(6, newDevice.getIdDevice(), () -> "The IdDevice field is " + newDevice.getIdDevice() + " should be 6"),
			() -> assertEquals(dateRegistered, newDevice.getMaintenanceDate(), () -> "The MaintenanceDate field is " + newDevice.getMaintenanceDate() + " should be '14/11/2025 07:40'"),
			() -> assertEquals("Revision General de portatil Lenovo", newDevice.getDescription(), () -> "The Description field is " + newDevice.getDescription() + " should be 'Revision General de portatil Lenovo'"),
			() -> assertEquals("DA-1423T", newDevice.getModel(), () -> "The Model field is " + newDevice.getModel() + " should be 'DA-1423T'"),
			() -> assertEquals(1, newDevice.getIdClient().getIdClient(), () -> "The IdClient field is " + newDevice.getIdClient().getIdClient() + " should be 1"),
			() -> assertEquals("Maria", newDevice.getIdClient().getName(), () -> "The name client field is " + newDevice.getIdClient().getName() + " should be 'Maria'"),
			() -> assertEquals("Perez", newDevice.getIdClient().getLastName(), () -> "The lastName client field is " + newDevice.getIdClient().getLastName() + " should be 'Perez'"),
			() -> assertEquals(1, newDevice.getIdTradeMark().getIdTradeMark(), () -> "The IdTradeMark field is " + newDevice.getIdTradeMark().getIdTradeMark() + " should be 1"),
			() -> assertEquals("Asus", newDevice.getIdTradeMark().getMarkName(), () -> "The MarkName field is " + newDevice.getIdTradeMark().getMarkName() + " should be 'Asus'"),
			() -> assertEquals(1, newDevice.getIdMaintenanceKind().getIdMaintenanceKind(), () -> "The IdMaintenanceKind field is " + newDevice.getIdMaintenanceKind().getIdMaintenanceKind() + " should be 1"),
			() -> assertEquals("Preventivo", newDevice.getIdMaintenanceKind().getKind(), () -> "The nameKind of MaintenanceKind field is " + newDevice.getIdMaintenanceKind().getKind() + " should be 'Preventivo'"),
			() -> assertEquals(1, newDevice.getIdDeviceType().getIdDeviceType(), () -> "The IdDeviceType field is " + newDevice.getIdDeviceType().getIdDeviceType() + " should be 1"),
			() -> assertEquals("Portatil", newDevice.getIdDeviceType().getDeviceTypeName(), () -> "The DeviceTypeName field is " + newDevice.getIdDeviceType().getDeviceTypeName() + " should be 'Portatil'")
		);
		
		verify(this.deviceRepository).save(any(Device.class));
	}
	
	/**************************************************/
	
	

}
