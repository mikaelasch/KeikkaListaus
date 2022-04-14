package hh.swd20.KeikkaListaus;

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


@SpringBootApplication
public class KeikkaListausApplication {

	private static final Logger log = LoggerFactory.getLogger(KeikkaListausApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(KeikkaListausApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(KeikkaRepository kRepository, ArtistiRepository aRepository, KategoriaRepository kaRepository) {
		return (args) -> {
			log.info("lisää muutama keikka");
			Keikka keikka1 = new Keikka("Dannyn Juhlapäivä", "28.5.2022",75.00,"Kaisaniemenpuisto");
			
			kRepository.save(keikka1);
			
			Artisti artisti1 = new Artisti("Danny");
			aRepository.save(artisti1);
			
			Kategoria kate1 = new Kategoria("Festarit","Indie-rock");
			kaRepository.save(kate1);
			log.info("hae kaikki keikat");
			for (Keikka keikka : kRepository.findAll()) {
				log.info(keikka.toString());
			}
		};
		} 

}