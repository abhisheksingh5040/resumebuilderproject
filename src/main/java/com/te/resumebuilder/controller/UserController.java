package com.te.resumebuilder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.resumebuilder.dto.RegisterUserDto;
import com.te.resumebuilder.dto.UserProfileDto;
import com.te.resumebuilder.reponse.AppResponse;
import com.te.resumebuilder.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/v1/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<RegisterUserDto> registationOfUser(@RequestBody RegisterUserDto registerUserDto){
		RegisterUserDto registerDto = userService.registationOfUser(registerUserDto);
		if(registerDto!= null) {
			return new ResponseEntity<RegisterUserDto>(registerDto,HttpStatus.OK);
		}else {
			return new ResponseEntity<RegisterUserDto>(HttpStatus.BAD_REQUEST);
		}
	}

	@Operation(summary = "To add all the data to resume")
	@PostMapping("/addDataToResume")
	public ResponseEntity<AppResponse> addDataToResume(@RequestBody UserProfileDto userProfileDto) {
		UserProfileDto profileDto = userService.addDataToResume(userProfileDto);
		if (userProfileDto != null) {
			return new ResponseEntity<AppResponse>(new AppResponse(201, "Data added successful..", false, profileDto),
					HttpStatus.CREATED);
		} else {
			return new ResponseEntity<AppResponse>(new AppResponse(400, "Data not added successful..", true, null),
					HttpStatus.BAD_REQUEST);
		}
	}

	@Operation(summary = "To get User by Id")
	@GetMapping("/getUserById/{userProfileId}")
	public ResponseEntity<AppResponse> getUserById(@PathVariable Integer userProfileId) {
		UserProfileDto userProfileDto = userService.getUserById(userProfileId);
		return new ResponseEntity<AppResponse>(new AppResponse(200, "user details", false, userProfileDto),
				HttpStatus.CREATED);
	}
}
