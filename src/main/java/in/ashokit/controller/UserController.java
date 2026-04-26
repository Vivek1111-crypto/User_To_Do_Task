package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import in.ashokit.Entity.User;
import in.ashokit.service.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // 🔹 Show Register Page
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    // 🔹 Handle Register
    @PostMapping("/register")
    public String register(User user, Model model) {

        boolean status = userService.register(user);

        if (status) {
            return "login";
        } else {
            model.addAttribute("msg", "Email Already Exists");
            return "register";
        }
    }

    // 🔹 Show Login Page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // 🔹 Handle Login
    @PostMapping("/login")
    public String login(String email, String password, HttpSession session, Model model) {

        User user = userService.login(email, password);

        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/dashboard";
        }

        model.addAttribute("msg", "Invalid Credentials");
        return "login";
    }

    // 🔹 Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }
}