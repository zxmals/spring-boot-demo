package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {
	
	@RequestMapping(value = "/hello",method = RequestMethod.GET)
	public String hellosp() {
		return "Hello Springboot!";
	}
}
