package com.icarocavalcanti.institutoeducacional.controller.eventos.cursos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icarocavalcanti.institutoeducacional.dao.eventos.CursoDAO;
import com.icarocavalcanti.institutoeducacional.dto.eventos.ExecucaoPresencialDTO;
import com.icarocavalcanti.institutoeducacional.dto.eventos.ExecucaoVirtualDTO;
import com.icarocavalcanti.institutoeducacional.model.eventos.mododeexecucao.Presencial;
import com.icarocavalcanti.institutoeducacional.model.eventos.mododeexecucao.Virtual;
import com.icarocavalcanti.institutoeducacional.repository.eventos.CursoRepository;
import com.icarocavalcanti.institutoeducacional.repository.eventos.PresencialRepository;
import com.icarocavalcanti.institutoeducacional.repository.eventos.VirtualRepository;

@RestController
@RequestMapping("cursos/{id}/modo")
public class CursosModoDeExecucaoController {

	@Autowired
	CursoRepository cursoRepository;

	@Autowired
	VirtualRepository exViRepository;

	@Autowired
	PresencialRepository exPrRepository;

	@PostMapping("/virtual")
	public ResponseEntity<CursoDAO> incluirModoVirtual(@PathVariable long id, @RequestBody ExecucaoVirtualDTO exViDTO) {

		var curso = cursoRepository.findById(id);

		if (curso.isPresent()) {

			CursoDAO cursoDAO = null;

			if (curso.get().getModoDeExecucao() != null) {

				var modoAnterior = curso.get().getModoDeExecucao();

				switch (modoAnterior.getTipo()) {
				case "V":
					cursoDAO = exViDTO.toExecucaoVirtual(curso.get(), cursoRepository, exViRepository);
					exViRepository.delete((Virtual) modoAnterior);
					break;
				case "P":
					cursoDAO = exViDTO.toExecucaoVirtual(curso.get(), cursoRepository, exViRepository);
					exPrRepository.delete((Presencial) modoAnterior);
					break;
				}
			} else {
				cursoDAO = exViDTO.toExecucaoVirtual(curso.get(), cursoRepository, exViRepository);
			}
			return ResponseEntity.ok(cursoDAO);
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping("/presencial")
	public ResponseEntity<CursoDAO> incluirModoPresencial(@PathVariable long id,
			@RequestBody ExecucaoPresencialDTO exPrDTO) {

		var curso = cursoRepository.findById(id);
		if (curso.isPresent()) {

			CursoDAO cursoDAO = null;

			if (curso.get().getModoDeExecucao() != null) {

				var modoAnterior = curso.get().getModoDeExecucao();

				switch (modoAnterior.getTipo()) {
				case "V":
					cursoDAO = exPrDTO.toExecucaoPresencial(curso.get(), cursoRepository, exPrRepository);
					exViRepository.delete((Virtual) modoAnterior);
					break;
				case "P":
					cursoDAO = exPrDTO.toExecucaoPresencial(curso.get(), cursoRepository, exPrRepository);
					exPrRepository.delete((Presencial) modoAnterior);
					break;
				}
			} else {
				cursoDAO = exPrDTO.toExecucaoPresencial(curso.get(), cursoRepository, exPrRepository);
			}

			return ResponseEntity.ok(cursoDAO);
		}

		return ResponseEntity.notFound().build();
	}

}
