package com.myorg.repository;

import com.myorg.model.ReglaMensaje;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReglaMensajeRepository extends CrudRepository<ReglaMensaje, Integer> {

    List<ReglaMensaje> findByPregunta(String pregunta);

}
