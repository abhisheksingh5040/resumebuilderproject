package com.te.resumebuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.resumebuilder.entity.UserSkills;

@Repository
public interface UserSkillsRepository extends JpaRepository<UserSkills, Integer> {

}
