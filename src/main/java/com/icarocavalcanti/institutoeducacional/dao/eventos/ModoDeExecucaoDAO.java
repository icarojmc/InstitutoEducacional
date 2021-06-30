package com.icarocavalcanti.institutoeducacional.dao.eventos;

import com.icarocavalcanti.institutoeducacional.model.eventos.mododeexecucao.ModoDeExecucao;
import com.icarocavalcanti.institutoeducacional.model.eventos.mododeexecucao.Presencial;
import com.icarocavalcanti.institutoeducacional.model.eventos.mododeexecucao.Virtual;

public class ModoDeExecucaoDAO {
	
	public static ModoDeExecucaoDAO converter(ModoDeExecucao modoDeExecucao) {
		
		switch (modoDeExecucao.getTipo()) {
		case "V":
			return VirtualDAO.converter((Virtual) modoDeExecucao);
		case "P":
			return PresencialDAO.converter((Presencial) modoDeExecucao);
		default:
			return null;
		}
		
		
		
		
	}
}
