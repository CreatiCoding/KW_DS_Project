package co.kr.creaticoding.creaticode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.kr.creaticoding.creaticode.vo.ProblemVO;

@Controller
public class ApiController {
	@RequestMapping(value = "/problem/write", method = RequestMethod.POST)
	public String writeProblem(@ModelAttribute ProblemVO problem) throws Exception {
		System.out.println(problem.getProblem_title());
		return "googleLogin";
	}
}
