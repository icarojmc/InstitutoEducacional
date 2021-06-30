package com.icarocavalcanti.institutoeducacional.model.usuarios.externos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value = "V")
public class VinculadoAPessoaJuridica extends Associado {

	@ManyToOne
	private PessoaJuridica pessoaJuridicaVinculada;
	private boolean administrador;
	
	public void renovarAssociacaoDaPessoaJuridica() {}
	
	public void cancelarAssociacaoDaPessoaJuridica() {}
	public void editarDadosDaPessoaJuridica() {}
}
