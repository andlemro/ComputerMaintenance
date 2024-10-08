package com.co.clientcontrol.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "trade_marks")
public class TradeMark {

	@Id
	@Column(name = "id_trade_mark", unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trade_marks_generator")
	@SequenceGenerator(name = "trade_marks_generator", sequenceName = "trade_marks_seq", allocationSize = 1)
	private Integer idTradeMark;

	@Column(name = "mark_name", nullable = false, length = 30)
	private String markName;

}
