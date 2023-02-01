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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProjectDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="project_id")
	private int projectId;
	
	@ElementCollection
	@CollectionTable(name="project_frontend_technologies",
	                 joinColumns =@JoinColumn(name="project_id"))
	@Column(name="frontend_technologies")
	private List<String> projectFrontendTechnologies;
	
	@ElementCollection
	@CollectionTable(name="project_backend_technologies",
	                  joinColumns = @JoinColumn(name="project_id")) 
	@Column(name="backend_technologies")
	private List<String> projectBackEndTechnologies;
	
	@ElementCollection
	@CollectionTable(name="project_builder_patterns",
	                  joinColumns = @JoinColumn(name="project_id"))
	@Column(name="builder_patterns")
	private List<String> projectBluilderPatterns;
	
	@ElementCollection
	@CollectionTable(name="project_details_databases",
	                  joinColumns = @JoinColumn(name="project_id"))
	@Column(name="project_databases")
	private List<String> projectDatabases;
	
	@ElementCollection
	@CollectionTable(name="project_developement_tools",
	                  joinColumns = @JoinColumn(name="project_id"))
	@Column(name="development_tools")
	private List<String> projectDevelopmentTools;
	
	@Column(name="duration")
	private String projectDuration;
	
	@Column(name="team_size")
	private Integer projectTeamSize;
	
	@Column(name="description")
	private String projectDescription;
	
	@Column(name="roles_and_responsibilities")
	private String projectRolesAndResposnsibilities;
	
}
