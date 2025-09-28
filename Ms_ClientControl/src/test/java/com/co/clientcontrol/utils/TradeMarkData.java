package com.co.clientcontrol.utils;

import java.util.List;
import java.util.Optional;

import com.co.clientcontrol.model.TradeMark;

public class TradeMarkData {
	
	public final static TradeMark TRADE_MARK_MODEL_TEST = new TradeMark(1, "Asus");
	
	public final static List<TradeMark> TRADE_MARK_LIST = List.of(
			new TradeMark(1, "Asus"),
			new TradeMark(2, "Toshiba"),
			new TradeMark(3, "Lenovo")
		);
		
	public final static Optional<TradeMark> GET_TRADE_MARK_ID = Optional.ofNullable(new TradeMark(4, "Hewlett-Packard"));
	
	public final static TradeMark TRADE_MARK_CREATED = new TradeMark(5, "MSI");
	
	public final static TradeMark TRADE_MARK_UPDATED = new TradeMark(6, "Dell");

}
