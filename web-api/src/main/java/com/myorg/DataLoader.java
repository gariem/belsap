package com.myorg;

import com.myorg.model.ReglaMensaje;
import com.myorg.repository.ReglaMensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    ReglaMensajeRepository repository;


    @Override
    public void run(String... args) {

        ReglaMensaje regla1 = new ReglaMensaje(1, "hola", "Hola. Como estas?");
        ReglaMensaje regla2 = new ReglaMensaje(2, "que hora es", "Son las {1}");


        repository.save(regla1);
        repository.save(regla2);
    }
}
