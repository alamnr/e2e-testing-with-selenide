package com.e2e.selenide.e2e_testing_with_selenide;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SeleniumIndexController {

    @GetMapping("/seleniumIndex")
    public String getSeleniumIndexPage(Model model) {
      model.addAttribute("message", "Integration Test with Selenium");
      return "seleniumIndex";
    }

}