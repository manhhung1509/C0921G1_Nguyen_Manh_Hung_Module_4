package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

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

        if ("customer".equals(keySearch) || "customers".equals(keySearch)){
            return "redirect:/customer/customers";
        }else if ("employee".equals(keySearch) || "employees".equals(keySearch)){
            return "redirect:/employee/employees";
        }else if ("service".equals(keySearch) || "services".equals(keySearch)){
            return "redirect:service/services";
        }
        return "redirect:/home";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            return "error_403";
        }
        return null;
    }
}
