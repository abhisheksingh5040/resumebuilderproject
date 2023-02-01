package com.te.resumebuilder.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user_education_details")
public class EducationDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int educationId;
	
	@Column(name="education",nullable = false)
	private String education;
	
	@Column(name="specialization",nullable = false)
	private String specialization;
	
	@Column(name="university",nullable = false)
	private String university;
	
	@Column(name="passout_year",nullable = false,length = 4)
	private int passoutYear;
	
	@Column(name="percentage",nullable = false)
	private double percentage;
	
	@ManyToOne
	@JsonIgnore
	private UserProfile userProfile;
}
