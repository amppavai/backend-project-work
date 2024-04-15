package sof3.project.traillog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sof3.project.traillog.domain.Destination;
import sof3.project.traillog.domain.DestinationRepository;

@Controller
public class DestinationController {

    @Autowired
    private DestinationRepository destinationRepository;

    // etusivu index.html
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getIndex() {
        return "index.html";
    }

    // kohteiden listaus
    @RequestMapping(value = "/destinations", method = RequestMethod.GET)
    public String getDestinations(Model model) {
        model.addAttribute("destinations", destinationRepository.findAll());
        return "destinations";
    }

    // uuden matkakohteen lisäys
    @RequestMapping(value = "/adddest", method = RequestMethod.GET)
    public String addDestination(Model model) {
        model.addAttribute("destination", new Destination());
        return "adddest"; // adddest.html
    }

    // tallenna uusi matkakohde
    @RequestMapping(value = "/savedestination", method = RequestMethod.POST)
    public String saveDestination(Destination destination) {
        destinationRepository.save(destination);
        return "redirect:/profile";
    }

    // kohteen poistaminen listasta
    @RequestMapping(value = "/delete/{destid}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteDestination(@PathVariable("destid") Long destid, Model model) {
        destinationRepository.deleteById(destid);
        return "redirect:../destinations";
    }
}
