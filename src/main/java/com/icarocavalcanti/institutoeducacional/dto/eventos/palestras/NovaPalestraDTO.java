package com.icarocavalcanti.institutoeducacional.dto.eventos.palestras;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.icarocavalcanti.institutoeducacional.model.eventos.EstadoDoEvento;
import com.icarocavalcanti.institutoeducacional.model.eventos.Palestra;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NovaPalestraDTO {

	private String nome;
	private BigDecimal valor;
	private int numeroDeVagas;
	private EstadoDoEvento estadoDoEvento;
	
	public Palestra toPalestra() {
		var palestra = new Palestra();
		palestra.setNome(nome);
		palestra.setValor(valor);
		palestra.setNumeroDeVagas(numeroDeVagas);
		palestra.setDataDeCriacao(LocalDateTime.now());
		palestra.setEstadoDoEvento(estadoDoEvento);
		
		return palestra;
	}
}
