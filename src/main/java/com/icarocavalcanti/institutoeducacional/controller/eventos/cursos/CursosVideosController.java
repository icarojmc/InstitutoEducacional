package com.icarocavalcanti.institutoeducacional.controller.eventos.cursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icarocavalcanti.institutoeducacional.dao.eventos.ModoDeExecucaoDAO;
import com.icarocavalcanti.institutoeducacional.dao.eventos.VideoDAO;
import com.icarocavalcanti.institutoeducacional.dao.eventos.VirtualDAO;
import com.icarocavalcanti.institutoeducacional.dto.eventos.videos.AtualizacaoVideoDTO;
import com.icarocavalcanti.institutoeducacional.dto.eventos.videos.NovoVideoDTO;
import com.icarocavalcanti.institutoeducacional.model.eventos.mododeexecucao.Video;
import com.icarocavalcanti.institutoeducacional.repository.eventos.VideoRepository;
import com.icarocavalcanti.institutoeducacional.repository.eventos.VirtualRepository;

@RestController
@RequestMapping("virtual/{id}/videos")
public class CursosVideosController {

	@Autowired
	VirtualRepository virtualRepository;

	@Autowired
	VideoRepository videoRepository;

	@GetMapping
	public ResponseEntity<List<Video>> listarVideos(@PathVariable long id) {
		var exVi = virtualRepository.findById(id);
		if (exVi.isPresent()) {
			return ResponseEntity.ok(exVi.get().getVideos());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<ModoDeExecucaoDAO> adicionarVideo(@PathVariable long id, @RequestBody NovoVideoDTO videoDTO) {
		var exVi = virtualRepository.findById(id);
		if (exVi.isPresent()) {
			var exViDTO = exVi.get();
			exViDTO.getVideos().add(videoRepository.save(videoDTO.toVideo()));

			return ResponseEntity.ok(VirtualDAO.converter(virtualRepository.save(exViDTO)));
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/{aid}")
	public ResponseEntity<VideoDAO> detalharVideo(@PathVariable long id, @PathVariable long aid) {
		var exVi = virtualRepository.findById(id);
		var video = videoRepository.findById(aid);
		if (exVi.isPresent() && video.isPresent()) {
			return ResponseEntity.ok(VideoDAO.converter(video.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{aid}")
	public ResponseEntity<VideoDAO> editarVideo(@PathVariable long id, @PathVariable long aid,
			@RequestBody AtualizacaoVideoDTO videoDTO) {
		var exVi = virtualRepository.findById(id);
		var video = videoRepository.findById(aid);
		if (exVi.isPresent() && video.isPresent()) {
			return ResponseEntity.ok(VideoDAO.converter(videoRepository.save(videoDTO.toVideo(video.get()))));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{aid}")
	public ResponseEntity<?> deletarVideo(@PathVariable long id, @PathVariable long aid) {

		var exVi = virtualRepository.findById(id);
		var video = videoRepository.findById(aid);
		if (exVi.isPresent() && video.isPresent()) {

			var exViDTO = exVi.get();
			exViDTO.getVideos().remove(video.get());
			virtualRepository.save(exViDTO);
			videoRepository.delete(video.get());

			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();

	}

}
