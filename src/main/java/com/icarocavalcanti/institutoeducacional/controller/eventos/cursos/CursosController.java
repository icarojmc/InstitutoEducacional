package com.icarocavalcanti.institutoeducacional.controller.eventos.cursos;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.icarocavalcanti.institutoeducacional.dao.eventos.CursoDAO;
import com.icarocavalcanti.institutoeducacional.dto.eventos.cursos.AtualizacaoCursoDTO;
import com.icarocavalcanti.institutoeducacional.dto.eventos.cursos.ExclusaoCursoDTO;
import com.icarocavalcanti.institutoeducacional.dto.eventos.cursos.NovoCursoDTO;
import com.icarocavalcanti.institutoeducacional.model.eventos.Curso;
import com.icarocavalcanti.institutoeducacional.repository.eventos.CursoRepository;

@RestController
@RequestMapping("cursos")
public class CursosController {

	@Autowired
	CursoRepository cursoRepository;
	
	@GetMapping
	@Cacheable(value = "listaDeCursos")
	public List<CursoDAO> listarCursos() {
		
		return CursoDAO.buscarCursos(cursoRepository);
	}
	
	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDeCursos", allEntries = true)
	public ResponseEntity<CursoDAO> criarCurso(@RequestBody NovoCursoDTO novoCurso, UriComponentsBuilder uriBuilder) {
		
		
		Curso curso = novoCurso.toCurso(cursoRepository);
		URI uri = uriBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();
		return ResponseEntity.created(uri).body(CursoDAO.converter(curso));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CursoDAO> detalhar(@PathVariable long id) {
		
		Optional<Curso> curso = cursoRepository.findById(id);
		
		if(curso.isPresent()) {
			return ResponseEntity.ok(CursoDAO.converter(curso.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeCursos", allEntries = true)
	public ResponseEntity<CursoDAO> atualizar(@PathVariable long id, @RequestBody AtualizacaoCursoDTO atualizado, UriComponentsBuilder uriBuilder){
		
		Optional<Curso> curso = cursoRepository.findById(id);
		
		if(curso.isPresent()) {
			return ResponseEntity.ok(
					CursoDAO.converter(
							cursoRepository.save(
									atualizado.atualizarCurso(
											curso.get()
											)
									)
							)
					);
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable long id) {
		
		ExclusaoCursoDTO.deleta(cursoRepository, id);
		return ResponseEntity.ok().build();
	}
	
	
}
