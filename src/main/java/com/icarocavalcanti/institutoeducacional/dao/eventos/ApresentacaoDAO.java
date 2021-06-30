package com.icarocavalcanti.institutoeducacional.dao.eventos;

import java.util.ArrayList;
import java.util.List;

import com.icarocavalcanti.institutoeducacional.dao.usuarios.ProfessorDAO;
import com.icarocavalcanti.institutoeducacional.model.eventos.Apresentacao;
import com.icarocavalcanti.institutoeducacional.model.eventos.Palestra;
import com.sun.jdi.LongValue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApresentacaoDAO {
	
	private long id;
	private String nome;
	private ProfessorDAO palestrante;
	
	public static ApresentacaoDAO converter(Apresentacao apresentacao) {
		var apresentacaoDAO = new ApresentacaoDAO();
		apresentacaoDAO.setId(apresentacao.getId());
		apresentacaoDAO.setNome(apresentacao.getNome());
		if(apresentacao.getPalestrante() != null && apresentacao.getPalestrante().getProfessor() != null) apresentacaoDAO.setPalestrante(ProfessorDAO.converter(apresentacao.getPalestrante().getProfessor()));
		return apresentacaoDAO;
	}
	
	public static List<ApresentacaoDAO> converter(Palestra palestra){
		
		List<ApresentacaoDAO> apresentacoes = new ArrayList<>();
		for (Apresentacao apresentacao : palestra.getApresentacoes()) {
			
			apresentacoes.add(ApresentacaoDAO.converter(apresentacao));
		}
		
		return apresentacoes;
		
	}

	
	
}
