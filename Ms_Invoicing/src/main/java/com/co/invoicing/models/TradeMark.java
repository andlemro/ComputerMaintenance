package com.co.invoicing.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "trade_mark")
public class TradeMark {

	@Id
	@Column(name = "id_trade_mark", unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idTradeMark;

	@Column(name = "mark_name", nullable = false, length = 50)
	private String markName;

}
