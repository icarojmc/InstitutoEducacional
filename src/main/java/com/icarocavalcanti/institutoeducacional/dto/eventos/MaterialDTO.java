package com.icarocavalcanti.institutoeducacional.dto.eventos;

import java.time.LocalDateTime;

import com.icarocavalcanti.institutoeducacional.model.eventos.Material;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaterialDTO {

	private String titulo;
	private String descricao;
	private String link;
	
	public Material toMaterial() {
		 var material = new Material();
		 
		 material.setTitulo(titulo);
		 material.setDescricao(descricao);
		 material.setLink(link);
		 material.setDataDaInsclusao(LocalDateTime.now());
		 
		 return material;
	}
}
