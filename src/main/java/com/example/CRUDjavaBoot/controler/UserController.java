package com.example.CRUDjavaBoot.controler;

import com.example.CRUDjavaBoot.model.User;
import com.example.CRUDjavaBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

private final UserService userService;

@Autowired
public UserController(UserService userService) {
    this.userService = userService;
}


@GetMapping(value = "/")
public String showAllUsers(ModelMap model) {
    List<User> list = userService.getUsers();
    model.addAttribute("listUsers", list);
    return "pages/index";
}

@GetMapping(value = "/show_user")
public String showSingleUser (@RequestParam(value = "id") Long id, Model model) {
    model.addAttribute("user", userService.getUserById(id));
    return "pages/show_user";
}

@GetMapping("/add_user")
public String addUser(Model model){
    model.addAttribute("user", new User());
    return "pages/add_user";
}

@PostMapping("/create_new_user")
public String createNewUser(@ModelAttribute("user") User user){
    userService.addUser(user);
    return "redirect:/";
}

@GetMapping("/edit_user")
public String edit(@RequestParam(value = "id") Long id, Model model) {
    model.addAttribute("user", userService.getUserById(id));
    return "pages/edit_user";
}
@PostMapping("/save_edit_user")
public String updateUser(@ModelAttribute("user") User user) {
    userService.update(user);
    return "redirect:/";
}

@GetMapping(value = "/delete_user")
public String deleteUser (@RequestParam(value = "id") Long id, Model model) {
    userService.delete(id);
    return "redirect:/";
}

}