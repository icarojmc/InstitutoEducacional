package com.icarocavalcanti.institutoeducacional.model.eventos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.icarocavalcanti.institutoeducacional.model.ProfessorEvento;
import com.icarocavalcanti.institutoeducacional.model.eventos.mododeexecucao.ModoDeExecucao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "apresentacao")
public class Apresentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	
	@OneToOne(mappedBy = "palestra")
	private ProfessorEvento palestrante;
	
}
