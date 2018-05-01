package com.company.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.company.models.Location;

public class LocationMapper implements RowMapper<Location>{

	@Override
	public Location mapRow(ResultSet rs, int arg1) throws SQLException {
		Location location = new Location();
		location.setName(rs.getString("REGION_NAME"));
		location.setLat(rs.getDouble("LAT"));
		location.setLng(rs.getDouble("LNG"));
		return location;
	}

}
