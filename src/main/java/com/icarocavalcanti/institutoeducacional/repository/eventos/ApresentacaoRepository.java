package com.icarocavalcanti.institutoeducacional.repository.eventos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icarocavalcanti.institutoeducacional.model.eventos.Apresentacao;

@Repository
public interface ApresentacaoRepository extends JpaRepository<Apresentacao, Long> {

}
