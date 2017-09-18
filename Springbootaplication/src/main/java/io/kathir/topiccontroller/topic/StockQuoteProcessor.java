package io.kathir.topiccontroller.topic;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StockQuoteProcessor implements RowMapper<StockQuote>{
	

	public StockQuote mapRow(ResultSet rs, int rowNumber) throws SQLException {
		// TODO Auto-generated method stub
		StockQuote sq =new StockQuote();
		sq.setTicker(rs.getString(2));
		sq.setDate(rs.getString(3));
		sq.setPrice(rs.getInt(4));
		return sq;
	}

}
