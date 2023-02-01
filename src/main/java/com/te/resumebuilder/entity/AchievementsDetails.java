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
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="user_achievement_details")
public class AchievementsDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="achievement_id")
	private Integer achievementId;
	
	@ElementCollection
	@CollectionTable(name="achievement_details",
	                 joinColumns =@JoinColumn(name="achievement_id"))
	@Column(name="achievement")
	private List<String> achievement;

}
