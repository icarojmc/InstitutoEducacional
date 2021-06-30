package com.icarocavalcanti.institutoeducacional.model.eventos;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "P")
public class Palestra extends Evento {

	@OneToMany
	private List<Apresentacao> apresentacoes;
}
