package com.icarocavalcanti.institutoeducacional.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.icarocavalcanti.institutoeducacional.model.eventos.Apresentacao;
import com.icarocavalcanti.institutoeducacional.model.eventos.Curso;
import com.icarocavalcanti.institutoeducacional.model.usuarios.externos.Professor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProfessorEvento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private Professor professor;
	
	@OneToOne
	private Curso curso;
	
	@ManyToOne
	private Apresentacao palestra;
	
	@Enumerated(EnumType.STRING)
	private SituacaoDoVinculo situacaoDoVinculo;
}
