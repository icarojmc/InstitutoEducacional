package com.icarocavalcanti.institutoeducacional.model.usuarios.externos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "pessoajuridica")
public class PessoaJuridica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long cnpj;
	
	@ManyToOne
	private QuantidadeDeVinculados numeroDeAssociados;
	
	@OneToMany(mappedBy = "pessoaJuridicaVinculada")
	private List<VinculadoAPessoaJuridica> vinculados;
	
}
