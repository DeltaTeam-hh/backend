
package fi.hh.DeltaKyselyBack;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.DeltaKyselyBack.domain.Kysely;
import fi.hh.DeltaKyselyBack.domain.KyselyRepositorio;
import fi.hh.DeltaKyselyBack.domain.Kysymys;
import fi.hh.DeltaKyselyBack.domain.KysymysRepositorio;
import fi.hh.DeltaKyselyBack.domain.Monivalinta;
import fi.hh.DeltaKyselyBack.domain.MonivalintaRepo;
import fi.hh.DeltaKyselyBack.domain.VastausRepositorio;
import fi.hh.DeltaKyselyBack.domain.Vastaus;


@SpringBootApplication
public class DeltaKyselyBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeltaKyselyBackApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(KyselyRepositorio kyselyRepositorio, KysymysRepositorio kysymysRepositorio, VastausRepositorio vastausRepositorio, MonivalintaRepo monivalintaRepo) {
		
		return (args) -> {
			Kysely kysely1 = new Kysely("Testikysely 1", null, null);
			Kysely kysely2 = new Kysely("Testikysely 2", null, null);

			kyselyRepositorio.save(kysely1);
			kyselyRepositorio.save(kysely2);

			Kysymys kysymys1 = new Kysymys("Lempi värisi?", kysely1, null, null, null);
			Kysymys kysymys2 = new Kysymys("Lempi eläimesi?", kysely1, null, null, null);
			Kysymys kysymys3 = new Kysymys("Lempi harrastuksesi?", kysely1, null, null, null);

			kysymysRepositorio.save(kysymys1);
			kysymysRepositorio.save(kysymys2);
			kysymysRepositorio.save(kysymys3);

			Vastaus vastaus1 = new Vastaus("Punainen", kysymys1, null);

			vastausRepositorio.save(vastaus1);
			
			Monivalinta vaihtoehto1 = new Monivalinta("sininen", kysymys1, vastaus1);

			monivalintaRepo.save(vaihtoehto1);


		};

}}
