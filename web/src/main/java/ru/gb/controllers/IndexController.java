package ru.gb.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Главная страница
 */
@Controller
public class IndexController
{
    @GetMapping("/")
    public String index(Principal principal)
    {
        if(principal != null)
        {
            return "redirect:/notes";
        }
        return "index";
    }
}