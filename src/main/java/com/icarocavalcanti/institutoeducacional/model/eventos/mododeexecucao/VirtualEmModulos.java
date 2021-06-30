package com.icarocavalcanti.institutoeducacional.model.eventos.mododeexecucao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "M")
public class VirtualEmModulos extends ModoDeExecucao {

	@OneToMany
	private List<Modulo> modulos;

	public void adicionarModulo(Modulo m) {}
	
	public void disponibilizarModulo(String m) {}
}
