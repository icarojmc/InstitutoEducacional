package com.icarocavalcanti.institutoeducacional.dao.usuarios;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.icarocavalcanti.institutoeducacional.model.usuarios.Administrador;
import com.icarocavalcanti.institutoeducacional.model.usuarios.TipoDeVinculo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministradorDAO {

	private long id;
	private String nome;
	private String email;
	private TipoDeVinculo tipoDeVinculo;
	private LocalDateTime dataDeVinculacao;
	
	public static AdministradorDAO converter(Administrador administrador) {
		
		var administradorDAO = new AdministradorDAO();
		administradorDAO.setId(administrador.getId());
		administradorDAO.setNome(administrador.getNome());
		administradorDAO.setEmail(administrador.getEmail());
		administradorDAO.setTipoDeVinculo(administrador.getTipoDeVinculo());
		administradorDAO.setDataDeVinculacao(administrador.getDataDeVinculacao());
		
		return administradorDAO;
		
	}
	
	public static List<AdministradorDAO> converter(List<Administrador> administradores){
		
		List<AdministradorDAO> convertidos = new ArrayList<>();
		for (Administrador administrador : administradores) {	
			convertidos.add(AdministradorDAO.converter(administrador));
		}
		return convertidos;
	}
}
