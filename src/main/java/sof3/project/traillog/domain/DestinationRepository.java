package sof3.project.traillog.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface DestinationRepository extends CrudRepository<Destination, Long>{
    //hae kohteen nimellä
    List<Destination> findByDestName(String destName);
    //hae kohteen arviolla/tähtiluokituksella
    List<Destination> findByDestRating(Double destRating);
    List<Destination> findAll();

}
