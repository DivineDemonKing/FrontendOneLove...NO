package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    UserDetailsService userDetailsService;

    @GetMapping(value = "/admin")
    public String printUser(ModelMap model) {
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        return "userList";
    }
    @GetMapping(value = "/addUser")
    public String newUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "addUser";
    }
    @PostMapping(value = "/addUser")
    public String createUser(ModelMap model, @ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/admin";
    }
    @GetMapping(value = "/deleteUser")
    public String getIdToDelete(ModelMap model) {
        model.addAttribute("user", new User());
        return "/deleteUser";
    }
    @PostMapping(value = "/deleteUser")
    public String deleteUser(ModelMap model, @ModelAttribute("user") User user) {
        userService.deleteById(user.getId());
        return "redirect:/admin";
    }

    @GetMapping(value = "/updateUser")
    public String getIdToUpdate(ModelMap model) {
        model.addAttribute("user", new User());
        return "/updateUser";
    }
    @PostMapping(value = "/updateUser")
    public String updateUser(ModelMap model, @ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/admin";
    }
}
