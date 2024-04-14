package sof3.project.traillog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sof3.project.traillog.domain.Destination;
import sof3.project.traillog.domain.DestinationRepository;
import sof3.project.traillog.domain.User;
import sof3.project.traillog.domain.UserRepository;

@SpringBootApplication
public class TraillogApplication implements CommandLineRunner {

	public static final Logger log = LoggerFactory.getLogger(TraillogApplication.class);

	private final DestinationRepository destinationRepository;
	private final UserRepository userRepository;

	public TraillogApplication(DestinationRepository destinationRepository, UserRepository userRepository) {
		this.destinationRepository = destinationRepository;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(TraillogApplication.class, args);
		log.info("Sovellus käynnistetty.");
	}

	@Override
	public void run(String... args) throws Exception {

    log.info("Lisätään käyttäjiä tietokantaan");
    //Username: user, password: user
    User user = userRepository.save(new User("user", "$2a$10$3Eh3B/tjJKqw4DTcK3Z60.um7/X.XAWXrTjvqaXFd7d8lKI0vTGhq", "USER"));
    //Username: admin, password: admin
    User admin = userRepository.save(new User("admin", "$2a$10$iLDK8wfiXUmiCVjtgjtusOz4EMhOritRyFIpnvlsKWAx3rSNAXvBq", "ADMIN"));
	//Username: nomad92, password nomad92
	User nomad92 = userRepository.save(new User("nomad92", "$2a$10$YWGMiJPw7Yicwf2RGXXbIO6qFsQb3HU9XtLVVHcchz5X11iGXHWs.", "USER"));
	//Username: seikkailija, password seikkailija
	User seikkailija = userRepository.save(new User("seikkailija", "$2a$10$ggbGXyoWETAIk/pb09qBWePWGvLLyiBnfmTs/xJ7WWPt6Q8NcGvdu", "USER"));
	//Username: mirkku1965, password mirkku1965
	User mirkku1965 = userRepository.save(new User("mirkku1965", "$2a$10$KI8IEdONoU0PVZCRzni6FOoRbDDnVcgDRtYJTQDl1PeKLUsJiLVuO", "USER"));

    log.info("Lisätään kohteita tietokantaan");
    Destination japani = destinationRepository.save(new Destination("Japani", "Temppeleitä, kirsikankukkia, sushia", 4.7));
    Destination australia = destinationRepository.save(new Destination("Australia", "Rantoja, kenguruja, aavikkoa", 4.2));
	Destination uusiseelanti = destinationRepository.save(new Destination("Uusi-Seelanti", "Vuoria, järviä, lampaita", 4.5));
	Destination ranska = destinationRepository.save(new Destination("Ranska", "Patonkia, juustoa, viiniä", 3.9));
	Destination italia = destinationRepository.save(new Destination("Italia", "Rantaa, vuoristoa, historiaa", 4.8));
	Destination marokko = destinationRepository.save(new Destination("Marokko", "Aavikkoa, rantaa, vuoristoa", 4.2));

    // Lisää kohteita käyttäjille
    user.getDestinations().add(japani);
    admin.getDestinations().add(australia);
	user.getDestinations().add(ranska);
    admin.getDestinations().add(italia);
	nomad92.getDestinations().add(japani);
    seikkailija.getDestinations().add(uusiseelanti);
	mirkku1965.getDestinations().add(japani);
    admin.getDestinations().add(marokko);

    // Tallenna käyttäjät uudelleen, jotta kohteiden muutokset tallentuvat tietokantaan
    userRepository.save(user);
    userRepository.save(admin);
	userRepository.save(nomad92);
	userRepository.save(seikkailija);
	userRepository.save(mirkku1965);

    log.info("Haetaan kaikki kohteet");
    for (Destination destination : destinationRepository.findAll()) {
        log.info("destination: {destination}, description: {description}", destination.getDestName(),
                destination.getDestDescription());
    }

 /*    log.info("Haetaan kaikki käyttäjät");
    for (User user : userRepository.findAll()) {
        log.info("user: {user}", user.getUsername());
    } */

	}

}
