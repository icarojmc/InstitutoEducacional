package com.icarocavalcanti.institutoeducacional.model.usuarios;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "A")
public class Administrador extends Usuario {

	@Enumerated(EnumType.STRING)
	private TipoDeVinculo tipoDeVinculo;
	private LocalDateTime dataDeVinculacao;
	
	public void acessarListaDeUsuarios() {}
	
	public void acessarListaDeCursos() {}
	
	public void acessarListaDePalestras() {}
}
