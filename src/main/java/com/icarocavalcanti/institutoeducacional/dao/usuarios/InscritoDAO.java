package com.icarocavalcanti.institutoeducacional.dao.usuarios;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.icarocavalcanti.institutoeducacional.model.InscritoEvento;
import com.icarocavalcanti.institutoeducacional.model.eventos.Curso;
import com.icarocavalcanti.institutoeducacional.model.usuarios.externos.Inscrito;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InscritoDAO {

	private long id;
	private String nome;
	private String email;
	private String cpf;
	private long telefone;
	private String endereco;
	private LocalDateTime dataDeInscricao;
	
	public static InscritoDAO converter(Inscrito inscrito) {
		
		var inscritoDAO = new InscritoDAO();
		
		inscritoDAO.setId(inscrito.getId());
		inscritoDAO.setNome(inscrito.getNome());
		inscritoDAO.setEmail(inscrito.getEmail());
		inscritoDAO.setCpf(inscrito.getCpf());
		inscritoDAO.setTelefone(inscrito.getTelefone());
		inscritoDAO.setEndereco(inscrito.getEndereco());
		inscritoDAO.setDataDeInscricao(inscrito.getDataDeInscricao());
		
		return inscritoDAO;
	}
	
	public static List<InscritoDAO> converter(List<Inscrito> inscritos){
		List<InscritoDAO> convertidos = new ArrayList<>();
		for (Inscrito inscrito : inscritos) {	
			convertidos.add(InscritoDAO.converter(inscrito));
		}
		return convertidos;
	}

	

	
}
