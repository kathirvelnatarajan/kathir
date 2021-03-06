package io.kathir.topiccontroller.topic;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;



public class DatabaseRow implements RowMapper {
	public Map mapRow(ResultSet rs ,int rowNum) throws SQLException{
		ResultSetMetaData rsd = rs.getMetaData();
		int coloumnCount = rsd.getColumnCount();
		Map<String, String> row = new HashMap<String, String>();
		for(int i = 0; i<coloumnCount;i++) {
			String coloumnName = rsd.getColumnName(i);
			String coloumnValue = rs.getString(coloumnName);
			row.put(coloumnName, coloumnValue);
		}
		return row;
	}

}
