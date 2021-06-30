package com.icarocavalcanti.institutoeducacional.dto.usuarios;

import com.icarocavalcanti.institutoeducacional.model.usuarios.externos.Inscrito;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizacaoInscritoDTO {

	private String nome;
	private String email;
	private String cpf;
	private long telefone;
	private String endereco;
	
	public Inscrito atualizarInscrito(Inscrito inscrito) {
		inscrito.setNome(nome);
		inscrito.setEmail(email);
		inscrito.setCpf(cpf);
		inscrito.setTelefone(telefone);
		inscrito.setEndereco(endereco);
		return inscrito;
	}
}
