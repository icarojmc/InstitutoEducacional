package com.icarocavalcanti.institutoeducacional.model.usuarios.externos;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "F")
public class PessoaFisica extends Associado {

	private BigDecimal valorDaAssociacao;
	
	public void cancelarAssociacao() {}
	
	public void renovarAssociacao() {}
}
