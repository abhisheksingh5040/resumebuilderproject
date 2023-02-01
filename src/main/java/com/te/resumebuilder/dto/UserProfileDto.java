package com.te.resumebuilder.dto;

import java.util.List;

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
public class UserProfileDto {

    private String userFirstName;
	
	private String userLastName;
	
	private List<String> userTechnology;
	
	private String userTotalExprience;
	
	private String userRelevantExprience;
	
	private List<EducationDetailsDto> educationDetails;
	
	private AchievementsDetailsDto achievementsDetails;
	
	private UserSkillsDto userSkills;
	
	private List<UserSummaryDto> userSummaries;
	
	private List<ProjectDetailsDto> projectDetails;
}
