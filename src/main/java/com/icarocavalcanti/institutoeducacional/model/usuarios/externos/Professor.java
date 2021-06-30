package com.icarocavalcanti.institutoeducacional.model.usuarios.externos;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.icarocavalcanti.institutoeducacional.model.ProfessorEvento;
import com.icarocavalcanti.institutoeducacional.model.usuarios.UsuarioExterno;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "P")
public class Professor extends UsuarioExterno {

	private String curriculo;
	private String tipoDeVinculoString;
	
	@OneToMany(mappedBy = "professor")
	private List<ProfessorEvento> palestras;

	
}
