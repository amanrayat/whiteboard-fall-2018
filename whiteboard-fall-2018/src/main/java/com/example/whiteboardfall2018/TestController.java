package com.example.whiteboardfall2018;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/")
	public String abc() {
		return "aman";
	}
	

}
