package com.te.resumebuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.resumebuilder.entity.UserSummary;

@Repository
public interface UserSummaryRepository extends JpaRepository<UserSummary, Integer> {

}
