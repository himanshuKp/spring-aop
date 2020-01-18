package com.himanshu.springdemo.restService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloWorldService {

//	add mapping support for helloworld
	@GetMapping("/hello")
	public String helloString() {
		return "Hello World!";
	}
}
