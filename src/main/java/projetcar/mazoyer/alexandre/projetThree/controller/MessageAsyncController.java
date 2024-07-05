package projetcar.mazoyer.alexandre.projetThree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projetcar.mazoyer.alexandre.projetThree.request.MessageAsyncRequest;
import projetcar.mazoyer.alexandre.projetThree.response.MessageResponse;
import projetcar.mazoyer.alexandre.projetThree.security.WebSecurityConfig;
import projetcar.mazoyer.alexandre.projetThree.service.MessageService;
@RestController
@CrossOrigin
@RequestMapping("/api/messages")
public class MessageAsyncController {

	@Autowired
	WebSecurityConfig config;

	@Autowired
	MessageService messageService;

	@PostMapping("")
	public ResponseEntity<?> createMessage(@RequestBody MessageAsyncRequest messageAsyncRequest) {

		try {
			 config.authentification();
			return new ResponseEntity<>(messageService.createMessage(messageAsyncRequest), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new MessageResponse("you are not connected"),HttpStatus.CONFLICT);
		}

	}

}
