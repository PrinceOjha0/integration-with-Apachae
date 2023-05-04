package com.credex.CredCoin.Controller;
import java.util.Objects;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.credex.CredCoin.Response.Response;
import com.credex.CredCoin.Service.ServiceLayer;
import com.fasterxml.jackson.databind.util.JSONPObject;

import ch.qos.logback.classic.Logger;
import jakarta.servlet.http.HttpServletRequest;

@org.springframework.stereotype.Controller
public class Dashboardcontroller {
	@Autowired
	private ServiceLayer services;

	@PostMapping("/dashboard")
	public String doLogin(HttpServletRequest request, @RequestParam String username, @RequestParam String password,
			Model model) throws Exception {

		System.out.println(username);
		System.out.println(password);
		
		JSONObject productJson = services.loginapi(username, password);
		if (!Objects.isNull(productJson)) {
		
			Response user = new Gson().fromJson(productJson.toString(), Response.class);
			System.out.println(user);
			String admin = "admin";
			String comp = user.getUsername();
			System.out.println(comp);
			System.out.println(user.getUsername());
			 if (comp.equals(admin)) {
			        return "adminforntend";
			    }
			 if (comp.equals("verdi")) {
			        return "subadmin";
			    }
			 if (comp.equals("puccini")) {
				 return "customer";
			    }
			 if (comp.equals("rossini")) {
			        return "enduser";
			    }
			
		}
		return "Login";
		
	}
	
	@GetMapping("/Logout")
	public String logout() {
		return "Login";
	}
}
