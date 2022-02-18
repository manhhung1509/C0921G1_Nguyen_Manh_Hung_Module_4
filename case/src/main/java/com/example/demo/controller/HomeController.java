package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String getHomePage() {
        return "/home";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login/login";
    }

    @GetMapping("/searchInHome")
    public String searchInHome(@RequestParam String homeSearch) {
        String keySearch = homeSearch.toLowerCase();

        if ("customer".equals(keySearch)){
            return "redirect:/customers";
        }else if ("employee".equals(keySearch)){
            return "redirect:/employees";
        }
        return "redirect:/home";
    }
}