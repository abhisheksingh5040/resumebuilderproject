package com.te.resumebuilder.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProjectDetailsDto {

	private List<String> projectFrontendTechnologies;

	private List<String> projectBackEndTechnologies;

	private List<String> projectBluilderPatterns;

	private List<String> projectDatabases;

	private List<String> projectDevelopmentTools;

	private String projectDuration;

	private Integer projectTeamSize;

	private String projectDescription;

	private String projectRolesAndResposnsibilities;
}
