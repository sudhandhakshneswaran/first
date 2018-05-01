package com.company.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.company.models.Region;

public class RegionRowMapper implements RowMapper<Region>{

	@Override
	public Region mapRow(ResultSet rs, int row) throws SQLException {
		Region region = new Region();
		region.setRegionId(rs.getInt("REGION_ID"));
		region.setRegionName(rs.getString("REGION_NAME"));
		
		return region;
	}

	
}
