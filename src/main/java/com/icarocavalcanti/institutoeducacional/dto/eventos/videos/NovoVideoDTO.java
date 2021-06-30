package com.icarocavalcanti.institutoeducacional.dto.eventos.videos;

import java.time.LocalTime;

import com.icarocavalcanti.institutoeducacional.model.eventos.mododeexecucao.Video;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NovoVideoDTO {

	private String titulo;
	private String descricao;
	private int horas;
	private int minutos;
	private int segundos;
	private String link;
	
	
	public Video toVideo() {
		var video = new Video();
		video.setVideo(titulo);
		video.setDescricao(descricao);
		video.setDuracao(LocalTime.of(horas, minutos, segundos));
		video.setLink(link);
		
		return video;
	}
}
