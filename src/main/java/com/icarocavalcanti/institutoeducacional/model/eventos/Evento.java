package com.icarocavalcanti.institutoeducacional.model.eventos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.icarocavalcanti.institutoeducacional.model.InscritoEvento;
import com.icarocavalcanti.institutoeducacional.model.eventos.mododeexecucao.ModoDeExecucao;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "evento")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", length = 1, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "E")
public abstract class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private BigDecimal valor;
	private int numeroDeVagas;
	private LocalDateTime dataDeCriacao;
	
	@OneToMany(mappedBy = "evento")
	private List<InscritoEvento> inscritos;
	
	@Enumerated(EnumType.STRING)
	private EstadoDoEvento estadoDoEvento;
	
	@OneToOne
	private ModoDeExecucao modoDeExecucao;
	
	public void mostrarInscritos(){}
	
	public void editarDescricao(String i) {}
	
}
