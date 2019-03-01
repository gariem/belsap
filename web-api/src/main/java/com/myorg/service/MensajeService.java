package com.myorg.service;

import com.myorg.DataLoader;
import com.myorg.model.Contact;
import com.myorg.model.ReglaMensaje;
import com.myorg.repository.ContactRepository;
import com.myorg.repository.ReglaMensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MensajeService {

    private ReglaMensajeRepository reglaRepository;
    private ContactRepository contactRepository;

    private Map contactoVideos = new HashMap<String, Integer>();

    public MensajeService() {

    }

    @Autowired
    TwilioService twilioService;

    @Autowired
    public MensajeService(ReglaMensajeRepository reglaRepository, ContactRepository contactRepository) {
        this.reglaRepository = reglaRepository;
        this.contactRepository = contactRepository;
    }


    public String findRespuesta(String pregunta, String contact) {
        String respuesta = "No te entiendo!";
        List<ReglaMensaje> posiblesRespuestas = reglaRepository.findByPregunta(pregunta);

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


    public void sendMessageDiario(String type, String from) {
        String mensaje = null;


        List<Contact> contacts = null;

        if (from == "all") {
            contacts = contactRepository.findAll();
        } else {
            contacts = contactRepository.findAllByNumber(from);
        }

        for (Contact contact : contacts) {

            if (type == DataLoader.INICIAR_DIARIO) {
                ReglaMensaje regla = reglaRepository.findFirstByTipo(type);
                mensaje = regla.getRespuesta().replace("#nombre#", contact.getName());
                twilioService.sendMessage("+14155238886", contact.getNumber(), mensaje);
            }

            if (type == DataLoader.DIARIO_VIDEO || type == DataLoader.PREGUNTA) {
                List<ReglaMensaje> reglas = reglaRepository.findAllByTipo(type);

                for (ReglaMensaje regla : reglas) {
                    if (!contactoVideos.containsKey(from + "_" + regla.getId())) {
                        //contactoVideos.put(from + "_" + regla.getId(), 1);
                        mensaje = regla.getPregunta() + "\n" + regla.getRespuesta();

                        twilioService.sendMessage("+14155238886", contact.getNumber(), mensaje);
                    }
                }
            }

        }

    }


    public void sendMedia (String from, String URL)
    {
        List<Contact> contacts = null;

        if (from == "all") {
            contacts = contactRepository.findAll();
        } else {
            contacts = contactRepository.findAllByNumber(from);
        }

        for (Contact contact : contacts) {
                        twilioService.sendImage( "+14155238886", contact.getNumber(), URL);


        }
    }

}
