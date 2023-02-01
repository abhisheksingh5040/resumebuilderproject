package com.te.resumebuilder.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "profile")
public class UserProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "first_name", nullable = false)
	private String userFirstName;

	@Column(name = "last_name", nullable = false)
	private String userLastName;

	@ElementCollection
	@CollectionTable(name = "user_technology", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "technology")
	List<String> userTechnology;

	@Column(name = "total_experience")
	private String userTotalExprience;

	@Column(name = "relevant_experience")
	private String userRelevantExprience;
	
	
	//===============================================================
	
	@OneToOne
	@JoinColumn(name="register_user_id")
	private RegisterUser registerUser;

	@OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL)
	private List<EducationDetails> educationDetails;

	@OneToOne(cascade = CascadeType.ALL)
	private AchievementsDetails achievementsDetails;

	@OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
	private UserSkills userSkills;

	@OneToMany(cascade = CascadeType.ALL)
	private List<UserSummary> userSummaries;

	@OneToMany(cascade = CascadeType.ALL)
	private List<ProjectDetails> projectDetails;

}
