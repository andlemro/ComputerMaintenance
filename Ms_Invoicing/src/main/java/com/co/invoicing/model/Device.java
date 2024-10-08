package com.co.invoicing.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "devices")
public class Device {

	@Id
	@Column(name = "id_device", unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "device_generator")
	@SequenceGenerator(name = "device_generator", sequenceName = "devices_seq", allocationSize = 1)
	private Integer idDevice;

	@Column(name = "maintenance_date")
	private LocalDateTime maintenanceDate;

	@Column(name = "description", nullable = false, length = 200)
	private String description;

	@Column(name = "model", nullable = false, length = 30)
	private String model;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_client", referencedColumnName = "id_client", nullable = false)
	private Client idClient;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_trade_mark", referencedColumnName = "id_trade_mark", nullable = false)
	private TradeMark idTradeMark;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_maintenance_kind", referencedColumnName = "id_maintenance_kind", nullable = false)
	private MaintenanceKind idMaintenanceKind;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_device_type", referencedColumnName = "id_device_type", nullable = false)
	private DeviceType idDeviceType;

}
