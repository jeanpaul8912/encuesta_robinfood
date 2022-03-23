package com.robinfood.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.robinfood.model.EncuestaResultado;

@Repository
public interface EncuestaResultadoRepository extends CrudRepository<EncuestaResultado, Integer> {

}