package projetcar.mazoyer.alexandre.projetThree.convert;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import projetcar.mazoyer.alexandre.projetThree.DTO.UserInfoDto;
import projetcar.mazoyer.alexandre.projetThree.models.User;

@Component
public class UserInfoConvert {

	public UserInfoDto entityToDto(User user) {

		UserInfoDto dto = new UserInfoDto();

		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());
		return dto;
	}

	public List<UserInfoDto> entityToDto(List<User> userInfo) {

		return userInfo.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

	}

}
