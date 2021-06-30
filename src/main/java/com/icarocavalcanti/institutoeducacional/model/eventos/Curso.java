package com.icarocavalcanti.institutoeducacional.model.eventos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.icarocavalcanti.institutoeducacional.model.ProfessorEvento;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@DiscriminatorValue(value = "C")
public class Curso extends Evento {

	@OneToOne(mappedBy = "curso", cascade = CascadeType.ALL)
	private ProfessorEvento professor;
	
	@OneToMany
	private List<Material> material;
	
	
}
