package com.te.resumebuilder.reponse;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Component
@AllArgsConstructor
@NoArgsConstructor
public class AppResponse {

	private int status;
	private String message;
	private boolean success;
	private Object userResumeData;
}
