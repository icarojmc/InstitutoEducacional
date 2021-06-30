package com.icarocavalcanti.institutoeducacional.repository.usuarios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icarocavalcanti.institutoeducacional.model.ProfessorEvento;

@Repository
public interface ProfessorEventoRepository extends JpaRepository<ProfessorEvento, Long> {

	Optional<ProfessorEvento> findByCursoId(long id);

}
