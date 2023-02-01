package com.te.resumebuilder.service;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.te.resumebuilder.dto.RegisterUserDto;
import com.te.resumebuilder.dto.UserProfileDto;

public interface UserService extends UserDetailsService{

	//add data to resume
	UserProfileDto addDataToResume(UserProfileDto userProfileDto);

	UserProfileDto getUserById(Integer userProfileId);

	RegisterUserDto registationOfUser(RegisterUserDto registerUserDto);

}
