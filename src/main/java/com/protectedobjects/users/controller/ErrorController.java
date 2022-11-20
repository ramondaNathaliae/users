package com.protectedobjects.users.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/error")
public class ErrorController {

    @GetMapping
    ModelAndView getAllCountriesView() {
        ModelAndView view = new ModelAndView("error");
        return view;
    }
}
