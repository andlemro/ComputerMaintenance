package com.co.clientcontrol.utils;

import java.util.List;
import java.util.Optional;

import com.co.clientcontrol.model.Client;

public class ClientData {

	public final static Client CLIENT_MODEL_TEST = new Client(1, "Maria", "Perez", "3144213212", "maria@test.com", "calle 21A # 33 - 44", "Sembrador");
	
	public final static List<Client> CLIENT_LIST = List.of(
			new Client(1, "Juanita", "Gutierrez", "3175549021", "juanita@test.com", "calle 11A # 24 - 31", "Colombia"),
			new Client(2, "Carlos", "Figeroa", "3112458823", "Carlos@test.com", "Carrera 32A # 24 - 98", "Santa Barbara"),
			new Client(3, "Marta", "Rodriguez", "3152341422", "Marta@test.com", "calle 54A # 22 - 33", "Sembrador")
		);
		
	public final static Optional<Client> GET_CLIENT_ID = Optional.ofNullable(new Client(4, "Miguel", "Torres", "3214421452", "mighel@test.com", "calle 51A # 11 - 34", "Colombia"));
	
	public final static Client CLIENT_CREATED = new Client(5, "Carla", "Gutierrez", "3432239143", "carla@test.com", "calle 12A # 34 - 82", "Robles");
	
	public final static Client CLIENT_UPDATED = new Client(6, "Jhon", "Bente", "3223415621", "jhon@test.com", "carrera 42A # 21 - 58", "Libertadores");
	
}
