package com.icarocavalcanti.institutoeducacional.dto.eventos;

import java.time.LocalDateTime;

import com.icarocavalcanti.institutoeducacional.dao.eventos.CursoDAO;
import com.icarocavalcanti.institutoeducacional.model.eventos.Curso;
import com.icarocavalcanti.institutoeducacional.model.eventos.mododeexecucao.Virtual;
import com.icarocavalcanti.institutoeducacional.repository.eventos.CursoRepository;
import com.icarocavalcanti.institutoeducacional.repository.eventos.VirtualRepository;

import lombok.Setter;

import lombok.Getter;

@Getter
@Setter
public class ExecucaoVirtualDTO {

	private int anoInicio;
	private int mesInicio;
	private int diaInicio;
	private int anoFim;
	private int mesFim;
	private int diaFim;
	private String link;
	
	
	public CursoDAO toExecucaoVirtual(Curso curso, CursoRepository cursoRepository, VirtualRepository exViRepository) {
		
		var virtual = new Virtual();
		virtual.setInicioDaDisponibilidade(LocalDateTime.of(anoInicio, mesInicio, diaInicio, 0, 0));
		virtual.setFimDaDisponibilidade(LocalDateTime.of(anoFim, mesFim, diaFim, 0, 0));
		virtual.setLink(link);
		virtual.setTipo("V");
		curso.setModoDeExecucao(virtual);
		exViRepository.save(virtual);
		return CursoDAO.converter(cursoRepository.save(curso));
	}
	
}
