package com.icarocavalcanti.institutoeducacional.controller.eventos.cursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icarocavalcanti.institutoeducacional.dao.eventos.InscritoEventoDAO;
import com.icarocavalcanti.institutoeducacional.model.InscritoEvento;
import com.icarocavalcanti.institutoeducacional.repository.eventos.CursoRepository;
import com.icarocavalcanti.institutoeducacional.repository.usuarios.InscritoEventoRepository;
import com.icarocavalcanti.institutoeducacional.repository.usuarios.InscritosRepository;

@RestController
@RequestMapping("/cursos/{id}/inscritos")
public class CursosInscritosController {

	@Autowired
	CursoRepository cursoRepository;
	
	@Autowired
	InscritosRepository inscritoRepository;
	
	@Autowired
	InscritoEventoRepository inevRepository;
	
	@GetMapping
	public ResponseEntity<List<InscritoEventoDAO>> listarInscritos(@PathVariable long id){
		
		var curso = cursoRepository.findById(id);
		
		if(curso.isPresent()) return ResponseEntity.ok(InscritoEventoDAO.converter(curso.get().getInscritos()));
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/{aid}")
	public ResponseEntity<InscritoEventoDAO> vincularInscrito(@PathVariable long id, @PathVariable long aid){
		var curso = cursoRepository.findById(id);
		var inscrito = inscritoRepository.findById(aid);
		if(curso.isPresent() && inscrito.isPresent()) {
			var inev = new InscritoEvento();
			inev.setEvento(curso.get());
			inev.setInscrito(inscrito.get());
			return ResponseEntity.ok(InscritoEventoDAO.converter(inevRepository.save(inev)));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{aid}")
	public ResponseEntity<InscritoEventoDAO> desvincularInscrito(@PathVariable long id, @PathVariable long aid){
		
		var inev = inevRepository.findById(aid);
		if(inev.isPresent()) {
			inevRepository.deleteById(aid);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
