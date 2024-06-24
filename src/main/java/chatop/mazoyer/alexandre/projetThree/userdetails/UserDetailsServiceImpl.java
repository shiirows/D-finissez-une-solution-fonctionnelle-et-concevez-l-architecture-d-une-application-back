package chatop.mazoyer.alexandre.projetThree.userdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import chatop.mazoyer.alexandre.projetThree.models.User;
import chatop.mazoyer.alexandre.projetThree.repository.UserRepository;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	// connexion par email
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Error: User is not found."));

		return UserDetailsImpl.build(user);

	}


}
