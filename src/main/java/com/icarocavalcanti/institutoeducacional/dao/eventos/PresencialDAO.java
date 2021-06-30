package com.icarocavalcanti.institutoeducacional.dao.eventos;

import java.time.LocalDateTime;

import com.icarocavalcanti.institutoeducacional.model.eventos.EstadoBrasileiro;
import com.icarocavalcanti.institutoeducacional.model.eventos.mododeexecucao.Presencial;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PresencialDAO extends ModoDeExecucaoDAO {

	private long id;
	private String tipo;
	private LocalDateTime inicio;
	private LocalDateTime fim;
	private EstadoBrasileiro estadoBrasileiro;
	private String cidade;
	private long cep;
	
public static ModoDeExecucaoDAO converter(Presencial modoDeExecucao) {
		
		var moEx = new PresencialDAO();
		moEx.setId(modoDeExecucao.getId());
		moEx.setInicio(modoDeExecucao.getInicioDaDisponibilidade());
		moEx.setFim(modoDeExecucao.getFimDaDisponibilidade());
		moEx.setTipo(modoDeExecucao.getTipo());
		moEx.setEstadoBrasileiro(modoDeExecucao.getEstadoBrasileiro());
		moEx.setCidade(modoDeExecucao.getCidade());
		moEx.setCep(modoDeExecucao.getCep());
		
		return moEx;
	}
}
