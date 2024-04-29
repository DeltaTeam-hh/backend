 package fi.hh.DeltaKyselyBack.domain;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface VastausRepositorio extends CrudRepository <Vastaus, Long> {
    List<Vastaus> findByVastausId(Long vastausId);

} 
