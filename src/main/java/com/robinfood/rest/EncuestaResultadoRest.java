package com.robinfood.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.*;
import com.robinfood.bussiness.IEncuestaResultadoBussiness;
import com.robinfood.model.EncuestaResultado;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class EncuestaResultadoRest {
	
	@Autowired
	private IEncuestaResultadoBussiness encuestaResultadoBussiness;

	@SuppressWarnings("rawtypes")
	@PostMapping("/encuestaresultado")
	public ResponseEntity obtenerEncuesta(@RequestBody EncuestaResultado encuestaResultado) {
		
		ResponseEntity responseEntity;
		
		try {
			encuestaResultadoBussiness.crearEncuestaResultado(encuestaResultado);	
			responseEntity = ResponseEntity.ok().build();
		} catch (Exception exception) {
			responseEntity = HelperRest.createErrorEntity(HttpStatus.BAD_REQUEST, exception.getMessage());
		}
		
		return responseEntity;
	}
}