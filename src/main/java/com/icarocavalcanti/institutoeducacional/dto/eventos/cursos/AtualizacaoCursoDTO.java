package com.icarocavalcanti.institutoeducacional.dto.eventos.cursos;

import java.math.BigDecimal;

import com.icarocavalcanti.institutoeducacional.model.eventos.Curso;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizacaoCursoDTO {

	private String nome;
	private String valor;
	private String numeroDeVagas;
	
	public Curso atualizarCurso(Curso curso) {
		
		curso.setNome(nome);
		curso.setValor(new BigDecimal(valor));
		curso.setNumeroDeVagas(Integer.parseInt(numeroDeVagas));
		
		return curso;
	}
}
