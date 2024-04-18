package fi.hh.DeltaKyselyBack;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.DeltaKyselyBack.domain.Kysely;
import fi.hh.DeltaKyselyBack.domain.KyselyRepositorio;
import fi.hh.DeltaKyselyBack.domain.Kysymys;
import fi.hh.DeltaKyselyBack.domain.KysymysRepositorio;


@SpringBootApplication
public class DeltaKyselyBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeltaKyselyBackApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(KyselyRepositorio kyselyRepositorio, KysymysRepositorio kysymysRepositorio) {
		
		return (args) -> {
			Kysely kysely1 = new Kysely("Testikysely 1", null);
			Kysely kysely2 = new Kysely("Testikysely 2", null);

			kyselyRepositorio.save(kysely1);
			kyselyRepositorio.save(kysely2);

			Kysymys kysymys1 = new Kysymys("Lempi värisi?", kysely1);
			Kysymys kysymys2 = new Kysymys("Lempi eläimesi?", kysely1);
			Kysymys kysymys3 = new Kysymys("Lempi harrastuksesi?", kysely1);

			kysymysRepositorio.save(kysymys1);
			kysymysRepositorio.save(kysymys2);
			kysymysRepositorio.save(kysymys3);


		};

}}
