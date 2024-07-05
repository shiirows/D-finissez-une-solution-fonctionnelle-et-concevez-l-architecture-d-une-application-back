package projetcar.mazoyer.alexandre.projetThree.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import projetcar.mazoyer.alexandre.projetThree.models.Messages_Async;
import projetcar.mazoyer.alexandre.projetThree.models.User;
import projetcar.mazoyer.alexandre.projetThree.repository.MessageRepository;
import projetcar.mazoyer.alexandre.projetThree.repository.UserRepository;
import projetcar.mazoyer.alexandre.projetThree.request.MessageRequest;
import projetcar.mazoyer.alexandre.projetThree.response.MessageResponse;

@Service
public class MessageService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	MessageRepository messageRepository;

	public ResponseEntity<MessageResponse> createMessage(MessageRequest messageRequest) {

		User user = userRepository.getById(messageRequest.getUser_id());
		Messages_Async messages_Async = new Messages_Async();
		Date date = new Date();

		messages_Async.setMessage(messageRequest.getMessage());
		messages_Async.setUser(user);
		messages_Async.setCreatedAt(date);

		messageRepository.save(messages_Async);

		return new ResponseEntity<>(new MessageResponse("Message send with success"), HttpStatus.ACCEPTED);
	}

}
