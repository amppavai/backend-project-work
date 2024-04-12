package sof3.project.traillog.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface UserRepository extends CrudRepository<User, Long>{

    //hae käyttäjä
    List<User> findByUsername(String username);



}
