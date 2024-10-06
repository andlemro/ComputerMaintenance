package com.co.cliencontrol.interfaces;

import java.util.List;

import com.co.cliencontrol.model.TradeMark;

public interface ITradeMarkService {

	public List<TradeMark> listTradeMarks();

	public TradeMark getTradeMarkById(Integer idTradeMark);

	public void saveTradeMark(TradeMark tradeMark);

	public void delteTradeMark(Integer idTradeMark);

	public TradeMark updateTradeMark(TradeMark tradeMark);

}
