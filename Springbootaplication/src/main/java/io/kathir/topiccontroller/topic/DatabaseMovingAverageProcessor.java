package io.kathir.topiccontroller.topic;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DatabaseMovingAverageProcessor implements RowMapper {

	public MovingAverage mapRow(ResultSet rs, int rowNumber) throws SQLException {
		MovingAverage ma =new MovingAverage();
		ma.setStockTicker(rs.getString(2));
		ma.setDate(rs.getString(3));
		ma.setAverage(rs.getInt(4));
		return ma;
	}
}
