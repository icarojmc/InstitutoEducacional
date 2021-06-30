package com.icarocavalcanti.institutoeducacional.repository.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icarocavalcanti.institutoeducacional.model.usuarios.externos.Inscrito;

@Repository
public interface InscritosRepository extends JpaRepository<Inscrito, Long> {

}
