package ru.milkparts.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.milkparts.web.models.User;
import ru.milkparts.web.services.UserService;
import ru.milkparts.web.services.impl.EmailVerificationServiceImpl;

import java.util.Base64;

@Controller
public class EmailVerificationController {
    @Autowired
    private EmailVerificationServiceImpl verificationService;
    @Autowired
    private UserService userService;
    @GetMapping("/verify/email")
    public String verifyEmail(@RequestParam final String id) {
        byte[] actualId = Base64.getDecoder().decode(id.getBytes());
        String username = verificationService.getUsernameForVerificationId(new String(actualId));
        if(username != null) {
            User user = userService.verifyUser(username);

            return "redirect:/login?verified";
        }
        return "redirect:/login?error";
    }
}
