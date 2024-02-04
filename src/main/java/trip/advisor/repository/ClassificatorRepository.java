package trip.advisor.repository;

import trip.advisor.model.Classificator;
import trip.advisor.model.Item;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificatorRepository extends ListCrudRepository<Classificator, Integer> {
	
	@Query("SELECT c FROM Classificator c WHERE c.domain = 'SEASON' AND c.code =:seasonCode")
	Classificator getClassificatorBySeason(@Param("seasonCode") String seasonCode);
}