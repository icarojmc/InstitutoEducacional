package com.icarocavalcanti.institutoeducacional.dto.eventos.cursos;

import com.icarocavalcanti.institutoeducacional.repository.eventos.CursoRepository;

public class ExclusaoCursoDTO {

	public static void deleta(CursoRepository cursoRepository, long id) {
		
		cursoRepository.deleteById(id);
		
	}

}
