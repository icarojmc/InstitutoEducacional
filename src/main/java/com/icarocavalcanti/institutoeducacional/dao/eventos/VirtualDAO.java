package com.icarocavalcanti.institutoeducacional.dao.eventos;

import java.time.LocalDateTime;

import com.icarocavalcanti.institutoeducacional.model.eventos.mododeexecucao.Virtual;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VirtualDAO extends ModoDeExecucaoDAO {

	private long id;
	private String tipo;
	private LocalDateTime inicio;
	private LocalDateTime fim;
	private String link;
	
	
	public static ModoDeExecucaoDAO converter(Virtual modoDeExecucao) {
		
		var moEx = new VirtualDAO();
		moEx.setId(modoDeExecucao.getId());
		moEx.setInicio(modoDeExecucao.getInicioDaDisponibilidade());
		moEx.setFim(modoDeExecucao.getFimDaDisponibilidade());
		moEx.setTipo(modoDeExecucao.getTipo());
		moEx.setLink(modoDeExecucao.getLink());
		
		return moEx;
	}
	
}
