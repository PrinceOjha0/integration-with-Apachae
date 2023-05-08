package com.credex.CredCoin.Controller;

import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.credex.CredCoin.Service.ServiceLayer;
import com.fasterxml.jackson.databind.util.JSONPObject;

import ch.qos.logback.classic.Logger;
import jakarta.servlet.http.HttpServletRequest;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	private ServiceLayer services;

	@GetMapping("/")
public String hello() {
	return "Login";
}
	@GetMapping("/user")
	public String user() {
		return "adminforntend";
	}
	
	
}
