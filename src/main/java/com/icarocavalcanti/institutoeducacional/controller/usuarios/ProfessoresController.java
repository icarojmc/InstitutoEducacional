package com.icarocavalcanti.institutoeducacional.controller.usuarios;

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

import com.icarocavalcanti.institutoeducacional.dao.usuarios.ProfessorDAO;
import com.icarocavalcanti.institutoeducacional.dto.usuarios.AtualizacaoProfessorDTO;
import com.icarocavalcanti.institutoeducacional.dto.usuarios.NovoProfessorDTO;
import com.icarocavalcanti.institutoeducacional.model.usuarios.externos.Professor;
import com.icarocavalcanti.institutoeducacional.repository.usuarios.ProfessorRepository;

@RestController
@RequestMapping("/professores")
public class ProfessoresController {

	@Autowired
	ProfessorRepository professorRepository;
	
	@GetMapping
	public List<ProfessorDAO> listarProfessores(){
		
		return ProfessorDAO.converter(professorRepository.findAll());
	}
	
	@PostMapping
	public Professor criarProfessor(@RequestBody NovoProfessorDTO novoProfessor) {
		
		return professorRepository.save(novoProfessor.toProfessor());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProfessorDAO> detalharProfessor(@PathVariable long id) {
		
		var professor = professorRepository.findById(id);
		
		if(professor.isPresent()) {
			return ResponseEntity.ok(ProfessorDAO.converter(professor.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProfessorDAO> editarProfessor(@PathVariable long id, @RequestBody AtualizacaoProfessorDTO atualizacaoProfessor) {
		
		var professor = professorRepository.findById(id);
		
		if(professor.isPresent()) {
			return ResponseEntity.ok(ProfessorDAO.converter(professorRepository.save(atualizacaoProfessor.atualizarProfessor(professor.get()))));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Professor> deletarProfessor(@PathVariable long id){
		
		professorRepository.deleteById(id);
		
		return ResponseEntity.ok().build();
	}
}
