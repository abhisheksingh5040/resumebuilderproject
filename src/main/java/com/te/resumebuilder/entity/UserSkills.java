package com.te.resumebuilder.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class UserSkills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="skill_id")
	private int skillId;
	
	@ElementCollection
	@CollectionTable(name="skills_frontend_technologies",
	                 joinColumns =@JoinColumn(name="skill_id"))
	@Column(name="frontend_technologies")
	private List<String> frontendTechnologies;
	
	@ElementCollection
	@CollectionTable(name="skills_backend_technologies",
	                 joinColumns =@JoinColumn(name="skill_id"))
	@Column(name="backend_technologies")
	private List<String> backendTechnologies;
	
	@ElementCollection
	@CollectionTable(name="skills_middleware_technologies",
	                 joinColumns =@JoinColumn(name="skill_id"))
	@Column(name="middleware_technologies")
	private List<String> middlewareTechnologies;
	
	@ElementCollection
	@CollectionTable(name="skills_design_pattern",
	                 joinColumns =@JoinColumn(name="skill_id"))
	@Column(name="design_patterns")
	private List<String> designPatterns;
	
	@ElementCollection
	@CollectionTable(name="user_skills_databases",
	                 joinColumns =@JoinColumn(name="skill_id"))
	@Column(name="skills_databases")
	private List<String> databases;
	
	@ElementCollection
	@CollectionTable(name="skills_version_control_sysyem",
	                 joinColumns =@JoinColumn(name="skill_id"))
	@Column(name="version_control_system")
	private List<String> versionControlSystems;
	
	@ElementCollection
	@CollectionTable(name="skills_aws",
	                 joinColumns =@JoinColumn(name="skill_id"))
	@Column(name="aws")
	private List<String> aws;
	
	@ElementCollection
	@CollectionTable(name="skills_sdlc",
	                 joinColumns =@JoinColumn(name="skill_id"))
	@Column(name="sdlc")
	private List<String> sdlc;
	
	@ElementCollection
	@CollectionTable(name="skills_developement_tools",
	                 joinColumns =@JoinColumn(name="skill_id"))
	@Column(name="development_tools")
	private List<String> developmentTools;
	
	@OneToOne
	@JsonIgnore
	private UserProfile userProfile;
}
