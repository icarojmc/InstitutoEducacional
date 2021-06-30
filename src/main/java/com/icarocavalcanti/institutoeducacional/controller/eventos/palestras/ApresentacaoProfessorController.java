package com.icarocavalcanti.institutoeducacional.controller.eventos.palestras;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icarocavalcanti.institutoeducacional.dao.usuarios.ProfessorDAO;
import com.icarocavalcanti.institutoeducacional.repository.eventos.ApresentacaoRepository;
import com.icarocavalcanti.institutoeducacional.repository.usuarios.ProfessorEventoRepository;
import com.icarocavalcanti.institutoeducacional.repository.usuarios.ProfessorRepository;

@RestController
@RequestMapping("/apresentacoes/{id}/palestrantes")
public class ApresentacaoProfessorController {

	@Autowired
	ApresentacaoRepository apresentacaoRepository;
	
	@Autowired
	ProfessorRepository professorRepository;
	
	@Autowired
	ProfessorEventoRepository prevRepository;
	
	@GetMapping
	public ResponseEntity<ProfessorDAO> buscarPalestrante(@PathVariable long id){
		
		var apresentacao = apresentacaoRepository.findById(id);
		if(apresentacao.isPresent() && apresentacao.get().getPalestrante() != null) {
			return ResponseEntity.ok(ProfessorDAO.converter(apresentacao.get().getPalestrante().getProfessor()));
		}	
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/{aid}")
	public ResponseEntity<ProfessorDAO> incluirPalestrantes(@PathVariable long id, @PathVariable long aid){
		
		var apresentacao = apresentacaoRepository.findById(id);
		var professor = professorRepository.findById(aid);
		
		if(apresentacao.isPresent() && professor.isPresent()) {
			
			var prev = apresentacao.get().getPalestrante();
			prev.setProfessor(professor.get());
			prevRepository.save(prev);
			return ResponseEntity.ok(ProfessorDAO.converter(apresentacao.get().getPalestrante().getProfessor()));
			
		}
		return ResponseEntity.notFound().build();
	}
}
