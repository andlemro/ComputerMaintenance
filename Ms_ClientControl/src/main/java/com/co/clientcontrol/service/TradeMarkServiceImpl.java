package com.co.clientcontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.co.clientcontrol.interfaces.ITradeMarkService;
import com.co.clientcontrol.model.TradeMark;
import com.co.clientcontrol.repository.TradeMarkRepository;

@Service
public class TradeMarkServiceImpl implements ITradeMarkService {

	@Autowired
	TradeMarkRepository tradeMarkRepository;

	/**************************************************/

	@Override
	public ResponseEntity<List<TradeMark>> listTradeMarks() {
		try {
			return new ResponseEntity<>(this.tradeMarkRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<TradeMark> getTradeMarkById(Integer idTradeMark) {
		try {
			return new ResponseEntity<TradeMark>(this.tradeMarkRepository.findById(idTradeMark).get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<TradeMark>(HttpStatus.NOT_FOUND);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<TradeMark> createTradeMark(TradeMark tradeMark) {
		try {
			return new ResponseEntity<TradeMark>(this.tradeMarkRepository.save(tradeMark), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<TradeMark>(HttpStatus.BAD_REQUEST);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<Void> deleteTradeMark(Integer idTradeMark) {
		try {
			this.tradeMarkRepository.deleteById(idTradeMark);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<TradeMark> updateTradeMark(TradeMark tradeMark) {
		try {
			return new ResponseEntity<TradeMark>(this.tradeMarkRepository.save(tradeMark), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<TradeMark>(HttpStatus.BAD_REQUEST);
		}
	}

}
