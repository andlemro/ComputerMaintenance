package com.co.cliencontrol.controller;

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

import com.co.cliencontrol.interfaces.ITradeMarkService;
import com.co.cliencontrol.model.TradeMark;

import jakarta.websocket.server.PathParam;

@RestController
@CrossOrigin("*")
@RequestMapping("/tradeMark")
public class TradeMarkController {

	@Autowired
	ITradeMarkService tradeMarkService;

	/**************************************************/

	@GetMapping()
	public ResponseEntity<List<TradeMark>> listTradeMarks() {
		return this.tradeMarkService.listTradeMarks();
	}

	/**************************************************/

	@GetMapping(value = "/{idTradeMark}")
	public ResponseEntity<TradeMark> getTradeMarkById(@PathVariable Integer idTradeMark) {
		return this.tradeMarkService.getTradeMarkById(idTradeMark);
	}

	/**************************************************/

	@PostMapping(value = "/create")
	public ResponseEntity<TradeMark> createTradeMark(@RequestBody TradeMark tradeMark) {
		return this.tradeMarkService.createTradeMark(tradeMark);
	}

	/**************************************************/

	@DeleteMapping(value = "/delete")
	public ResponseEntity<Void> deleteTradeMark(@PathParam("idTradeMark") Integer idTradeMark) {
		return this.tradeMarkService.deleteTradeMark(idTradeMark);
	}

	/**************************************************/

	@PutMapping(value = "/update")
	public ResponseEntity<TradeMark> updateTradeMark(@RequestBody TradeMark tradeMark) {
		return this.tradeMarkService.updateTradeMark(tradeMark);
	}
}
