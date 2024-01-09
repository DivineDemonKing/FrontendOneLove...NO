package ru.kata.spring.boot_security.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	UserDetailsService userDetailsService;

	@GetMapping(value ="/")
	public String index(ModelMap model) {
		return "index";
	}

	@GetMapping(value = "/user")
	public String userInfo(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		model.addAttribute(user);
		return "user";
	}
}