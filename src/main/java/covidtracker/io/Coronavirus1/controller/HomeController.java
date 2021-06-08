package covidtracker.io.Coronavirus1.controller;

import covidtracker.io.Coronavirus1.models.LocationStats;
import covidtracker.io.Coronavirus1.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller //this makes the class as a spring controller
public class HomeController {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/")
    public String home(Model model){
        List<LocationStats> allStats = coronaVirusDataService.getAllStats();

        //calculating total cases reported until date

        //gets the data and then converts it into a stream and maps it to each integer
        // values of totalCases and then finally sums it up
        int totalReportedCases = allStats.stream().mapToInt(stat-> stat.getLatestTotalCases()).sum();

        int totalNewCases = allStats.stream().mapToInt(stat-> stat.getDiffFromPreviousDay()).sum();

        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalNewCases", totalNewCases);

        return"home";  //used to render ui pages
    }

}
