package com.robinfood.bussiness;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.robinfood.model.Encuesta;
import com.robinfood.repository.EncuestaRepository;

@Service
public class EncuestaBussiness implements IEncuestaBussiness {

	@Autowired
	private EncuestaRepository encuestaRepository;
	
	public List<Encuesta> obtenerEncuestas(){
		
		List<Encuesta> listaEncuesta = (List<Encuesta>) encuestaRepository.findAll();
		return listaEncuesta;
	}
}