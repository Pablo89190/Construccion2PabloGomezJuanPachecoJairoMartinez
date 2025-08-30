package app.adapter.in.builder;

import app.adapter.in.validators.UserValidator;
import app.domain.model.User;

public class UserBuilder {
	
	private UserValidator userValidators;
	
	
	public User build(String name, String document, String age, String userName, String password) throws Exception {
		User user = new User();
		user.setFullName(userValidators.nameValidator(name));
		user.setDocument(userValidators.documentValidator(document));
		user.setAge(userValidators.ageValidator(age));
		user.setUserName(userValidators.userNameValidator(userName));
		user.setPassword(userValidators.passwordValidator(password));
		return user;
	}

}