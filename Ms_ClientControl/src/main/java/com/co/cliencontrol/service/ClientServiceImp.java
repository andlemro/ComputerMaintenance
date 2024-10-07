package com.co.cliencontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.co.cliencontrol.interfaces.IClientService;
import com.co.cliencontrol.model.Client;
import com.co.cliencontrol.repository.ClientRepository;

@Service
public class ClientServiceImp implements IClientService {

	@Autowired
	ClientRepository clientRepository;

	/**************************************************/

	@Override
	public ResponseEntity<List<Client>> listClients() {
		try {
			return new ResponseEntity<>(this.clientRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<Client> getClientById(Integer idClient) {
		try {
			return new ResponseEntity<>(this.clientRepository.findById(idClient).get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<Client> createClient(Client client) {
		try {
			return new ResponseEntity<>(this.clientRepository.save(client), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<Void> deleteClientById(Integer idClient) {
		try {
			this.clientRepository.deleteById(idClient);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<Client> updateClient(Client client) {
		try {
			return new ResponseEntity<>(this.clientRepository.save(client), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
