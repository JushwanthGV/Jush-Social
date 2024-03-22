package com.jush.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping
	public String homeControllerHandler() {
		return "this is home controller";
	}
	
	@GetMapping("/home")
	public String homeControllerHandler2() {
		return "this is home controller 2";
	}
	
	@GetMapping("/jushcode")
	public String homeControllerHandler3() {
		return "jush codes here";
	}
}
