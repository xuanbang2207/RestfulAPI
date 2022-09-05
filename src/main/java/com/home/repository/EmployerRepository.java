package com.home.repository;

import java.util.List;

import com.home.entity.Employer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long>{
	List<Employer> findByEmail(String email);
	
	List<Employer> findByNameContaining(String name);
}
