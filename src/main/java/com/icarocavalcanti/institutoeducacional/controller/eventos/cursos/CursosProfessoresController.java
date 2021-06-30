package com.icarocavalcanti.institutoeducacional.controller.eventos.cursos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icarocavalcanti.institutoeducacional.dao.eventos.CursoDAO;
import com.icarocavalcanti.institutoeducacional.dao.usuarios.ProfessorDAO;
import com.icarocavalcanti.institutoeducacional.repository.usuarios.ProfessorEventoRepository;
import com.icarocavalcanti.institutoeducacional.repository.usuarios.ProfessorRepository;

@RestController
@RequestMapping("cursos/{id}/professor")
public class CursosProfessoresController {
	
	@Autowired
	ProfessorRepository professorRepository;
	
	@Autowired
	ProfessorEventoRepository prevRepository;
	
	@GetMapping
	public ResponseEntity<ProfessorDAO> buscarProfessor(@PathVariable long id) {
	
		var curso = prevRepository.findByCursoId(id);
		
		if(curso.isPresent() && curso.get().getProfessor() != null) {
			return ResponseEntity.ok(ProfessorDAO.converter(curso.get().getProfessor()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/{professorid}")
	@CacheEvict(value = "listaDeCursos", allEntries = true)
	public ResponseEntity<CursoDAO> vincularProfessor(@PathVariable long id, @PathVariable long professorid){
		
		var prev = prevRepository.findByCursoId(id);
		var professor = professorRepository.findById(professorid);
		
		if(prev.isPresent() && professor.isPresent()) {
			var prevDAO = prev.get();
			prevDAO.setProfessor(professor.get());
			prevRepository.save(prevDAO);

			return ResponseEntity.ok(CursoDAO.converter(prevDAO.getCurso()));
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping
	@CacheEvict(value = "listaDeCursos", allEntries = true)
	public ResponseEntity<?> removerProfessor(@PathVariable long id){
		
		var curso = prevRepository.findByCursoId(id);
		
		if(curso.isPresent()) {
			var cursoDTO = curso.get();
			cursoDTO.setProfessor(null);
			prevRepository.save(cursoDTO);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
}
