package com.icarocavalcanti.institutoeducacional.dao.eventos;

import java.time.LocalTime;

import com.icarocavalcanti.institutoeducacional.model.eventos.mododeexecucao.Video;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VideoDAO {

	private long id;
	private String titulo;
	private String descricao;
	private LocalTime duracao;
	private String link;
	
	public static VideoDAO converter(Video video) {
		var videoDAO = new VideoDAO();
		
		videoDAO.setId(video.getId());
		videoDAO.setTitulo(video.getVideo());
		videoDAO.setDescricao(video.getDescricao());
		videoDAO.setDuracao(video.getDuracao());
		videoDAO.setLink(video.getLink());
		return videoDAO;
		
	}
}
