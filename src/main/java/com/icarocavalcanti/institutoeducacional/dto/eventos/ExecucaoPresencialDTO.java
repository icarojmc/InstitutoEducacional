package com.icarocavalcanti.institutoeducacional.dto.eventos;

import java.time.LocalDateTime;

import com.icarocavalcanti.institutoeducacional.dao.eventos.CursoDAO;
import com.icarocavalcanti.institutoeducacional.model.eventos.Curso;
import com.icarocavalcanti.institutoeducacional.model.eventos.EstadoBrasileiro;
import com.icarocavalcanti.institutoeducacional.model.eventos.mododeexecucao.Presencial;
import com.icarocavalcanti.institutoeducacional.repository.eventos.CursoRepository;
import com.icarocavalcanti.institutoeducacional.repository.eventos.PresencialRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExecucaoPresencialDTO {

	private int anoInicio;
	private int mesInicio;
	private int diaInicio;
	private int anoFim;
	private int mesFim;
	private int diaFim;
	private EstadoBrasileiro estadoBrasileiro;
	private String cidade;
	private long cep;

	public CursoDAO toExecucaoPresencial(Curso curso, CursoRepository cursoRepository,
			PresencialRepository exPrRepository) {

		var presencial = new Presencial();
		presencial.setInicioDaDisponibilidade(LocalDateTime.of(anoInicio, mesInicio, diaInicio, 0, 0));
		presencial.setFimDaDisponibilidade(LocalDateTime.of(anoFim, mesFim, diaFim, 0, 0));
		presencial.setEstadoBrasileiro(estadoBrasileiro);
		presencial.setCidade(cidade);
		presencial.setCep(cep);
		presencial.setTipo("P");
		curso.setModoDeExecucao(exPrRepository.save(presencial));
		
		return CursoDAO.converter(cursoRepository.save(curso));
	}
}
