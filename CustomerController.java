package com.controller;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class CustomerController {
	@Autowired
	private UserDAO service;
	
	 @RequestMapping(value="/login", method = RequestMethod.GET)
	 public String login() {
	 
	  return "Login1";
	 
	 }
	 
	 @RequestMapping(value="/fail2login", method = RequestMethod.GET)
	 public ModelAndView loginerror(ModelMap model) 
	 {
		 System.out.println("hello yogi...........................................");	 
	
	  return new ModelAndView("Login1","error",true);
	 
	 }
	 @RequestMapping(value="/fail2login1", method = RequestMethod.GET)
	 public ModelAndView loginerror1(ModelMap model) 
	 {
		 System.out.println("hello yogi.............how  are you ?..............................");	 
	
	  return new ModelAndView("Login1","error",true);
	 
	 }
	@RequestMapping(value="/register" ,method=RequestMethod.GET )
	public ModelAndView RegisterPage()
	{
		return new ModelAndView("Register","user",new User());
	}
	@RequestMapping(value="/register" ,method=RequestMethod.POST )
	public String RegisterActionPage(@ModelAttribute("user") @Validated User c, BindingResult result, Model model)
	{
		if (result.hasErrors()) {
			
			return "Register";
		}
		else{
			  service.saveorUpdate(c);
			
			return "Login1";		
		}
		
	}	
	 @RequestMapping(value="/logout", method = RequestMethod.GET)
	 public String logout(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception
	 {
		 /*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 if (auth != null) {
		 new SecurityContextLogoutHandler().logout(request, response, auth);
		 }*/
	 session=request.getSession(true);
	 session.invalidate();
	 response.setHeader("Cache-Control","no-cache"); 
	 response.setHeader("Cache-Control","no-store"); 
	 response.setDateHeader("Expires", 0);
	 return "redirect:/h1";
	  //return new ModelAndView("index");
	 
	 }
	 @RequestMapping(value = "/ret1", method = RequestMethod.GET)
	    public ModelAndView printWelcome(ModelMap model, Principal principal) {
	        return new ModelAndView("retrive1");

	    }
	 


}
