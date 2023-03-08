package com.app.service;

import com.app.dto.LoginRequestDto;
import com.app.pojos.User;

public interface StudentService {

	User authenticateCustomer(LoginRequestDto dto);

	User saveUserDetails(User user);

	User forgetPassword(LoginRequestDto dto);

}
