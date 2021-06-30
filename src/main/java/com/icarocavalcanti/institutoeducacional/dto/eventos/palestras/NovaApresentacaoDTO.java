package com.icarocavalcanti.institutoeducacional.dto.eventos.palestras;

import com.icarocavalcanti.institutoeducacional.model.ProfessorEvento;
import com.icarocavalcanti.institutoeducacional.model.SituacaoDoVinculo;
import com.icarocavalcanti.institutoeducacional.model.eventos.Apresentacao;
import com.icarocavalcanti.institutoeducacional.repository.eventos.ApresentacaoRepository;
import com.icarocavalcanti.institutoeducacional.repository.usuarios.ProfessorEventoRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NovaApresentacaoDTO {

	private String nome;
	
	public Apresentacao toApresentacao(ProfessorEventoRepository prevRepository, ApresentacaoRepository apresentacaoRepository) {
		var apresentacao = new Apresentacao();
		var prev = new ProfessorEvento();
		
		apresentacao.setNome(nome);
		apresentacao = apresentacaoRepository.save(apresentacao);
		prev.setPalestra(apresentacao);
		prev.setSituacaoDoVinculo(SituacaoDoVinculo.PENDENTE);
		prevRepository.save(prev);
		return apresentacao;
	}
}
