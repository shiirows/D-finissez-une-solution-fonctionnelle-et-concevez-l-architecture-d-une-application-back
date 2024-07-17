package projetcar.mazoyer.alexandre.projetThree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import projetcar.mazoyer.alexandre.projetThree.models.MessageSocket;
import projetcar.mazoyer.alexandre.projetThree.models.OutputMessage;
import projetcar.mazoyer.alexandre.projetThree.security.WebSecurityConfig;
import projetcar.mazoyer.alexandre.projetThree.service.Messages_SyncService;

@Controller
public class MessageSocketController {

	@Autowired
	private WebSecurityConfig config; // Injectez votre configuration Spring Security ici

	@Autowired
	Messages_SyncService messages_SyncService;

	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public OutputMessage send(MessageSocket message) throws Exception {

		try {
			// Utilisez l'instance injectée pour appeler la méthode register
			return messages_SyncService.register(message, config.authentification());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("You are not connected");
		}
	}

}
