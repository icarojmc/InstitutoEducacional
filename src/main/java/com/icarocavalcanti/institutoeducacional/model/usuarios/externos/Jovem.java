package com.icarocavalcanti.institutoeducacional.model.usuarios.externos;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "J")
public class Jovem extends PessoaFisica {

	private LocalDate dataDoDocuemnto;
	private String tipoDeProfissional;
	private String linkDoDocumento;
	
	public void incluirDocumento() {};
}
