package com.icarocavalcanti.institutoeducacional.dto.usuarios;

import java.time.LocalDateTime;

import com.icarocavalcanti.institutoeducacional.model.usuarios.Administrador;
import com.icarocavalcanti.institutoeducacional.model.usuarios.TipoDeVinculo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NovoAdministradorDTO {

	private String nome;
	private String email;
	private String senha;
	private TipoDeVinculo tipoDeVinculo;
	
	public Administrador toAdministrador() {
		
		var administrador = new Administrador();
		administrador.setNome(nome);
		administrador.setEmail(email);
		administrador.setSenha(senha);
		administrador.setTipoDeVinculo(tipoDeVinculo);
		administrador.setDataDeVinculacao(LocalDateTime.now());
		
		return administrador;
	}
}
