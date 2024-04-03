package DeltaKyselyBack.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface KysymysRepositorio extends CrudRepository<Kysymys, Long> {

	List<Kysymys> findByKysymys(String kysymysTeksti); //saa muuttaa järkevämmäksi


}
