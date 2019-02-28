package com.myorg.service;

import com.myorg.model.ReglaMensaje;
import com.myorg.repository.ReglaMensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DefaultMensajeService implements MensajesService {

    private ReglaMensajeRepository repository;

    public DefaultMensajeService() {

    }

    @Autowired
    public DefaultMensajeService(ReglaMensajeRepository repository) {
        this.repository = repository;
    }

    @Override
    public String findRespuesta(String pregunta) {
        String respuesta = "No te entiendo!";
        List<ReglaMensaje> posiblesRespuestas = repository.findByPregunta(pregunta);

        if (!posiblesRespuestas.isEmpty()) {
            ReglaMensaje regla = posiblesRespuestas.get(0);

            /*Se deben poner estas inferencias en otro lado*/
            if (regla.getRespuesta().contains("{1}")) {
                if (regla.getPregunta().contains("hora")) {
                    respuesta = regla.getRespuesta().replace("{1}", new Date().toString());
                }
            } else {
                respuesta = regla.getRespuesta();
            }
        }
        return respuesta;
    }
}
