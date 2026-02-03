package se.iths.fabian.labb2enhetstestning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.iths.fabian.labb2enhetstestning.service.ATMService;

@RequestMapping("/balance")
@Controller
public class PlaywrightController {

    private final ATMService atmService;

    public PlaywrightController(ATMService atmService) {
        this.atmService = atmService;
    }

    @GetMapping
    public String getBalance(Model model) {
        model.addAttribute("balance", atmService.performGetBalance());
        return "balance";
    }
}
