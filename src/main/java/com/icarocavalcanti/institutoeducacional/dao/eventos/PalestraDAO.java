package com.icarocavalcanti.institutoeducacional.dao.eventos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.icarocavalcanti.institutoeducacional.model.eventos.EstadoDoEvento;
import com.icarocavalcanti.institutoeducacional.model.eventos.Palestra;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PalestraDAO {

	private long id;
	private String nome;
	private BigDecimal valor;
	private int numeroDeVagas;
	private EstadoDoEvento estadoDoEvento;
	private LocalDateTime dataDeCriacao;
	
	public static PalestraDAO converter(Palestra palestra) {
		
		var palestraDAO = new PalestraDAO();
		palestraDAO.setId(palestra.getId());
		palestraDAO.setNome(palestra.getNome());
		palestraDAO.setValor(palestra.getValor());
		palestraDAO.setNumeroDeVagas(palestra.getNumeroDeVagas());
		palestraDAO.setEstadoDoEvento(palestra.getEstadoDoEvento());
		palestraDAO.setDataDeCriacao(palestra.getDataDeCriacao());
		
		return palestraDAO;
	}
	
	public static List<PalestraDAO> converter(List<Palestra> palestras){
		
		List<PalestraDAO> convertidos = new ArrayList<>();
		for (Palestra palestra : palestras) {	
			convertidos.add(PalestraDAO.converter(palestra));
		}
		return convertidos;
	}
	
}
