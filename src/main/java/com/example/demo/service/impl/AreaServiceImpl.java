package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.AreaDao;
import com.example.demo.entity.Area;
import com.example.demo.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService{

	@Autowired
	private AreaDao areaDao;
	
	@Override
	public List<Area> getAreaList() {
		// TODO Auto-generated method stub
		return areaDao.QueryArea();
	}

	@Override
	public Area getAreaById(int area_id) {
		// TODO Auto-generated method stub
		return areaDao.queryAreaById(area_id);
	}

	@Transactional
	@Override
	public boolean addArea(Area area) {
		// TODO Auto-generated method stub
		if(area.getArea_name()!=null && "".equals(area.getArea_name())) {
			area.setCreate_time(new Date());
			area.setLast_edit_time(new Date());
			try {
				int effectedNum = areaDao.insertArea(area);
				if(effectedNum>0)
					return true;
				else 
					throw new RuntimeException("插入失败！");
			}catch (Exception e) {
				throw new RuntimeException("插入失败："+e.getMessage());
			}
		}else {
			throw new RuntimeException("插入信息不能为空！");
		}
	}

	@Override
	public boolean modifyArea(Area area) {
		// TODO Auto-generated method stub
		if(area.getArea_id()!=null && "".equals(area.getArea_id())) {

			area.setLast_edit_time(new Date());
			try {
				int effectedNum = areaDao.updateArea(area);
				if(effectedNum>0)
					return true;
				else 
					throw new RuntimeException("更新失败！");
			}catch (Exception e) {
				throw new RuntimeException("更新失败："+e.getMessage());
			}
		}else {
			throw new RuntimeException("更新信息不能为空！");
		}		
	}

	@Override
	public boolean deleteArea(int area_id) {
		// TODO Auto-generated method stub
		if(area_id>0) {

			try {
				int effectedNum = areaDao.deleteArea(area_id);
				if(effectedNum>0)
					return true;
				else 
					throw new RuntimeException("删除失败！");
			}catch (Exception e) {
				throw new RuntimeException("删除失败："+e.getMessage());
			}
		}else {
			throw new RuntimeException("删除ID不能为空！");
		}
	}

}
