package zyy.campuscommunity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
		
	@RequestMapping("/")
	public String goLogin() {
		return "login";
	}


	@RequestMapping("*")
	public String hasErorr(){
		System.out.println("has error!");
		return "error";
	}
}
