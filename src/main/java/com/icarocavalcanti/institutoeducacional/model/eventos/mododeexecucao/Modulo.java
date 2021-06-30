package com.icarocavalcanti.institutoeducacional.model.eventos.mododeexecucao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.icarocavalcanti.institutoeducacional.model.eventos.Material;

@Entity(name = "modulo")
public class Modulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToMany
	private List<Video> videos;
	
	@OneToMany
	private List<Material> materiais;
	
	public void adicionarVideo(String v) {}
	
	public void disponibilizarVideo(String v) {}
}
