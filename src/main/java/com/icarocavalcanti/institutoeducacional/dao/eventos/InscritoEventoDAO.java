package com.icarocavalcanti.institutoeducacional.dao.eventos;

import java.util.ArrayList;
import java.util.List;

import com.icarocavalcanti.institutoeducacional.model.InscritoEvento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InscritoEventoDAO {

	private long matricula;
	private String nome;
	private String cpf;
	private String email;
	private long telefone;
	
	
	public static InscritoEventoDAO converter(InscritoEvento inscritoEvento) {
		
		var inscrito = inscritoEvento.getInscrito();
		var inevDAO = new InscritoEventoDAO();
		inevDAO.setMatricula(inscritoEvento.getId());
		inevDAO.setNome(inscrito.getNome());
		inevDAO.setCpf(inscrito.getCpf());
		inevDAO.setEmail(inscrito.getEmail());
		inevDAO.setTelefone(inscrito.getTelefone());
		
		return inevDAO;
		
	}
	
	public static List<InscritoEventoDAO> converter(List<InscritoEvento> inscritos) {

		List<InscritoEventoDAO> convertidos = new ArrayList<>();

		for (InscritoEvento inscrito : inscritos) {
			convertidos.add(InscritoEventoDAO.converter(inscrito));
		}
		return convertidos;
	}
}
