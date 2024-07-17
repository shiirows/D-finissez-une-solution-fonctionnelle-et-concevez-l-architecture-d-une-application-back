package projetcar.mazoyer.alexandre.projetThree.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import projetcar.mazoyer.alexandre.projetThree.models.ERoles;
import projetcar.mazoyer.alexandre.projetThree.models.Role;


public interface RoleRepository extends JpaRepository <Role, Long>{
    Optional <Role> findByName(ERoles name);
}
