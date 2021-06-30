package com.icarocavalcanti.institutoeducacional.dto;

import javax.persistence.OneToOne;

import com.icarocavalcanti.institutoeducacional.model.ProfessorEvento;
import com.icarocavalcanti.institutoeducacional.model.eventos.Curso;
import com.icarocavalcanti.institutoeducacional.model.usuarios.externos.Professor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VinculoProfessorCursoDTO {

	private Professor professor;
	private Curso curso;
	
	public ProfessorEvento toVinculo() {
		
		var vinculo = new ProfessorEvento();
		vinculo.setCurso(curso);
		vinculo.setProfessor(professor);
		
		return vinculo;
		
	}
}
