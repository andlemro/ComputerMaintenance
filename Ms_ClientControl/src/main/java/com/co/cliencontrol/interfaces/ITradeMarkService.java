package com.co.cliencontrol.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.co.cliencontrol.model.TradeMark;

public interface ITradeMarkService {

	public ResponseEntity<List<TradeMark>> listTradeMarks();

	public ResponseEntity<TradeMark> getTradeMarkById(Integer idTradeMark);

	public ResponseEntity<TradeMark> createTradeMark(TradeMark tradeMark);

	public ResponseEntity<Void> deleteTradeMark(Integer idTradeMark);

	public ResponseEntity<TradeMark> updateTradeMark(TradeMark tradeMark);

}
