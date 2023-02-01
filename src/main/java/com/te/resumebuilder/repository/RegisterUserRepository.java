package com.te.resumebuilder.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.resumebuilder.entity.RegisterUser;

@Repository
public interface RegisterUserRepository extends JpaRepository<RegisterUser, Integer>{

	Optional<RegisterUser> findByRegisterUserEmail(String email);
}
