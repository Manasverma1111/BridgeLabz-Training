package com.example.greetings;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    // GET / -> shows the form where the user types their name
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // GET /greeting?name=... -> builds the greeting and shows the result page
    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Model model) {

        model.addAttribute("name", name);
        return "greeting";
    }
}
