package com.robinfood.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.robinfood.model.Encuesta;

@Repository
public interface EncuestaRepository extends CrudRepository<Encuesta, Integer>  {

}