package sof3.project.traillog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sof3.project.traillog.domain.User;
import sof3.project.traillog.domain.UserRepository;

@Controller
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //sisäänkirjautuminen
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String login() {
        return "profile"; // profile.html
    }

    // rekisteröi eli lisää uusi käyttäjä
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerUser(Model model) {
        model.addAttribute("user", new User());
        return "register"; // register.html
    }

    // tallenna uusi käyttäjä
    @RequestMapping(value = "/saveuser", method = RequestMethod.POST)
    public String saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        userRepository.save(user);
        return "redirect:/login";
    }

}
