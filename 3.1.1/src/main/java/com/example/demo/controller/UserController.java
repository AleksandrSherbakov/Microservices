package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/")
public class UserController {
    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("user", userDao.getAllUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User person) {
        return "add";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userDao.addUser(user);
        return "redirect:/";
        //return "users";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userDao.getUserById(id));
        return "update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        //user.setId(id);
        userDao.updateUser(user);
        return "redirect:/";
        //return "users";

    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        userDao.deleteUser(id);
        return "redirect:/";
    }

}
