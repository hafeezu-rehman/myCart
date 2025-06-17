package com.mycart.store.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mycart.store.model.User;
import com.mycart.store.service.UserService;

@RestController
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/register")
    public String registerForm(){
        return "register";
    }
    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model){
        try {
            userService.createUser(user);
            model.addAttribute("message", "Registration successful! Please login");
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "register";
        }
        
    }
}
