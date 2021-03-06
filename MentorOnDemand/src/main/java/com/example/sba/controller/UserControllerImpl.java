package com.example.sba.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.sba.model.User;
import com.example.sba.model.UserLogin;
import com.example.sba.service.UserService;
import com.example.sba.service.UserServiceImpl;



@Controller
public class UserControllerImpl {
	
	@Autowired 
	private UserService userService=new UserServiceImpl();

	@RequestMapping(value = "/userLogin", method = RequestMethod.GET)
	public String userLogin(ModelMap model) throws SQLException {
		UserLogin userlogin=new UserLogin();
		model.addAttribute("ul",userlogin);
		return "userLogin";

	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST) 
	public String loginUser(@Valid UserLogin userlogin, BindingResult result, Model model, HttpSession session) throws SQLException { 
		System.out.println("inside post method"); 
		System.out.println("password"+userlogin.getPassword());
		User user=userService.loginUser(userlogin);
		System.out.println("++++++++++++++++++++"+user);
		if(user!=null && user.getPassword().equals(userlogin.getPassword())) {	
			session.setAttribute("user", user);
			return	"userDetails";
		}
		else 
			return "redirect:/userLogin"; 

	}
	
	@RequestMapping(value = "/userRegister", method = RequestMethod.GET)
	public String userRegistration(ModelMap model) throws SQLException {
		User user=new User();
		model.addAttribute("ul",user);
		return "userRegistration";

	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST) 
	public String registerUser(@Valid User user, BindingResult result, Model model, HttpSession session) throws SQLException { 
		System.out.println("inside post method"); 
		if(userService.registerUser(user))
			return "redirect:/userLogin";
		else
			return "redirect:/userRegister";

	}
	
	
}
