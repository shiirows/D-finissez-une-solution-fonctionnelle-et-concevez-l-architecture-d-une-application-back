package projetcar.mazoyer.alexandre.projetThree.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetcar.mazoyer.alexandre.projetThree.models.MessageSocket;
import projetcar.mazoyer.alexandre.projetThree.models.Messages_Sync;
import projetcar.mazoyer.alexandre.projetThree.models.OutputMessage;
import projetcar.mazoyer.alexandre.projetThree.models.Session;
import projetcar.mazoyer.alexandre.projetThree.models.User;
import projetcar.mazoyer.alexandre.projetThree.repository.MessageAsyncRepository;
import projetcar.mazoyer.alexandre.projetThree.repository.MessageSyncRepository;
import projetcar.mazoyer.alexandre.projetThree.repository.SessionRepository;
import projetcar.mazoyer.alexandre.projetThree.repository.UserRepository;

@Service
public class Messages_SyncService {
	
	
	
	
	 @Autowired
	    UserRepository userRepository;

	    @Autowired
	    SessionRepository sessionRepository;

	    @Autowired
	    MessageSyncRepository messageSyncRepository;

	    public OutputMessage register(MessageSocket message, User userSender) {

	        // Récupérer ou créer la session
	    	Session session = sessionRepository.findById(message.getRoomId()).orElseGet(() -> {
	            Session newSession = new Session();
	            newSession.setUser(userSender);
	            newSession.setStatus("open");
	            return sessionRepository.save(newSession);
	        });

	        Date date = new Date();
	        String time = new SimpleDateFormat("HH:mm").format(new Date());

	        Messages_Sync messages_Sync = new Messages_Sync();
	        messages_Sync.setMessage(message.getText());
	        messages_Sync.setUserSender(userSender);
	        messages_Sync.setSession(session);
	        messages_Sync.setCreatedAt(date);

	        messageSyncRepository.save(messages_Sync);

	        return new OutputMessage(userSender.getFirstName(), message.getText(), time);
	    }

/*	@Autowired
	UserRepository userRepository;

	@Autowired
	MessageSyncRepository messageSyncRepository;

	public OutputMessage register(MessageSocket message, User userSender) {
		
		
	}

		User userReceiver = userRepository.getById(message.getUser_receiver_id());
		Date date = new Date();
		String time = new SimpleDateFormat("HH:mm").format(new Date());
		Messages_Sync messages_Sync = new Messages_Sync();
		System.out.println("Message from " + userSender.getFirstName() + ": " + message.getText());

		messages_Sync.setMessage(message.getText());
		messages_Sync.setUserReceiver(userReceiver);
		messages_Sync.setUserSender(userSender);
		messages_Sync.setCreatedAt(date);

		messageSyncRepository.save(messages_Sync);

		return new OutputMessage(userSender.getFirstName(), message.getText(), time);
	}
*/
}
