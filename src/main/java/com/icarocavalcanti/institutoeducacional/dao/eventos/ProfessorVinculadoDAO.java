package com.icarocavalcanti.institutoeducacional.dao.eventos;

import java.util.ArrayList;
import java.util.List;

import com.icarocavalcanti.institutoeducacional.model.usuarios.externos.Professor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessorVinculadoDAO {

	private String nome;
	private String email;
	private String cpf;
	private long telefone;
	
	public static ProfessorVinculadoDAO converter(Professor professor) {

		var professorVinculadoDAO = new ProfessorVinculadoDAO();
		professorVinculadoDAO.setNome(professor.getNome());
		professorVinculadoDAO.setEmail(professor.getEmail());
		professorVinculadoDAO.setCpf(professor.getCpf());
		professorVinculadoDAO.setTelefone(professor.getTelefone());
		return professorVinculadoDAO;
	}

	public static List<ProfessorVinculadoDAO> converter(List<Professor> professores) {

		List<ProfessorVinculadoDAO> convertidos = new ArrayList<>();

		for (Professor professor : professores) {

			convertidos.add(ProfessorVinculadoDAO.converter(professor));
		}
		return convertidos;
	}
}
