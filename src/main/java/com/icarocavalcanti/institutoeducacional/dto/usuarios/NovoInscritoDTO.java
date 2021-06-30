package com.icarocavalcanti.institutoeducacional.dto.usuarios;

import java.time.LocalDateTime;

import com.icarocavalcanti.institutoeducacional.model.usuarios.externos.Inscrito;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NovoInscritoDTO {

	private String nome;
	private String email;
	private String senha;
	private String cpf;
	private long telefone;
	private String endereco;
	
	public Inscrito toInscrito() {
		
		var inscrito = new Inscrito();
		
		inscrito.setNome(nome);
		inscrito.setEmail(email);
		inscrito.setSenha(senha);
		inscrito.setCpf(cpf);
		inscrito.setTelefone(telefone);
		inscrito.setEndereco(endereco);
		inscrito.setDataDeInscricao(LocalDateTime.now());
		
		return inscrito;
	}
}
