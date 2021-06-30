package com.icarocavalcanti.institutoeducacional.dto.usuarios;

import com.icarocavalcanti.institutoeducacional.model.usuarios.Administrador;
import com.icarocavalcanti.institutoeducacional.model.usuarios.TipoDeVinculo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizacaoAdministradorDTO {

	private String nome;
	private String email;
	private TipoDeVinculo tipoDeVinculo;
	
	public Administrador atualizarAdministrador(Administrador administrador) {
		
		administrador.setNome(nome);
		administrador.setEmail(email);
		administrador.setTipoDeVinculo(tipoDeVinculo);
		
		return administrador;
	}
}
