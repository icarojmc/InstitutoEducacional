package com.icarocavalcanti.institutoeducacional.repository.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icarocavalcanti.institutoeducacional.model.InscritoEvento;
import com.icarocavalcanti.institutoeducacional.model.eventos.Curso;
import com.icarocavalcanti.institutoeducacional.model.usuarios.externos.Inscrito;

@Repository
public interface InscritoEventoRepository extends JpaRepository<InscritoEvento, Long> {

	void deleteByEventoAndInscrito(Curso curso, Inscrito inscrito);

	

}
