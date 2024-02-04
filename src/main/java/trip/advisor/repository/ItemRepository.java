package trip.advisor.repository;

import trip.advisor.model.Item;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends ListCrudRepository<Item, Integer> {

	List<Item> findByCategory(String category);

	@Query("SELECT i FROM Item i JOIN i.seasons s "
			+ "WHERE (:seasonCode IS NULL OR s.domain = 'SEASON' AND s.code = :seasonCode) "
			+ "AND (:category IS NULL OR i.category = :category)")
	List<Item> findItemsBySeasonAndCategory(@Param("seasonCode") String seasonCode, @Param("category") String category);

	@Query("SELECT i FROM Item i JOIN i.seasons s WHERE s.domain = 'SEASON' AND s.code = 'ALL_YEAR'")
	List<Item> getDefaultItems();
	
	@Query("SELECT i FROM Item i JOIN i.seasons s WHERE s.domain = 'SEASON' AND s.code in (:seasonCode, 'ALL_YEAR')")
	List<Item> getItemsBySeason(@Param("seasonCode") String seasonCode);

}