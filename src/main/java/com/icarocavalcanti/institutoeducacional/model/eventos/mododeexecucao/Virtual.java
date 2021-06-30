package com.icarocavalcanti.institutoeducacional.model.eventos.mododeexecucao;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "V")
public class Virtual extends ModoDeExecucao {

	private String link;
	
	@OneToMany
	private List<Video> videos;
}
