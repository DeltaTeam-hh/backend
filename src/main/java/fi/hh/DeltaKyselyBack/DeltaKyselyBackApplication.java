
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

	public CommandLineRunner demo(KyselyRepositorio kyselyRepositorio, KysymysRepositorio kysymysRepositorio,
			VastausRepositorio vastausRepositorio, MonivalintaRepo monivalintaRepo) {

		return (args) -> {
			Kysely kysely1 = new Kysely("Palautekysely lähiopetuksen määrän lisäämisestä", null, null);
			Kysely kysely2 = new Kysely("Opiskelijatyytyväisyyskysely", null, null);

			kyselyRepositorio.save(kysely1);
			kyselyRepositorio.save(kysely2);

			Kysymys kysymys1 = new Kysymys("Oletko monimuoto- vai päiväopiskelija?", kysely1, null, null, null);
			Kysymys kysymys2 = new Kysymys("Minkä vuoden opiskelija olet?", kysely1, null, null, null);
			Kysymys kysymys3 = new Kysymys("Mitä mieltä olet Haaga-Helian päätöksestä lisätä läsnäopintojen määrää?",
					kysely1, null, null, null);

			kysymysRepositorio.save(kysymys1);
			kysymysRepositorio.save(kysymys2);
			kysymysRepositorio.save(kysymys3);

			Kysymys kysymys4 = new Kysymys("Oletko monimuoto- vai päiväopiskelija?",
					kysely2, null, null, null);
			Kysymys kysymys5 = new Kysymys("Minkä vuoden opiskelija olet?", kysely2,
					null, null, null);
			Kysymys kysymys6 = new Kysymys("Mitä mieltä olet opintojen ja vapaa-ajan suhteesta?", kysely2, null, null,
					null);
			Kysymys kysymys7 = new Kysymys("Miten kehittäisit opintoja tukemaan hyvinvointiasi?", kysely2, null, null,
					null);

			kysymysRepositorio.save(kysymys4);
			kysymysRepositorio.save(kysymys5);
			kysymysRepositorio.save(kysymys6);
			kysymysRepositorio.save(kysymys7);

			// Vastaus vastaus1 = new Vastaus("Punainen", kysymys1, null);

			// vastausRepositorio.save(vastaus1);

			// Monivalinta vaihtoehto1 = new Monivalinta("sininen", kysymys1, vastaus1);

			// monivalintaRepo.save(vaihtoehto1);

		};

	}
}
