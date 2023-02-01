package com.te.resumebuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.resumebuilder.entity.AchievementsDetails;

@Repository
public interface AchievementsDetailsRepository extends JpaRepository<AchievementsDetails, Integer> {

}
