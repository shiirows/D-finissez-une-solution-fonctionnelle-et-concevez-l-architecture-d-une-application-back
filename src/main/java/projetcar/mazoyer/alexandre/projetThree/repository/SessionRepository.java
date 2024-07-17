package projetcar.mazoyer.alexandre.projetThree.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import projetcar.mazoyer.alexandre.projetThree.models.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

	Optional<Session> findById(String roomId);
}
