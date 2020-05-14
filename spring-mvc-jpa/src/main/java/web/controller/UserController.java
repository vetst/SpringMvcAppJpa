package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("main")
    public String get(Model model) {
        model.addAttribute("userList", service.getAllUser());
        return "main";
    }

    @PostMapping("main")
    public String add(User user) {
        service.addUser(user);
        return "redirect:/main";
    }

    @PostMapping("delete")
    public String delete(User user) {
        service.deleteUser(user.getId());
        return "redirect:/main";
    }

    @GetMapping("update")
    public String getUpdatePage(ModelMap model, User user) {
        model.addAttribute("id", user.getId())
                .addAttribute("name", user.getName())
                .addAttribute("surName", user.getSurName());
        return "update-user";
    }

    @PostMapping("update")
    public String update(User user) {
        service.updateUser(user.getId(), user.getName(), user.getSurName());
        return "redirect:/main";
    }
}


