package chatop.mazoyer.alexandre.projetThree.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import chatop.mazoyer.alexandre.projetThree.DTO.UserInfoDto;
import chatop.mazoyer.alexandre.projetThree.convert.UserInfoConvert;
import chatop.mazoyer.alexandre.projetThree.models.User;
import chatop.mazoyer.alexandre.projetThree.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserInfoConvert convert;

	public UserInfoDto getUserId(Long id) {
		User user = userRepository.getById(id);
		return convert.entityToDto(user);
	}

}
