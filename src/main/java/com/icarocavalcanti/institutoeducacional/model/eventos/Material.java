package com.icarocavalcanti.institutoeducacional.model.eventos;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "material")
public class Material {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String titulo;
	private String descricao;
	private String link;
	private LocalDateTime dataDaInsclusao;
	
}
