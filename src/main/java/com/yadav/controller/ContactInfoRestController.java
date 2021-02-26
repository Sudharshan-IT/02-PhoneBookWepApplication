package com.yadav.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/homeController")
public class ContactInfoRestController {
	@GetMapping(value="/home/{name}/{addr}")
	public String welcome(@PathVariable("name") String name,@PathVariable("addr") String address) {
		return "Welcome To Hyderabad......Mr. "+name +"\tFrom "+address;
	}

}
