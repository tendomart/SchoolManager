package com.school.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.school.model.Pay;

@Controller
@RequestMapping("main")
public class HomeController {
	//@GetMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	@GetMapping(value={"/" })
    public String homePage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "home";
    }
 
    //@RequestMapping(value = "/admin", method = RequestMethod.GET)
    @GetMapping(value= "/accounts")
	public ModelAndView getForm(ModelAndView md) {
    	// md.addObject("pay",new Pay());
			md.setViewName("schoolAccounts");
			return md; 
			}
     
    @GetMapping(value= "/db")
   // @RequestMapping(value = "/db", method = RequestMethod.GET)
    public String dbaPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "dba";
    }
 
    @GetMapping(value= "/Access_Denied")
    //@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }
 
    @GetMapping(value= "/login")
  //  @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(ModelMap model) {
    	 model.addAttribute("user", getPrincipal());
        return "login";
    }
 
    @GetMapping(value= "/logout")
    //@RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
 
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
 

}
