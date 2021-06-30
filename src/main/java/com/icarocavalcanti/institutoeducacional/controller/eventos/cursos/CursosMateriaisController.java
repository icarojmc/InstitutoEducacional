package com.icarocavalcanti.institutoeducacional.controller.eventos.cursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icarocavalcanti.institutoeducacional.dto.eventos.MaterialDTO;
import com.icarocavalcanti.institutoeducacional.model.eventos.Material;
import com.icarocavalcanti.institutoeducacional.repository.eventos.CursoRepository;
import com.icarocavalcanti.institutoeducacional.repository.eventos.MaterialRepository;

@RestController
@RequestMapping("/cursos/{id}/materiais")
public class CursosMateriaisController {

	@Autowired
	MaterialRepository materialRepository;
	
	@Autowired
	CursoRepository cursoRepository;
	
	@GetMapping
	public ResponseEntity<List<Material>> listarMateriais(@PathVariable long id){
		
		var curso = cursoRepository.findById(id);
		
		if(curso.isPresent()) {
			
			return ResponseEntity.ok(curso.get().getMaterial());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<List<Material>> criarMaterial(@PathVariable long id, @RequestBody MaterialDTO materialDTO) {
		
		var curso = cursoRepository.findById(id);
		if(curso.isPresent()) {
			var cursoDTO = curso.get();
			cursoDTO.getMaterial().add(materialRepository.save(materialDTO.toMaterial()));
			cursoRepository.save(cursoDTO);
			return ResponseEntity.ok(cursoDTO.getMaterial());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{aid}")
	public ResponseEntity<Material> detalharMaterial(@PathVariable long id, @PathVariable long aid){
		
		var curso = cursoRepository.findById(id);
		var material = materialRepository.findById(aid);
		
		if(curso.isPresent() && material.isPresent()) {
			
			return ResponseEntity.ok(material.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping("/{aid}")
	public ResponseEntity<?> deletarMaterial(@PathVariable long id, @PathVariable long aid){
		
		var curso = cursoRepository.findById(id);
		var material = materialRepository.findById(aid);
		if(curso.isPresent() && material.isPresent()) {
			
			var cursoDTO = curso.get();
			cursoDTO.getMaterial().remove(material.get());
			cursoRepository.save(cursoDTO);
			materialRepository.delete(material.get());
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
