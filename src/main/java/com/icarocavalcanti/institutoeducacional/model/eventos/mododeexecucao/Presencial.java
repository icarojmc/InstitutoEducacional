package com.icarocavalcanti.institutoeducacional.model.eventos.mododeexecucao;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.icarocavalcanti.institutoeducacional.model.eventos.EstadoBrasileiro;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "P")
public class Presencial extends ModoDeExecucao {

	@Enumerated(EnumType.STRING)
	private EstadoBrasileiro estadoBrasileiro;
	private String cidade;
	private long cep;
	
}
