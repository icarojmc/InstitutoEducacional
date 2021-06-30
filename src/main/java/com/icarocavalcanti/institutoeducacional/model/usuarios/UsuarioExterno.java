package com.icarocavalcanti.institutoeducacional.model.usuarios;

import java.util.List;

import javax.persistence.Entity;

import com.icarocavalcanti.institutoeducacional.model.ProfessorEvento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public abstract class UsuarioExterno extends Usuario {

	private String cpf;
	private long telefone;
	private String endereco;
	
}
