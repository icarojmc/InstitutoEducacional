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

import com.icarocavalcanti.institutoeducacional.dao.usuarios.InscritoDAO;
import com.icarocavalcanti.institutoeducacional.dto.usuarios.AtualizacaoInscritoDTO;
import com.icarocavalcanti.institutoeducacional.dto.usuarios.NovoInscritoDTO;
import com.icarocavalcanti.institutoeducacional.repository.usuarios.InscritosRepository;

@RestController
@RequestMapping("/inscritos")
public class InscritosController {

	@Autowired
	InscritosRepository inscritosRepository;
	
	@GetMapping
	public List<InscritoDAO> listarInscritos(){
		return InscritoDAO.converter(inscritosRepository.findAll());
	}
	
	@PostMapping
	public InscritoDAO criarInscrito(@RequestBody NovoInscritoDTO novoInscritoDTO) {
		return InscritoDAO.converter(inscritosRepository.save(novoInscritoDTO.toInscrito()));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<InscritoDAO> detalharInscrito(@PathVariable long id) {
		
		var inscrito = inscritosRepository.findById(id);
		if(inscrito.isPresent()) {
			return ResponseEntity.ok(InscritoDAO.converter(inscrito.get()));
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<InscritoDAO> editarInscrito(@PathVariable long id, @RequestBody AtualizacaoInscritoDTO atualizacaoInscritoDTO){
		var inscrito = inscritosRepository.findById(id);
		if(inscrito.isPresent()) {
			return ResponseEntity.ok(InscritoDAO.converter(inscritosRepository.save(atualizacaoInscritoDTO.atualizarInscrito(inscrito.get()))));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirInscrito(@PathVariable long id){
		inscritosRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
