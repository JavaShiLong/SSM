package com.shilong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class I18nController {

	
	@RequestMapping("/hello")
	public String suTest(){
		
		return "../../hello";
	}
}
