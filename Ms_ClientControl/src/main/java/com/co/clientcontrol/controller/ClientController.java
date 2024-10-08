package com.co.clientcontrol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.clientcontrol.interfaces.IClientService;
import com.co.clientcontrol.model.Client;

import jakarta.websocket.server.PathParam;

@RestController
@CrossOrigin("*")
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	IClientService clientService;

	/**************************************************/

	@GetMapping()
	public ResponseEntity<List<Client>> listClients() {
		return this.clientService.listClients();
	}

	/**************************************************/

	@GetMapping(value = "/{idClient}")
	public ResponseEntity<Client> getClientById(@PathVariable("idClient") Integer idClient) {
		return this.clientService.getClientById(idClient);
	}

	/**************************************************/

	@PostMapping(value = "/create")
	public ResponseEntity<Client> createClient(@RequestBody Client client) {
		return this.clientService.createClient(client);
	}
	
	/**************************************************/

	@DeleteMapping(value = "/delete")
	public ResponseEntity<Void> deleteClient(@PathParam("idClient") Integer idClient) {
		return this.clientService.deleteClientById(idClient);
	}
	
	/**************************************************/
	
	@PutMapping(value = "/update")
	public ResponseEntity<Client> updateClient(@RequestBody Client client) {
		return this.clientService.updateClient(client);
	}
}
