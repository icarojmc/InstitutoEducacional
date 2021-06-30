package com.icarocavalcanti.institutoeducacional.controller.eventos.palestras;

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

import com.icarocavalcanti.institutoeducacional.dao.eventos.ApresentacaoDAO;
import com.icarocavalcanti.institutoeducacional.dto.eventos.palestras.AtualizacaoApresentacaoDTO;
import com.icarocavalcanti.institutoeducacional.dto.eventos.palestras.NovaApresentacaoDTO;
import com.icarocavalcanti.institutoeducacional.model.eventos.Apresentacao;
import com.icarocavalcanti.institutoeducacional.repository.eventos.ApresentacaoRepository;
import com.icarocavalcanti.institutoeducacional.repository.eventos.PalestraRepository;
import com.icarocavalcanti.institutoeducacional.repository.usuarios.ProfessorEventoRepository;

@RestController
@RequestMapping("palestras/{id}/apresentacoes")
public class ApresentacaoController {

	@Autowired
	ApresentacaoRepository apresentacaoRepository;

	@Autowired
	PalestraRepository palestraRepository;
	
	@Autowired
	ProfessorEventoRepository prevRepository;

	@GetMapping
	public ResponseEntity<List<ApresentacaoDAO>> listarApresentacoes(@PathVariable long id) {

		var palestra = palestraRepository.findById(id);

		if (palestra.isPresent()) {
			return ResponseEntity.ok(ApresentacaoDAO.converter(palestra.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<List<ApresentacaoDAO>> criarApresentacao(@PathVariable long id,
			@RequestBody NovaApresentacaoDTO novaApresentacao) {

		var palestra = palestraRepository.findById(id);

		if (palestra.isPresent()) {

			var apresentacao = novaApresentacao.toApresentacao(prevRepository, apresentacaoRepository);
			var palestraDTO = palestra.get();
			palestraDTO.getApresentacoes().add(apresentacao);

			return ResponseEntity.ok(ApresentacaoDAO.converter(palestraRepository.save(palestraDTO)));
		}

		return ResponseEntity.notFound().build();
	}

	@GetMapping("/{aid}")
	public ResponseEntity<ApresentacaoDAO> detalharApresentacao(@PathVariable long id, @PathVariable long aid) {

		var palestra = palestraRepository.findById(id);
		if (palestra.isPresent()) {
			var apresentacao = apresentacaoRepository.findById(aid);
			if (apresentacao.isPresent() && palestra.get().getApresentacoes().contains(apresentacao.get())) {
				return ResponseEntity.ok(ApresentacaoDAO.converter(apresentacao.get()));
			}
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{aid}")
	public ResponseEntity<Apresentacao> editarApresentacao(@PathVariable long id, @PathVariable long aid,
			@RequestBody AtualizacaoApresentacaoDTO atualizacaoApresentacao) {

		var palestra = palestraRepository.findById(id);
		if (palestra.isPresent()) {
			var apresentacao = apresentacaoRepository.findById(aid);
			if (apresentacao.isPresent() && palestra.get().getApresentacoes().contains(apresentacao.get())) {
				return ResponseEntity
						.ok(apresentacaoRepository.save(atualizacaoApresentacao.atualizar(apresentacao.get())));
			}
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{aid}")
	public ResponseEntity<?> deletarApresentacao(@PathVariable long id, @PathVariable long aid) {

		var palestra = palestraRepository.findById(id);
		if (palestra.isPresent()) {
			var apresentacao = apresentacaoRepository.findById(aid);
			var palestraDAO = palestra.get();
			if (apresentacao.isPresent() && palestra.get().getApresentacoes().contains(apresentacao.get())) {
				palestraDAO.getApresentacoes().remove(apresentacao.get());
				palestraRepository.save(palestraDAO);
				apresentacaoRepository.deleteById(aid);
				return ResponseEntity.ok().build();
			}
		}
		return ResponseEntity.notFound().build();
	}

}
