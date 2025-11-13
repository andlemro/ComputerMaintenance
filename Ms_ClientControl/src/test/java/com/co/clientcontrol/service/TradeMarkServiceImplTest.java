package com.co.clientcontrol.service;

import static com.co.clientcontrol.utils.TradeMarkData.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.co.clientcontrol.model.TradeMark;
import com.co.clientcontrol.repository.TradeMarkRepository;

@Tag("serviceImplTest")
@ExtendWith(MockitoExtension.class)
public class TradeMarkServiceImplTest {
	
	@Mock
	TradeMarkRepository tradeMarkRepository;
	
	@InjectMocks
	TradeMarkServiceImpl tradeMarkServiceImpl;
	
	/**************************************************/
	
	@BeforeEach
	void initTest(TestInfo testInfo, TestReporter testReporter) {
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
	@DisplayName("Validation the List TradeMarks Service in TradeMarkServiceImplTest Class")
	void listTradeMarksTest() {
		when(this.tradeMarkRepository.findAll()).thenReturn(TRADE_MARK_LIST);
		List<TradeMark> listTradeMarks = this.tradeMarkServiceImpl.listTradeMarks().getBody();

		assertAll(
			() -> assertNotNull(listTradeMarks, () -> "The listTradeMarks cannot be null."),
			() -> assertEquals(3, listTradeMarks.size(), () -> "The size of listTradeMarks is not 3.")
		);
		
		verify(this.tradeMarkRepository).findAll();
	}

	/**************************************************/
	
	@Test
	@DisplayName("Validation the Get TradeMark Service in TradeMarkServiceImplTest Class")
	void getTradeMarkByIdTest() {
		when(this.tradeMarkRepository.findById(anyInt())).thenReturn(GET_TRADE_MARK_ID);
		TradeMark tradeMarkById = this.tradeMarkServiceImpl.getTradeMarkById(anyInt()).getBody();
		
		assertAll(
			() -> assertNotNull(tradeMarkById.getIdTradeMark(), () -> "The IdTradeMark field cannot be null."),
			() -> assertEquals(4, tradeMarkById.getIdTradeMark(), () -> "The IdTradeMark field is " + tradeMarkById.getIdTradeMark() + " should be 4"),
			() -> assertEquals("Hewlett-Packard", tradeMarkById.getMarkName(), () -> "The MarkName field is " + tradeMarkById.getMarkName() + " should be Hewlett-Packard")
		);
		
		verify(this.tradeMarkRepository).findById(anyInt());
	}
	
	/**************************************************/

	@Test
	@DisplayName("Validation the Create TradeMark Service in TradeMarkServiceImplTest Class")
	void createTradeMarkTest() {
		when(this.tradeMarkRepository.save(any(TradeMark.class))).thenReturn(TRADE_MARK_CREATED);
		TradeMark newTradeMark = this.tradeMarkServiceImpl.createTradeMark(TRADE_MARK_CREATED).getBody();
		
		assertAll(
			() -> assertNotNull(newTradeMark.getIdTradeMark(), () -> "The IdTradeMark field cannot be null."),
			() -> assertEquals(5, newTradeMark.getIdTradeMark(), () -> "The IdTradeMark field is " + newTradeMark.getIdTradeMark() + " should be 5"),
			() -> assertEquals("MSI", newTradeMark.getMarkName(), () -> "The MarkName field is " + newTradeMark.getMarkName() + " should be MSI")
		);
		
		verify(this.tradeMarkRepository).save(any(TradeMark.class));
	}
	
	/**************************************************/

	@Test
	@DisplayName("Validation the Update TradeMark Service in TradeMarkServiceImplTest Class")
	void updateTradeMarkTest() {
		when(this.tradeMarkRepository.save(any(TradeMark.class))).thenReturn(TRADE_MARK_UPDATED);
		TradeMark updatedTradeMark = this.tradeMarkServiceImpl.updateTradeMark(TRADE_MARK_UPDATED).getBody();
		
		assertAll(
			() -> assertNotNull(updatedTradeMark.getIdTradeMark(), () -> "The IdClient field cannot be null."),
			() -> assertEquals(6, updatedTradeMark.getIdTradeMark(), () -> "The IdClient field is " + updatedTradeMark.getIdTradeMark() + " should be 6"),
			() -> assertEquals("Dell", updatedTradeMark.getMarkName(), () -> "The Name field is " + updatedTradeMark.getMarkName() + " should be Dell")
		);
		
		verify(this.tradeMarkRepository).save(any(TradeMark.class));
	}
	
	/**************************************************/

}
