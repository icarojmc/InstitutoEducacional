package com.icarocavalcanti.institutoeducacional.model.usuarios.externos;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.icarocavalcanti.institutoeducacional.model.InscritoEvento;
import com.icarocavalcanti.institutoeducacional.model.usuarios.UsuarioExterno;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "I")
public class Inscrito extends UsuarioExterno {

	@OneToMany(mappedBy = "inscrito")
	private List<InscritoEvento> eventos;
	
	private LocalDateTime dataDeInscricao;
	
}
