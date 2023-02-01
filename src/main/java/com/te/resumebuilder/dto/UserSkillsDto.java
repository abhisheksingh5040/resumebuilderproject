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
public class UserSkillsDto {

	private List<String> frontendTechnologies;

	private List<String> backendTechnologies;

	private List<String> middlewareTechnologies;

	private List<String> designPatterns;

	private List<String> databases;

	private List<String> versionControlSystems;

	private List<String> aws;

	private List<String> sdlc;

	private List<String> developmentTools;
}
