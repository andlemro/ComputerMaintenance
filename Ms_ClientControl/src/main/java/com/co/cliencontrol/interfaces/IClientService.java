package com.co.cliencontrol.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.co.cliencontrol.model.Client;

public interface IClientService {

	public ResponseEntity<List<Client>> listClients();

	public ResponseEntity<Client> getClientById(Integer idClient);

	public ResponseEntity<Client> createClient(Client client);

	public ResponseEntity<Void> deleteClientById(Integer idClient);

	public ResponseEntity<Client> updateClient(Client client);
}
