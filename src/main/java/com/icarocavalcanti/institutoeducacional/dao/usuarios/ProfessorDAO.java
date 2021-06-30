package com.icarocavalcanti.institutoeducacional.dao.usuarios;

import java.util.ArrayList;
import java.util.List;

import com.icarocavalcanti.institutoeducacional.model.ProfessorEvento;
import com.icarocavalcanti.institutoeducacional.model.eventos.Apresentacao;
import com.icarocavalcanti.institutoeducacional.model.usuarios.externos.Professor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessorDAO {

	private long id;
	private String nome;
	private String email;
	private String cpf;
	private long telefone;
	private String endereco;
	private String curriculo;
	private String tipoDeVinculo;


	public static ProfessorDAO converter(Professor professor) {

		var professorDAO = new ProfessorDAO();
		professorDAO.setId(professor.getId());
		professorDAO.setNome(professor.getNome());
		professorDAO.setEmail(professor.getEmail());
		professorDAO.setCpf(professor.getCpf());
		professorDAO.setTelefone(professor.getTelefone());
		professorDAO.setEndereco(professor.getEndereco());
		professorDAO.setCurriculo(professor.getCurriculo());
		professorDAO.setTipoDeVinculo(professor.getTipoDeVinculoString());

		return professorDAO;
	}

	public static List<ProfessorDAO> converter(List<Professor> professores) {

		List<ProfessorDAO> convertidos = new ArrayList<>();

		for (Professor professor : professores) {

			convertidos.add(ProfessorDAO.converter(professor));
		}
		return convertidos;
	}


}
