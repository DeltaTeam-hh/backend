package fi.hh.DeltaKyselyBack.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface KysymysRepositorio extends CrudRepository<Kysymys, Long> {

	List<Kysymys> findByKysymysTeksti(String kysymysTeksti); //saa muuttaa järkevämmäksi

	//void saveAll(List<String> kysymykset);


}
