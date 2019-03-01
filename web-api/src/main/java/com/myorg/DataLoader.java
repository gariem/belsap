package com.myorg;

import com.myorg.model.Contact;
import com.myorg.model.ReglaMensaje;
import com.myorg.repository.ContactRepository;
import com.myorg.repository.ReglaMensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    public static final String INICIAR_DIARIO = "iniciar_diario";
    //public static final String DIARIO = "diario";
    public static final String DIARIO_VIDEO = "diario_video";
    public static final String RESPUESTA = "respuesta";


    @Autowired
    ReglaMensajeRepository reglasRepository;

    @Autowired
    ContactRepository contactRepository;

    @Override
    public void run(String... args) {

        ReglaMensaje regla1 = new ReglaMensaje(1, RESPUESTA, "Hola", "Hola. Como estas?");
        ReglaMensaje regla2 = new ReglaMensaje(2, RESPUESTA, "Que hora es", "Son las #hora#");

        ReglaMensaje regla3 = new ReglaMensaje(3, INICIAR_DIARIO, "", "¡Hola #nombre#! ¡Tenemos un reto para ti esta semana! Como bien sabes en esta campaña tendremos un festival de fragancias para lo cual hemos preparado una actividad para ti! Durante toda la semana recibirás videos de 1 minuto dónde te mostraremos los mejores tips de ventas para nuestros perfumes. Al final de la semana se te enviará un pequeño cuestionario, que si lo respondes correctamente, recibirás una gran sorpresa. ¿Estás lista?");

        ReglaMensaje regla4 = new ReglaMensaje(4, RESPUESTA, "¡Hola! Sí, estoy lista.", "Entonces empezamos!");
        ReglaMensaje regla5 = new ReglaMensaje(5, RESPUESTA, "No estoy lista.", "No hay problema! Estaremos aqui cuando lo estes!");
        ReglaMensaje regla6 = new ReglaMensaje(6, RESPUESTA, "Ya estoy lista.", "Entonces empezamos!");

        ReglaMensaje regla7 = new ReglaMensaje(7, DIARIO_VIDEO, "Mira el video del día", "https://drive.google.com/open?id=1m2xFukKDdHn3zVg6AYpbQbaA_lRXJX5M");

        reglasRepository.save(regla1);
        reglasRepository.save(regla2);
        reglasRepository.save(regla3);
        reglasRepository.save(regla4);
        reglasRepository.save(regla5);
        reglasRepository.save(regla6);
        reglasRepository.save(regla7);


        Contact contact1 = new Contact(1, "+51955179518", "Emilio", "human");
        Contact contact2 = new Contact(2, "+51944400610", "Karolayn", "human");
        Contact contact3 = new Contact(3, "+51922223780", "Aleksandra", "admin");

        contactRepository.save(contact1);
        contactRepository.save(contact2);
        contactRepository.save(contact3);


    }
}
