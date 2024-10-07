create database computer_maintenance;

create table trade_marks (
	id_trade_mark Serial PRIMARY KEY UNIQUE,
	mark_name VARCHAR(30) NOT NULL
);

create table maintenance_kind (
	id_maintenance_kind Serial PRIMARY KEY UNIQUE,
	kind VARCHAR(30) NOT NULL
);

create table devices_types (
	id_device_type Serial PRIMARY KEY UNIQUE,
	device_type_name VARCHAR(30) NOT NULL
);

create table company (
	id_company Serial PRIMARY KEY UNIQUE,
	nit NUMERIC UNIQUE NOT NULL, 
	company_name VARCHAR(40) NOT NULL,
	address VARCHAR(40) NOT NULL,
	email VARCHAR(50) NOT NULL
);

create table clients (
	id_client Serial PRIMARY KEY UNIQUE,
	client_name VARCHAR(40) NOT NULL, 
	client_last_name VARCHAR(40) NOT NULL,
	phone_number VARCHAR(12) NOT NULL,
	email VARCHAR(40) NOT NULL,
	address VARCHAR(30) NOT NULL,
	neighborhood VARCHAR(50) NOT NULL
);

create table devices (
	id_device Serial PRIMARY KEY UNIQUE,
	maintenance_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
	description VARCHAR(200) NOT NULL,
	model VARCHAR(30) NOT NULL,
	id_client INTEGER NOT NULL,
	id_trade_mark INTEGER NOT NULL,
	id_maintenance_kind INTEGER NOT NULL,
	id_device_type INTEGER NOT NULL,
	CONSTRAINT id_client FOREIGN KEY (id_client) REFERENCES clients (id_client) ON DELETE CASCADE,						 
	CONSTRAINT id_trade_mark FOREIGN KEY (id_trade_mark) REFERENCES trade_marks (id_trade_mark) ON DELETE CASCADE,
	CONSTRAINT id_maintenance_kind FOREIGN KEY (id_maintenance_kind) REFERENCES maintenance_kind (id_maintenance_kind) ON DELETE CASCADE,
	CONSTRAINT id_device_type FOREIGN KEY (id_device_type) REFERENCES devices_types (id_device_type) ON DELETE CASCADE
);

create table invoices (
	id_invoice Serial PRIMARY KEY UNIQUE,
	invoice_number NUmeric NOT NULL,
	service_description VARCHAR(40) NOT NULL, 
	date_registered TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	subtotal_cost DECIMAL(15,2) NOT NULL,
	iva_cost DECIMAL(15,2) NOT NULL,
	total_cost DECIMAL(15,2) NOT NULL,
	id_client INTEGER NOT NULL,
	id_company INTEGER NOT NULL,
	CONSTRAINT id_client FOREIGN KEY (id_client) REFERENCES clients (id_client) ON DELETE CASCADE,						 
	CONSTRAINT id_company FOREIGN KEY (id_company) REFERENCES company (id_company) ON DELETE CASCADE
);

create table users (
	id_user Serial PRIMARY KEY UNIQUE,
	username VARCHAR(20) NOT NULL,
	pass VARCHAR(20) NOT NULL
);

create table roles (
	id_rol Serial PRIMARY KEY UNIQUE,
	rol_name VARCHAR(20) NOT NULL
);

create table permissions (
	id_permission Serial PRIMARY KEY UNIQUE,
	permission_name VARCHAR(25) NOT NULL,
	description VARCHAR(40) NOT NULL
);

create table users_roles (
	id_user INTEGER,
	id_rol INTEGER,
	PRIMARY KEY (id_user, id_rol),
    CONSTRAINT fk_id_user FOREIGN KEY (id_user) REFERENCES users (id_user),
    CONSTRAINT fk_id_rol FOREIGN KEY (id_rol) REFERENCES roles (id_rol)
);

create table roles_permissions (
	id_rol INTEGER,
	id_permission INTEGER,
	PRIMARY KEY (id_rol, id_permission),
    CONSTRAINT fk_id_rol FOREIGN KEY (id_rol) REFERENCES roles (id_rol),
    CONSTRAINT fk_id_permission FOREIGN KEY (id_permission) REFERENCES permissions (id_permission)
);
