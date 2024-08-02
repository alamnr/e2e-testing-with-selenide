package com.e2e.selenide.e2e_testing_with_selenide;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookStoreController {

    @GetMapping("/book-store")
    public String getIndexPage(Model model){
        model.addAttribute("message", "E2E test with selenide");
        return "index";
    }


    
}
