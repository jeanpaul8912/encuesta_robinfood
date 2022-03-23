package com.robinfood.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.*;
import com.robinfood.bussiness.IEncuestaBussiness;
import com.robinfood.model.Encuesta;

@RestController
public class EncuestaRest {
	
	@Autowired
	private IEncuestaBussiness encuestaBussiness;

	@SuppressWarnings("rawtypes")
	@GetMapping("/encuesta")
	public ResponseEntity obtenerEncuesta() {
		
		ResponseEntity responseEntity;
		
		try {
			List<Encuesta> listaEncuestas = encuestaBussiness.obtenerEncuestas();	
			responseEntity = ResponseEntity.ok().body(listaEncuestas);
		} catch (Exception exception) {
			responseEntity = HelperRest.createErrorEntity(HttpStatus.BAD_REQUEST, exception.getMessage());
		}
		
		return responseEntity;
	}
}