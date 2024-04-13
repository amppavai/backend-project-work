package sof3.project.traillog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sof3.project.traillog.domain.DestinationRepository;
//import sof3.project.traillog.domain.UserRepository;

@Controller
public class DestinationController {

    @Autowired
    private DestinationRepository destinationRepository;
/*     @Autowired
    private UserRepository userRepository; */

    // etusivu index.html
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getIndex() {
        return "index.html";
    }

    // kohteiden listaus Explore-buttonista
    @RequestMapping(value = "/destinations", method = RequestMethod.GET)
    public String getDestinations(Model model) {
        model.addAttribute("destinations", destinationRepository.findAll());
        return "destinations";
    }

}
