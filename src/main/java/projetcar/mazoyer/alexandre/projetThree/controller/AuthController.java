package projetcar.mazoyer.alexandre.projetThree.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projetcar.mazoyer.alexandre.projetThree.repository.UserRepository;
import projetcar.mazoyer.alexandre.projetThree.request.SigninRequest;
import projetcar.mazoyer.alexandre.projetThree.request.SignupRequest;
import projetcar.mazoyer.alexandre.projetThree.response.MessageResponse;
import projetcar.mazoyer.alexandre.projetThree.security.WebSecurityConfig;
import projetcar.mazoyer.alexandre.projetThree.service.AuthService;


@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AuthService authService;

	@Autowired
	WebSecurityConfig config;

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {

		if (userRepository.existsByEmail(signupRequest.getEmail())) {

			return ResponseEntity.badRequest().body(new MessageResponse("email address already in use."));
		}

		try {
			return authService.register(signupRequest);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

	}

	@PostMapping("/login")
	public ResponseEntity<?> signin(@Valid @RequestBody SigninRequest signinRequest) {

		try {
			return authService.signinUser(signinRequest);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}

	}

	@GetMapping("/me")
	public ResponseEntity<?> getUser() {

		try {
			return new ResponseEntity<>(authService.getUser(config.authentification()), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

	}

}
