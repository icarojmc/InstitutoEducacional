package com.icarocavalcanti.institutoeducacional.dao.eventos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.icarocavalcanti.institutoeducacional.model.eventos.Curso;
import com.icarocavalcanti.institutoeducacional.model.eventos.EstadoDoEvento;
import com.icarocavalcanti.institutoeducacional.repository.eventos.CursoRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CursoDAO {

	private long id;
	private String nome;
	private BigDecimal valor;
	private int numeroDeVagas;
	private ProfessorVinculadoDAO professor;
	private LocalDateTime dataDeCriacao;
	private EstadoDoEvento estadoDoEvento;
	private int numeroDeInscritos;
	private ModoDeExecucaoDAO modoDeExecucao;
	
	public static List<CursoDAO> buscarCursos(CursoRepository cursoRepository) {
		return converter(cursoRepository.findAll());
	}


	public static CursoDAO converter(Curso curso) {
		var cursoDAO = new CursoDAO();
		cursoDAO.setId(curso.getId());
		cursoDAO.setNome(curso.getNome());
		cursoDAO.setValor(curso.getValor());
		cursoDAO.setNumeroDeVagas(curso.getNumeroDeVagas());
		cursoDAO.setDataDeCriacao(curso.getDataDeCriacao());
		cursoDAO.setEstadoDoEvento(curso.getEstadoDoEvento());
		if(curso.getProfessor()!= null && curso.getProfessor().getProfessor() != null) 
			cursoDAO.setProfessor(
					ProfessorVinculadoDAO.converter(
							curso.getProfessor().getProfessor()));
		if(curso.getInscritos() != null) 
			cursoDAO.setNumeroDeInscritos(
					curso.getInscritos().size());
		if(curso.getModoDeExecucao() != null) 
			cursoDAO.setModoDeExecucao(
					ModoDeExecucaoDAO.converter(
							curso.getModoDeExecucao()));
		return cursoDAO;
	}
	
public static List<CursoDAO> converter(List<Curso> cursos) {
		List<CursoDAO> convertidos = new ArrayList<>();
		for (Curso curso : cursos) {
			convertidos.add(CursoDAO.converter(curso));
		}
		return convertidos;
	}

}
