package com.company.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.company.models.Seed;

public class SeedRowMapper implements RowMapper<Seed> {
	
	@Override
	public Seed mapRow(ResultSet rs, int row) throws SQLException {
		Seed seed = new Seed();
		seed.setSeedId(rs.getInt("SEED_ID"));
		seed.setSeedName(rs.getString("SEED_NAME"));

		return seed;

	}
}
