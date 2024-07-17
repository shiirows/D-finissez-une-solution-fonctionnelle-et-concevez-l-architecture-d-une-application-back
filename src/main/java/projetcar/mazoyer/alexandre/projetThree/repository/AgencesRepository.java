package projetcar.mazoyer.alexandre.projetThree.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import projetcar.mazoyer.alexandre.projetThree.models.Agences;

public interface AgencesRepository extends JpaRepository<Agences, Long> {

	boolean existsByName(String name);
	
	Optional<Agences> findByName(String name);

}
