package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Area;

public interface AreaDao {
	List<Area> QueryArea();
	Area queryAreaById(int areaId);
	int insertArea(Area area);
	int updateArea(Area area);
	int deleteArea(int areaId);
}
