package zyy.campuscommunity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

	@RequestMapping("/setting")
	public String goSetting() {
		return "setting";
	}

	@RequestMapping("/timeline")
	public String goTimeLine(){return "timeline";}

	@RequestMapping("/")
	public String goLogin() {
		return "login";
	}


	@RequestMapping("*")
	public String other(){
		System.out.println("has error!");
		return "error";
	}

	@RequestMapping("/Error")
	public String hasErorr(){
		System.out.println("has error!");
		return "error";
	}
}
