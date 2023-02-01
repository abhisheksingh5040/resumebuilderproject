package com.te.resumebuilder.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
public class RegisterUserDto {

	private String registerUserEmail;

	private String registerUserPassword;

}
