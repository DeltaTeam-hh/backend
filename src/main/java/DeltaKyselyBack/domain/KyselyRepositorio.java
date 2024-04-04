package DeltaKyselyBack.domain;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KyselyRepositorio extends CrudRepository<Kysely, Long> {

	List<Kysely> findById(String id); //saa muuttaa järkevämmäksi
	
	List<Kysely> findByName(String otsikko);


}
