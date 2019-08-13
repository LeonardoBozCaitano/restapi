package com.login;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "logou";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "deslogou";
    }
}
