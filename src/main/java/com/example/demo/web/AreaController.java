package com.example.demo.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Area;
import com.example.demo.service.AreaService;



@RestController
@RequestMapping("/superadmin")
public class AreaController {
	@Autowired
	private AreaService areaService;
	
	@RequestMapping(value = "/listarea",method = RequestMethod.GET)
	private Map<String, Object> listArea(){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Area> list = areaService.getAreaList();
		modelMap.put("areaList", list);
		return modelMap;
	}
	
	@RequestMapping(value = "/getareabyid", method = RequestMethod.GET)
	private Map<String, Object> getAreaById(Integer area_id){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Area area = areaService.getAreaById(area_id);
		modelMap.put("area",area);
		return modelMap;
	}
	
	@RequestMapping(value = "/addarea", method = RequestMethod.POST)
	private Map<String, Object> addArea(@RequestBody Area area){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("successs",areaService.addArea(area));
		return modelMap;
	}
	
	@RequestMapping(value = "/modifyarea", method = RequestMethod.POST)
	private Map<String, Object> modifyArea(@RequestBody Area area){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("successs",areaService.modifyArea(area));
		return modelMap;
	}
	
	@RequestMapping(value = "/removearea", method = RequestMethod.GET)
	private Map<String, Object> removeArea(Integer area_id){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("successs",areaService.deleteArea(area_id));
		return modelMap;
	}
}
