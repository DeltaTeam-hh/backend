package fi.hh.DeltaKyselyBack.domain;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KyselyRepositorio extends CrudRepository<Kysely, Long> {

	List<Kysely> findByKyselyId(Long kyselyId); //saa muuttaa järkevämmäksi
	
	List<Kysely> findByOtsikko(String otsikko);


}
