package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{

	
}
