package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Area;

public interface AreaService {

	List<Area> getAreaList();
	
	Area getAreaById(int area_id);
	
	boolean addArea(Area area);
	
	boolean modifyArea(Area area);
	
	boolean deleteArea(int area_id);
}
