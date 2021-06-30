package com.icarocavalcanti.institutoeducacional.dto.usuarios;

import com.icarocavalcanti.institutoeducacional.model.usuarios.externos.Professor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizacaoProfessorDTO {

	private String nome;
	private String email;
	private String senha;
	private String cpf;
	private String telefone;
	private String endereco;
	private String curriculo;
	private String tipoDeVinculo;
	
	public Professor atualizarProfessor(Professor professor) {
		professor.setNome(nome);
		professor.setEmail(email);
		professor.setSenha(senha);
		professor.setCpf(cpf);
		professor.setTelefone(Long.parseLong(telefone));
		professor.setEndereco(endereco);
		professor.setCurriculo(curriculo);
		professor.setTipoDeVinculoString(tipoDeVinculo);
		
		return professor;
	}
}
