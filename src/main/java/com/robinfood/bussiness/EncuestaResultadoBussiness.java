package com.robinfood.bussiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.robinfood.model.EncuestaResultado;
import com.robinfood.repository.EncuestaResultadoRepository;

@Service
public class EncuestaResultadoBussiness implements IEncuestaResultadoBussiness  {
	
	@Autowired
	private EncuestaResultadoRepository encuestaResultadoRepository;

	@Override
	public void crearEncuestaResultado(EncuestaResultado encuestaResultado) {
		encuestaResultadoRepository.save(encuestaResultado);
	}
}