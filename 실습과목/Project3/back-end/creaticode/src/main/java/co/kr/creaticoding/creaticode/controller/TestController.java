package co.kr.creaticoding.creaticode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.kr.creaticoding.creaticode.mapper.UserMapper;

// @Controller
@RestController
public class TestController {

	@Autowired
	private UserMapper userMapper;

	// @ResponseBody
	@RequestMapping("/")
	public String test() {
		return "Hello World! Spring Project";
	}

	// @ResponseBody
	@RequestMapping("/user/count")
	public String userCount() throws Exception {
		return userMapper.count().toString();
	}
}
