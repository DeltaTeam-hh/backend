package fi.hh.DeltaKyselyBack.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface KysymysRepositorio extends CrudRepository<Kysymys, Long> {

	  List<Kysymys> findByKysymysTeksti(String kysymysTeksti);  // Corrected method name

	  List<Kysymys> findByKysely(Kysely kysely);
	  
	  @Query("SELECT k FROM Kysymys k WHERE k.kysely.kyselyId = :kyselyId")
	  List<Kysymys> findByKyselyId(@Param("kyselyId") Long kyselyId);


}