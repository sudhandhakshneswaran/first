package com.company.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.company.models.Soil;

public class SoilMapper implements RowMapper<Soil> {

	@Override
	public Soil mapRow(ResultSet rs, int row) throws SQLException {
		Soil soil = new Soil();

		soil.setSoilId(rs.getInt("SOIL_ID"));
		soil.setSoilName(rs.getString("SOIL_NAME"));
		return soil;

	}

}
