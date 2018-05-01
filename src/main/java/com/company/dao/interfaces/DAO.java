package com.company.dao.interfaces;

import java.util.List;

import com.company.models.Location;
import com.company.models.Region;
import com.company.models.Seed;
import com.company.models.Soil;

public interface DAO {

	List<Region> getRegions();
	List<Soil> getSoils();
	List<Seed> getSeeds();
	String findSeed(String region, String soil, int moisture);
	List<Location> getLocations();
}
