package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.UserValidator;
import app.domain.model.User;

@Component
public class UserBuilder {
	
	@Autowired
	private UserValidator userValidators;
	
	
	public User build(String name, String id, String age, String userName, String password) throws Exception {
		User user = new User();
		user.setFullName(userValidators.nameValidator(name));
		user.setId(userValidators.idValidator(id));
		user.setAge(userValidators.ageValidator(age));
		user.setUsername(userValidators.userNameValidator(userName));
		user.setPassword(userValidators.passwordValidator(password));
		return user;
	}

}