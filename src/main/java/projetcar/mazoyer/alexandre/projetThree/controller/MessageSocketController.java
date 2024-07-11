package projetcar.mazoyer.alexandre.projetThree.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import projetcar.mazoyer.alexandre.projetThree.models.MessageSocket;
import projetcar.mazoyer.alexandre.projetThree.models.OutputMessage;
import projetcar.mazoyer.alexandre.projetThree.models.User;
import projetcar.mazoyer.alexandre.projetThree.security.WebSecurityConfig;

@Controller
public class MessageSocketController {

    @Autowired
    private WebSecurityConfig config; // Injectez votre configuration Spring Security ici

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(MessageSocket message) throws Exception {
        // Vérifier l'authentification de l'utilisateur
        User user = config.authentification();

        // Si l'utilisateur est authentifié, traiter le message
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        System.out.println("Message from " + user.getFirstName() + ": " + message.getText());
        return new OutputMessage(user.getFirstName(), message.getText(), time);
    }
}
