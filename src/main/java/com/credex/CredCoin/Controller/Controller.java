package com.credex.CredCoin.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
	@GetMapping("/")
public String hello() {
	return "Login";
}
	@GetMapping("/user")
	public String user() {
		return "enduser";
	}
}
