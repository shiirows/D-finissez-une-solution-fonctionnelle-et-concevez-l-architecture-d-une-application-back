package chatop.mazoyer.alexandre.projetThree.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import chatop.mazoyer.alexandre.projetThree.models.Messages_Async;


public interface MessageRepository extends JpaRepository<Messages_Async, Long>{

}
