package io.kathir.topiccontroller.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseManager {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseManager(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<MovingAverage> fetchAverage(String stockTicker){
    	Object[] args = new Object[]{stockTicker};
    	return jdbcTemplate.query("SELECT * from stock_mov_average where stock_ticker = ?",args, new DatabaseMovingAverageProcessor());
    }
    public List<StockQuote> fetchStockQuotes(String stockTicker){
    	Object[] args1 = new Object[] {stockTicker};
    	return jdbcTemplate.query("SELECT * from stock_quotes where stock_ticker = ?", args1, new StockQuoteProcessor());
    }
   
}
