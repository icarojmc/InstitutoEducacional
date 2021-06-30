package com.icarocavalcanti.institutoeducacional.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.icarocavalcanti.institutoeducacional.model.eventos.Evento;
import com.icarocavalcanti.institutoeducacional.model.usuarios.externos.Inscrito;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "inscrito_evento")
public class InscritoEvento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private Inscrito inscrito;
	
	@ManyToOne
	private Evento evento;
	
	@Enumerated(EnumType.STRING)
	private SituacaoDoVinculo situacaoDoVinculo;
}
