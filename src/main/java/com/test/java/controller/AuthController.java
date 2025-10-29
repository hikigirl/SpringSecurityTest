package com.test.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
	@GetMapping("/accesserror.do")
	public String accesserror() {
		return "auth/accesserror";
	}
	@GetMapping("/customlogin.do")
	public String customlogin() {
		return "auth/customlogin";
	}
	@GetMapping("/customlogout.do")
	public String customlogout() {
		return "auth/customlogout";
	}
}
