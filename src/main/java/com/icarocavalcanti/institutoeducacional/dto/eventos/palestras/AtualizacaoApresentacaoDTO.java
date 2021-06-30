package com.icarocavalcanti.institutoeducacional.dto.eventos.palestras;

import com.icarocavalcanti.institutoeducacional.model.eventos.Apresentacao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizacaoApresentacaoDTO {

	private String nome;
	
	public Apresentacao atualizar(Apresentacao apresentacao) {
		apresentacao.setNome(nome);
		return apresentacao;
	}
}
