package sof3.project.traillog.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;


public interface UserRepository extends CrudRepository<User, Long>{

    //hae käyttäjä
    Optional<User> findByUsername(String username);



}
