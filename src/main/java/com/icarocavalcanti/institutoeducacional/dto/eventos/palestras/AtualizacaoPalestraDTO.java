package com.icarocavalcanti.institutoeducacional.dto.eventos.palestras;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.icarocavalcanti.institutoeducacional.model.eventos.EstadoDoEvento;
import com.icarocavalcanti.institutoeducacional.model.eventos.Palestra;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizacaoPalestraDTO {

	private String nome;
	private BigDecimal valor;
	private int numeroDeVagas;
	private EstadoDoEvento estadoDoEvento;
	
	public Palestra atualizarPalestra(Palestra palestra) {
		
		palestra.setNome(nome);
		palestra.setValor(valor);
		palestra.setNumeroDeVagas(numeroDeVagas);
		palestra.setEstadoDoEvento(estadoDoEvento);
		
		return palestra;
	}
	
}
