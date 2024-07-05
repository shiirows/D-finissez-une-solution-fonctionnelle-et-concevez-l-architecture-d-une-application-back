package projetcar.mazoyer.alexandre.projetThree.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import projetcar.mazoyer.alexandre.projetThree.DTO.UserInfoDto;
import projetcar.mazoyer.alexandre.projetThree.convert.UserInfoConvert;
import projetcar.mazoyer.alexandre.projetThree.jwt.JwtUtils;
import projetcar.mazoyer.alexandre.projetThree.models.User;
import projetcar.mazoyer.alexandre.projetThree.repository.UserRepository;
import projetcar.mazoyer.alexandre.projetThree.request.SigninRequest;
import projetcar.mazoyer.alexandre.projetThree.request.SignupRequest;
import projetcar.mazoyer.alexandre.projetThree.response.JwtResponse;

@Service
public class AuthService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	UserInfoConvert convert;

	public ResponseEntity<?> register(SignupRequest signupRequest) throws Exception {

		Date date = new Date();
		User user = new User();
		user.setEmail(signupRequest.getEmail());
		user.setName(signupRequest.getName());
		user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
		userRepository.save(user);

		SigninRequest signinRequest = new SigninRequest();

		signinRequest.setEmail(signupRequest.getEmail());
		signinRequest.setPassword(signupRequest.getPassword());

		return this.signinUser(signinRequest);

	}

	public ResponseEntity<?> signinUser(SigninRequest signinRequest) throws Exception {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(signinRequest.getEmail(), signinRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJWTToken(authentication);

		return ResponseEntity.ok(new JwtResponse(jwt));

	}

	public UserInfoDto getUser(User user) {

		return convert.entityToDto(user);

	}

}
