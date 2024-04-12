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
		;
	}

	public static void main(String[] args) {
		SpringApplication.run(TraillogApplication.class, args);
		log.info("Sovellus käynnistetty.");
	}

	@Override
	public void run(String... args) throws Exception {

		log.info("Lisätään kohteita tietokantaan");
		Destination suomi = destinationRepository
				.save(new Destination("Suomi", "Metsää, järvimaisemia, tuntureita", 3.5));
		Destination marokko = destinationRepository.save(new Destination("Marokko", "Aavikkoa, rantaa, vuoristoa", 4.2));
		Destination italia = destinationRepository.save(new Destination("Italia", "Rantaa, vuoristoa, historiaa", 4.8));
		Destination ranska = destinationRepository.save(new Destination("Ranska", "Patonkia, juustoa, viiniä", 3.9));

		log.info("Haetaan kaikki kohteet");
		for (Destination destination : destinationRepository.findAll()) {
			log.info("destination: {destination}, description: {description}", destination.getDestName(),
					destination.getDestDescription());
		}

		log.info("Lisätään käyttäjiä tietokantaan");
		User nomad92 = userRepository.save(new User("nomad92"));
		User seikkailija = userRepository.save(new User("seikkailija"));
		User mirkku1965 = userRepository.save(new User("mirkku1965"));

		log.info("Haetaan kaikki käyttäjät");
		for (User user : userRepository.findAll()) {
			log.info("user: {user}", user.getUsername());
		}

		log.info("Lisätään käyttäjille kohteita");
		nomad92.getDestinations().add(suomi);
		seikkailija.getDestinations().add(marokko);
		mirkku1965.getDestinations().add(italia);
		mirkku1965.getDestinations().add(ranska);

		userRepository.save(nomad92);
		userRepository.save(seikkailija);
		userRepository.save(mirkku1965);

	}

}
