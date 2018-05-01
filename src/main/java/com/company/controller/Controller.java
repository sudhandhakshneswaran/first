package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.company.dao.interfaces.DAO;
import com.company.models.Location;
import com.company.models.Region;
import com.company.models.Seed;
import com.company.models.Soil;

@RestController
public class Controller {

	@Autowired
	DAO dao;

	@GetMapping("/regions")
	public List<Region> getRegions() {
		return dao.getRegions();
	}

	@GetMapping("/soils")
	public List<Soil> getSoils() {
		return dao.getSoils();
	}
	
	@GetMapping("/seeds")
	public List<Seed> getSeeds(){
		return dao.getSeeds();
	}
	
	@GetMapping("/findSeed/{region}/{soil}/{moisture}")
	public String findSeed(@PathVariable String region, @PathVariable String soil, @PathVariable int moisture) {
		return dao.findSeed(region,soil,moisture);
		
	}
	
	@GetMapping("/loc")
	public List<Location> getLocations() {
		return dao.getLocations();
	}
}
