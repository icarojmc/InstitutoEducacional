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

import com.icarocavalcanti.institutoeducacional.dao.eventos.PalestraDAO;
import com.icarocavalcanti.institutoeducacional.dto.eventos.palestras.AtualizacaoPalestraDTO;
import com.icarocavalcanti.institutoeducacional.dto.eventos.palestras.NovaPalestraDTO;
import com.icarocavalcanti.institutoeducacional.repository.eventos.PalestraRepository;

@RestController
@RequestMapping("/palestras")
public class PalestrasController {

	@Autowired
	PalestraRepository palestraRepository;

	@GetMapping
	public List<PalestraDAO> listarPalestras() {

		return PalestraDAO.converter(palestraRepository.findAll());
	}

	@PostMapping()
	public PalestraDAO criarPalestra(@RequestBody NovaPalestraDTO novaPalestra) {
		
		return PalestraDAO.converter(palestraRepository.save(novaPalestra.toPalestra()));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PalestraDAO> detalharPalestra(@PathVariable long id) {

		var palestra = palestraRepository.findById(id);

		if (palestra.isPresent()) {

			return ResponseEntity.ok(PalestraDAO.converter(palestra.get()));
		}

		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PalestraDAO> editarPalestra(@PathVariable long id, @RequestBody AtualizacaoPalestraDTO atualizacaoPalestra){
		
		var palestra = palestraRepository.findById(id);
		if(palestra.isPresent()) {
			return ResponseEntity.ok(PalestraDAO.converter(palestraRepository.save(atualizacaoPalestra.atualizarPalestra(palestra.get()))));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarPalestra(@PathVariable long id){
		
		palestraRepository.deleteById(id);
		
		return ResponseEntity.ok().build();
	}

}
