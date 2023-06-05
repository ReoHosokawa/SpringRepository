package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.MasterUser;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping
	public String login(@ModelAttribute("masterUser") MasterUser masterUser, Model model) {
		return "login";
	}
	
	@PostMapping
	public String doLogin(@ModelAttribute("masterUser") @Validated MasterUser masterUser, BindingResult result, Model model) {
		boolean isError = false;
		
		if (result.hasErrors()) {
			isError = true;
		}
		
		if (isError) {
			return "login";
		}
		
		return "redirect:/items";
	}
}
