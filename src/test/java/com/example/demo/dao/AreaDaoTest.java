package com.example.demo.dao;


import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Area;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest extends TestCase {

	@Autowired
	private AreaDao areaDao;
	
	@Test
	public void testQueryArea() {
		List<Area> areaList = areaDao.QueryArea();
		assertEquals(3, areaList.size());
	}

	@Test
	public void testQueryAreaById() {
		Area area = areaDao.queryAreaById(1);
		assertEquals("东苑", area.getArea_name());
	}

	// @Test
	@Ignore
	public void testInertArea() {
		Area area = new Area();
		area.setArea_name("南苑");
		area.setPriority(1);
		int effectednum = areaDao.insertArea(area);
		assertEquals(1, effectednum);
	}

	@Test
	public void testUpdateArea() {
		Area area = new Area();
		area.setArea_name("西苑");
		area.setArea_id(3);
		area.setLast_edit_time(new Date());
		int effectednum = areaDao.updateArea(area);
		assertEquals(1, effectednum);
	}

	@Test
	public void testDeleteArea() {
		int effectednum = areaDao.deleteArea(3);
		assertEquals(1, effectednum);
	}

}
