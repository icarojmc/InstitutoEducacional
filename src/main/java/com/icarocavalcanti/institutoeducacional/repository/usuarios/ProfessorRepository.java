package com.icarocavalcanti.institutoeducacional.repository.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icarocavalcanti.institutoeducacional.model.usuarios.externos.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

	
}
