package com.icarocavalcanti.institutoeducacional.model.usuarios.externos;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public abstract class Associado extends Inscrito {

	private LocalDateTime dataDeAssociacao;
	
	@Enumerated(EnumType.STRING)
	private EstadoDaAssiciacao estadoDaAssociacao;
	
	private void expirarAsssociao() {}
	
}
