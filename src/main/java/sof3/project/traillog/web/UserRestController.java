package sof3.project.traillog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import sof3.project.traillog.domain.User;
import sof3.project.traillog.domain.UserRepository;

@RestController
public class UserRestController {

    @Autowired
    private final UserRepository userRepository;

    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

     @GetMapping("/users")
    public Iterable<User> getUsers() {
        // fetch + return destination
        return userRepository.findAll();
    }

}
