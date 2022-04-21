package hh.swd20.KeikkaListaus;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import hh.swd20.KeikkaListaus.domain.Artisti;
import hh.swd20.KeikkaListaus.domain.ArtistiRepository;
import hh.swd20.KeikkaListaus.domain.Kategoria;
import hh.swd20.KeikkaListaus.domain.KategoriaRepository;
import hh.swd20.KeikkaListaus.domain.Keikka;
import hh.swd20.KeikkaListaus.domain.KeikkaRepository;
import hh.swd20.KeikkaListaus.domain.User;
import hh.swd20.KeikkaListaus.domain.UserRepository;


@SpringBootApplication
public class KeikkaListausApplication {

	private static final Logger log = LoggerFactory.getLogger(KeikkaListausApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(KeikkaListausApplication.class, args);
	}
	

	
	
	@Bean
	public CommandLineRunner demo(KeikkaRepository kRepository, ArtistiRepository aRepository, KategoriaRepository kaRepository, UserRepository uRepository) {
		return (args) -> {
			log.info("lisää muutama keikka");
			
			
			
			Kategoria kate1 = new Kategoria("Festarit","Indie-rock",null);
			kaRepository.save(kate1);
			Kategoria kate2 = new Kategoria("Festarit", "Rock-pop", null);
			kaRepository.save(kate2);
			Kategoria kate3 = new Kategoria("Festarit","Indie-pop-rock", null);
			kaRepository.save(kate3);
			Kategoria kate4 = new Kategoria("Keikka","Indie-pop",null);
			kaRepository.save(kate4);
			
			Artisti artisti1 = new Artisti("First aid Kit",null) ;
			//aRepository.save(artisti1);
			
			Artisti artisti2 = new Artisti("Litku-Klemetti",null);
			Artisti artisti3 = new Artisti("Teksti-TV666",null);
			List<Artisti> keikan1Artistit = new ArrayList<Artisti>();
			keikan1Artistit.add(artisti1);
			keikan1Artistit.add(artisti2);
			keikan1Artistit.add(artisti3);
			
			Artisti artisti4 = new Artisti("Gorillaz",null);
			Artisti artisti5 = new Artisti("Antti Autio",null);
			List<Artisti>keikan2artistit = new ArrayList<Artisti>();
			keikan2artistit.add(artisti5);
			keikan2artistit.add(artisti4);
			Artisti artisti6 = new Artisti("Vialea",null);
			Artisti artisti7 = new Artisti("JVG",null);
			aRepository.save(artisti7);
			List<Artisti>keikan3artistit = new ArrayList<Artisti>();
			keikan2artistit.add(artisti6);
			
			
			Keikka keikka1 = new Keikka("Kesärauha", "10-12.6.2022",129.00,"Kaisaniemenpuisto",keikan2artistit,kate1);
			kRepository.save(keikka1);
			Keikka keikka2 = new Keikka("Flow Festival", "12-14.8.2022", 225.00, "Suvilahti",keikan1Artistit,kate2);
			kRepository.save(keikka2);
			Keikka keikka3 = new Keikka("Downtown calling", "15-16.7.2022", 85.00, "Vanhankaupunginkoski",keikan3artistit, kate3);
			kRepository.save(keikka3);
			Keikka keikka4 = new Keikka("Vialea", "14.5.2022", 10.00, "Bar Base", keikan3artistit, kate4);
			kRepository.save(keikka4);
			
			User user1 = new User("user", "$2a$10$kVRZJPFQAFLsrzcIfGUjd.SOLDiZFYf7z4aTZkC10/dsmei./HvjG", "user@gmail.com", "USER");
			 User user2 = new User("admin", "$2a$10$ZEHllgOjoQCMhqLJvMyGg.tuRawl/AgKhCHaq8xs5EUUSkIGUt.P2", "admin@gmail.com", "ADMIN");
			 uRepository.save(user1);
			 uRepository.save(user2);
			
			
			log.info("hae kaikki keikat");
			for (Keikka keikka : kRepository.findAll()) {
				log.info(keikka.toString());
			}
		};
		} 

}
