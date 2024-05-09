package ru.gb.controllers;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;
import ru.gb.dto.SignUpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.gb.services.AuthenticationService;
import ru.gb.services.UserService;

/**
 * Страница регистрации
 */
@RestController
@AllArgsConstructor
@RequestMapping()
public class RegistrationController {

    private AuthenticationService authenticationService;

    @GetMapping("/registration")
    public ModelAndView registration()
    {
        return new ModelAndView("registration");
    }

    @PostMapping("/registration")
    public ModelAndView addUser(String name, String password)
    {
        SignUpRequest signUpRequest = new SignUpRequest(name, password);
        authenticationService.signUp(signUpRequest);
        return new ModelAndView("redirect:/login");

    }

/*    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/login")
    public String login(String name, String password) {
        return "redirect:/notes";
    }*/

}
