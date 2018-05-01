package com.company.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.dao.interfaces.DAO;
import com.company.models.Location;
import com.company.models.Region;
import com.company.models.Seed;
import com.company.models.Soil;
import com.company.rowmappers.LocationMapper;
import com.company.rowmappers.RegionRowMapper;
import com.company.rowmappers.SeedRowMapper;
import com.company.rowmappers.SoilMapper;

@Repository
public class DAOImpl implements DAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Region> getRegions() {
		String sql = "SELECT REGION_ID, REGION_NAME FROM REGION";
		return jdbcTemplate.query(sql, new RegionRowMapper());
	}

	@Override
	public List<Soil> getSoils() {
		String soilsql = "SELECT SOIL_ID, SOIL_NAME FROM SOIL";
		return jdbcTemplate.query(soilsql, new SoilMapper());
	}

	@Override
	public List<Seed> getSeeds() {
		String seedsql = "SELECT SEED_ID, SEED_NAME FROM SEED";
		return jdbcTemplate.query(seedsql, new SeedRowMapper());
	}

	@Override
	public String findSeed(String region, String soil, int moisture) {
		String sql = "SELECT SEED_NAME FROM SEED WHERE SEED_ID = (SELECT SEED_ID FROM REGION_SOIL_SEED WHERE REGION_SOIL_ID = (SELECT REGION_SOIL_ID FROM REGION_SOIL WHERE REGION_ID = (SELECT REGION_ID FROM REGION WHERE REGION_NAME = ?) AND SOIL_ID = (SELECT SOIL_ID FROM SOIL WHERE SOIL_NAME = ?) AND MOISTURE = ?))";
		try {
			return jdbcTemplate.queryForObject(sql,new Object[] {region, soil, moisture}, String.class);
		} catch (DataAccessException e) {
			return "";
		}
	}

	@Override
	public List<Location> getLocations() {
		String sql = "SELECT REGION_NAME, LAT, LNG FROM REGION";
		return jdbcTemplate.query(sql, new LocationMapper());
	}

}
