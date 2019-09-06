package quanLi.validate;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import quanLi.model.Users;
import quanLi.service.UserService;
@Component
public class LoginValidator implements Validator{
	@Autowired
	private UserService userService;
	@Override
	public boolean supports(Class<?> claszz) {
		// support class nào trong việc validate
		// TODO Auto-generated method stub
		return claszz == Users.class ;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Users user = (Users) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "msg.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passWord", "msg.required");
		if(!StringUtils.isEmpty(user.getUserName()) && !StringUtils.isEmpty(user.getPassWord())){
			List<Users> users = userService.findByProperty("userName", user.getUserName());
			System.out.print(users.isEmpty());
			if(user!=null && !users.isEmpty()) {
				if(!users.get(0).getPassWord().equals(user.getPassWord())) {
					errors.rejectValue("password", "msg.wrong.password");
				}
			}else {
				
				errors.rejectValue("userName", "msg.wrong.username");
			}
		}
	}
	
}
