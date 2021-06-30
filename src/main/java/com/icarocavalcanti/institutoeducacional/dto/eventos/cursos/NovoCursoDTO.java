package com.icarocavalcanti.institutoeducacional.dto.eventos.cursos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.icarocavalcanti.institutoeducacional.model.ProfessorEvento;
import com.icarocavalcanti.institutoeducacional.model.SituacaoDoVinculo;
import com.icarocavalcanti.institutoeducacional.model.eventos.Curso;
import com.icarocavalcanti.institutoeducacional.model.eventos.EstadoDoEvento;
import com.icarocavalcanti.institutoeducacional.repository.eventos.CursoRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NovoCursoDTO {

	private String nome;
	private String valor;
	private String numeroDeVagas;
	
	public Curso toCurso(CursoRepository cursoRepository) {
		
		var curso = new Curso();
		var prev = new ProfessorEvento();
		
		curso.setNome(nome);
		curso.setValor(new BigDecimal(valor));
		curso.setNumeroDeVagas(Integer.parseInt(numeroDeVagas));
		curso.setEstadoDoEvento(EstadoDoEvento.RASCUNHO);
		curso.setDataDeCriacao(LocalDateTime.now());
		prev.setCurso(curso);
		prev.setSituacaoDoVinculo(SituacaoDoVinculo.PENDENTE);
		curso.setProfessor(prev);
		cursoRepository.save(curso);
		return curso;
	}
}
