package com.icarocavalcanti.institutoeducacional.controller.usuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icarocavalcanti.institutoeducacional.dao.usuarios.AdministradorDAO;
import com.icarocavalcanti.institutoeducacional.dto.usuarios.AtualizacaoAdministradorDTO;
import com.icarocavalcanti.institutoeducacional.dto.usuarios.NovoAdministradorDTO;
import com.icarocavalcanti.institutoeducacional.repository.usuarios.AdministradorRepository;


@RestController
@RequestMapping("/administradores")
public class AdministradorController {

	@Autowired
	AdministradorRepository administradorRepository;
	
	@GetMapping
	public List<AdministradorDAO> listarAdministradores(){
		
		return AdministradorDAO.converter(administradorRepository.findAll());
	}
	
	@PostMapping
	public AdministradorDAO criarAdministrador(@RequestBody NovoAdministradorDTO novoAdministradorDTO) {
		
		return AdministradorDAO.converter(administradorRepository.save(novoAdministradorDTO.toAdministrador()));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AdministradorDAO> detalharAdministrador(@PathVariable long id) {
		
		var administrador = administradorRepository.findById(id);
		if(administrador.isPresent()) {
			return ResponseEntity.ok(AdministradorDAO.converter(administrador.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AdministradorDAO> editarAdministrador(@PathVariable long id, @RequestBody AtualizacaoAdministradorDTO atualizacaoAdministrado){
		
		var administrador = administradorRepository.findById(id);
		
		if(administrador.isPresent()) {
			return ResponseEntity.ok(AdministradorDAO.converter(administradorRepository.save(atualizacaoAdministrado
					.atualizarAdministrador(administrador.get()))
					));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
}
