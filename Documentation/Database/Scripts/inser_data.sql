-- Data to Clients
INSERT INTO public.clients(
	id_client, client_name, client_last_name, phone_number, email, address, neighborhood)
	VALUES 
	(1, 'Andres', 'Lopez', '3215582341', 'andres.lemos@mail.com', 'Calle 21 # 33 - 47', 'Santa Barbara'),
	(2, 'Maria', 'Cordoba', '3241127789', 'maria.cordoba@mail.com', 'Carrera 27 # 31 - 52', 'Libertadores'),
	(3, 'Carlos', 'Rodriguez', '3111774189', 'carlos.rodriguez@mail.com', 'Carrera 41 # 21 - 77', 'Buenos Aires');

-- Data to Trade Marks
INSERT INTO public.trade_marks(
	id_trade_mark, mark_name)
	VALUES (1, 'Asus')
	(2, 'Toshiba'),
	(3, 'Lenovo');

-- Data to Device Type
INSERT INTO public.devices_types(
	id_device_type, device_type_name)
	VALUES 
	(1, 'Portatil'),
	(2, 'Todo en uno'),
	(3, 'Torre');

-- Data to Company
INSERT INTO public.company(
	id_company, nit, company_name, address, email)
	VALUES (1, '1111', 'CompoCord', 'calle 27 # 33 - 44', 'CumpoCord@mail.com');

-- Data to Devices
INSERT INTO public.devices(
	description, model, fk_id_client, 
	fk_id_trade_mark, fk_id_maintenance_kind, fk_id_device_type, 
	id_client, id_device_type, id_maintenance_kind, id_trade_mark)
	VALUES ('test', 'FSA-123', 3, 1, 1, 1, 3, 1, 1, 1);