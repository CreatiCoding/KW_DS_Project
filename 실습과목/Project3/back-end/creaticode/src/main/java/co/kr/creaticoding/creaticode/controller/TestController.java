package co.kr.creaticoding.creaticode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller
@RestController
public class TestController {
	
	// @ResponseBody
	@RequestMapping("/")
	public String test() {
		return "Spring Boot Test";
	}
}
