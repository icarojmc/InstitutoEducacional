package com.icarocavalcanti.institutoeducacional.model.usuarios.externos;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "quantidadedevinculados")
public class QuantidadeDeVinculados {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int quantidade;
	private BigDecimal valor;
	
		
}
