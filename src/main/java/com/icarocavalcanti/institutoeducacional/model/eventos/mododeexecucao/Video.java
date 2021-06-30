package com.icarocavalcanti.institutoeducacional.model.eventos.mododeexecucao;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "video")
public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String video;
	private String descricao;
	private LocalTime duracao;
	private String link;
	
}
