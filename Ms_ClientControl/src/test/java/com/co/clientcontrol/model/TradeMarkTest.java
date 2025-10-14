package com.co.clientcontrol.model;

import static com.co.clientcontrol.utils.TradeMarkData.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

@Tag("modelTest")
public class TradeMarkTest {

	private TradeMark tradeMark;
	
	/**************************************************/
	
	@BeforeEach
	void initTest(TestInfo testInfo, TestReporter testReporter) {
		
		this.tradeMark = TRADE_MARK_MODEL_TEST;
		
		testReporter.publishEntry(
				"Running: " + 
				testInfo.getDisplayName() +
				" - " +
				testInfo.getTestMethod().orElse(null).getName() +
				" with the Tag: " +
				testInfo.getTags()
		);
		
	}
	
	/**************************************************/
	
	@Test
	@DisplayName("Validation of not null fields in TradeMarkTest model")
	void notNullFieldsTest() {
		assertAll(
			() -> assertNotNull(this.tradeMark.getIdTradeMark(),
					() -> "The idTradeMark field cannot be null."),
			() -> assertNotNull(this.tradeMark.getMarkName(), 
					() -> "The markName field cannot be null.")
		);
	}
	
	/**************************************************/
	
	@Test
	@DisplayName("Validation of maximum length in TradeMarkTest model")
	void validateLengthTest() {
		int tradeMarkNameLimit = 30;
		assertAll(
			() -> assertTrue(this.tradeMark.getMarkName().length() < tradeMarkNameLimit,
					() -> "The tradeMark field exceeded the " + tradeMarkNameLimit + " character limit")
		);
	}

}
