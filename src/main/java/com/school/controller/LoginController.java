package com.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@GetMapping(value="/login")
	public ModelAndView loginPage(ModelAndView md) {
		md.setViewName("login");
		return md;
	}
	
	@GetMapping(value="/main")
	public ModelAndView welcomePage(ModelAndView md) {
		md.setViewName("home");
		return md;
	}
	/*
	@RequestMapping(value = { "/homePage"}, method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("homePage");
		return model;
	}
	
	@RequestMapping(value = {"/userPage"}, method = RequestMethod.GET)
	public ModelAndView userPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("userPage");
		return model;
	}
	
	@RequestMapping(value = {"/adminPage"}, method = RequestMethod.GET)
	public ModelAndView adminPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("adminPage");
		return model;
	}
	*/
	@GetMapping(value="/login1")
	public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
	@RequestParam(value = "logout",	required = false) String logout) {
		
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid Credentials provided.");
		}

		if (logout != null) {
		    model.addObject("message", "Logged out from JournalDEV successfully.");
		}
       // model.addObject("", model);
		model.setViewName("loginPage");
		return model;
	}
}
