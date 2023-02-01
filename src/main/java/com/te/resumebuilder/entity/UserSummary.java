package com.te.resumebuilder.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class UserSummary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int summaryId;
	private String summaryDetails;
}
