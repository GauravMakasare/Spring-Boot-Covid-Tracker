package covidtracker.io.Coronavirus1.controller;

import covidtracker.io.Coronavirus1.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //this makes the class as a spring controller
public class HomeController {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("locationStats", coronaVirusDataService.getAllStats());
        return"home";  //used to render ui pages
    }

}
