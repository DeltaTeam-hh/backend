package fi.hh.DeltaKyselyBack;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.DeltaKyselyBack.domain.Kysely;
import fi.hh.DeltaKyselyBack.domain.KyselyRepositorio;


@SpringBootApplication
public class DeltaKyselyBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeltaKyselyBackApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(KyselyRepositorio kyselyRepositorio) {
		return (args) -> {
			kyselyRepositorio.save(new Kysely(null, "Testikysely 1", null));
			kyselyRepositorio.save(new Kysely(null, "Testikysely 2", null));


		};

}}

// Testikommentti!!!!

//Jaritest

// Jonin testi
