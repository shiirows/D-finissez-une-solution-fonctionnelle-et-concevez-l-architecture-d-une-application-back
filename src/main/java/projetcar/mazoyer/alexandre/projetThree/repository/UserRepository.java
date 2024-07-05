package projetcar.mazoyer.alexandre.projetThree.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import projetcar.mazoyer.alexandre.projetThree.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsByEmail(String email);

	Optional<User> findByEmail(String email);

}
