package com.te.resumebuilder.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EducationDetailsDto {

	private String education;
	
	private String specialization;
	
	private String university;
	
	private int passoutYear;
	
	private double percentage;
}
