package com.co.cliencontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.cliencontrol.interfaces.ITradeMarkService;
import com.co.cliencontrol.model.TradeMark;
import com.co.cliencontrol.repository.TradeMarkRepository;

@Service
public class TradeMarkServiceImpl implements ITradeMarkService {

	@Autowired
	TradeMarkRepository tradeMarkRepository;
	
	/**************************************************/

	@Override
	public List<TradeMark> listTradeMarks() {
		return this.tradeMarkRepository.findAll();
	}
	
	/**************************************************/

	@Override
	public TradeMark getTradeMarkById(Integer idTradeMark) {
		return this.tradeMarkRepository.findById(idTradeMark).get();
	}
	
	/**************************************************/

	@Override
	public void saveTradeMark(TradeMark tradeMark) {
		this.tradeMarkRepository.save(tradeMark);
	}
	
	/**************************************************/

	@Override
	public void delteTradeMark(Integer idTradeMark) {
		this.tradeMarkRepository.deleteById(idTradeMark);
	}
	
	/**************************************************/

	@Override
	public TradeMark updateTradeMark(TradeMark tradeMark) {
		return this.tradeMarkRepository.save(tradeMark);
	}

}
