package com.carloso.ai.openaitoolcallback.controller;



import com.carloso.ai.openaitoolcallback.dto.Currencies;
import com.carloso.ai.openaitoolcallback.service.AlphavantageSvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    private final AlphavantageSvc alphavantageSvc;
    
    public HomeController(AlphavantageSvc alphavantageSvc) {
        this.alphavantageSvc = alphavantageSvc;
    }
    
    @GetMapping("/")
    public String home(Model model) {
        Currencies currencies = alphavantageSvc.getCurrencies();
        model.addAttribute("currencies", currencies);

        return "exchanges";
    }
}