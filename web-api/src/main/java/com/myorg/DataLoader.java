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
    public static final String PREGUNTA = "diario";
    public static final String DIARIO_VIDEO = "diario_video";
    public static final String RESPUESTA = "respuesta";
    public static final String FINAL = "respuesta";


    @Autowired
    ReglaMensajeRepository reglasRepository;

    @Autowired
    ContactRepository contactRepository;

    @Override
    public void run(String... args) {

        ReglaMensaje regla1 = new ReglaMensaje(1, RESPUESTA, "Hola", "Hola. Como estas?");
        ReglaMensaje regla2 = new ReglaMensaje(2, RESPUESTA, "Que hora es", "Son las #hora#");

        ReglaMensaje regla3 = new ReglaMensaje(3, INICIAR_DIARIO, "", "¡Hola #nombre#! ¡Tenemos un festival de perfumes esta semana! Y hemos preparado un reto para ti! \uD83D\uDCAA \uD83D\uDCAA Durante toda la semana recibirás videos \uD83D\uDCF9 de 1 minuto dónde te mostraremos los mejores tips de ventas \uD83D\uDCA1 para nuestros perfumes. En el transcurso de la semana te enviaremos preguntas ❓ y si las respondes correctamente, al final de la misma te daremos gran sorpresa!!! ✌\uD83C\uDF89\uD83D\uDE0A ¿Estás lista?");

        ReglaMensaje regla4 = new ReglaMensaje(4, RESPUESTA, "¡Hola! Sí, estoy lista.", "Entonces empezamos!");
        ReglaMensaje regla5 = new ReglaMensaje(5, RESPUESTA, "No estoy lista.", "No hay problema! Estaremos aqui cuando lo estes!");
        ReglaMensaje regla6 = new ReglaMensaje(6, RESPUESTA, "Ya estoy lista.", "Entonces empezamos!");

        ReglaMensaje regla7 = new ReglaMensaje(7, DIARIO_VIDEO, "Mira el video de hoy día: https://youtu.be/tRg-O4afcQc", "");
        ReglaMensaje regla8 = new ReglaMensaje(9, PREGUNTA,"Después de haber visto los videos esta semana. ¿Estás lista para empezar con las preguntas? \n" +
                "\n" +
                "¿Cual de las opciones mostradas es el perfume que tiene una duración y concentración muy alta? Escribe el número de la alternativa elegida.\n" +
                "1. Colonias de Uso Diario \n" +
                "2. Eau de Parfum \n" +
                "3. Parfum \n" +
                "4. Elixires o Esencias", "");
        ReglaMensaje regla9 = new ReglaMensaje(8, RESPUESTA, "3", "Muy bien!\nParfum tiene una duración y concentración muy alta.");
        ReglaMensaje regla10 = new ReglaMensaje(10, FINAL, "Final de la semana: Felicitaciones! Has logrado superar este reto!! Por ello, alguien muy especial para nosotros tiene algo que decirte!!", "https://youtu.be/kECZZIltRIw");

        ReglaMensaje regla11 = new ReglaMensaje(11, RESPUESTA, "Hola","Hola Fran! ¿En qué puedo ayudarte?");
        ReglaMensaje regla12 = new ReglaMensaje(12, RESPUESTA, "Cuales son los lanzamientos?","Para esta campaña tenemos el lanzamiento del perfume Mía! \nEs una fragancia floral y moderna con notas de Pimienta Rosa y Gardenia Dorada de Africa \nSu esencia es ideal para una mujer independiente, con mucho estilo, dispuesta a arriesgarse y a disfrutar la vida! A continuacion te adjunto un pequeño video para que puedas compartir con tus clientes. https://youtu.be/tRg-O4afcQc");
        ReglaMensaje regla13 = new ReglaMensaje(13, RESPUESTA, "Gracias!","Para ayudarte a impulsar esta venta, te explicaremos en 1 minuto lo que necesitas saber sobre nuestros perfumes en el siguiente video. ¿Necesitas alguna ayuda adicional? https://youtu.be/aZ-yKmDFKs0");
        ReglaMensaje regla14 = new ReglaMensaje(14, RESPUESTA, "Si, me gustaria pedir el perfume Mia","Ok, para realizar el pedido puedes ingresar aquí (link a detalle de producto). Recuerda que tambien puedes compartir este producto y otros con tus clientes a traves de tu catalogo virtual)");
        ReglaMensaje regla15 = new ReglaMensaje(15, RESPUESTA, "Gracias!","Necesitas alguna ayuda adicional?");
        ReglaMensaje regla16 = new ReglaMensaje(16, RESPUESTA, "No","Bien, gracias por contactarnos. Recuerda que cada consulta que realices por el chat Esika te guía te dará puntaje para ganar un reconocimiento y serás felicitado por el influencer del momento.");

        ReglaMensaje regla18 = new ReglaMensaje(18, RESPUESTA, "¿A que edad se puede usar la Concentré?","La crema Concentré se puede utilizar a partir de los 30 años, te envío un flyer descriptivo para que lo veas y compartas con tus clientes. Si deseas mayor información puedes ingresar aquí https://www.somosbelcorp.com/BusquedaProductos?q=mia.");
        ReglaMensaje regla19 = new ReglaMensaje(19, RESPUESTA, "Gracias! ¿Cuánto cuesta?","La Concentré te cuesta S/. 777 y tienes una promoción que viene con un maletín a S/. 50. Para realizar el pedido puedes ingresar aquí (link a detalle de producto)");
        //ReglaMensaje regla20 = new ReglaMensaje(20, RESPUESTA, "Gracias!","¿Necesitas alguna ayuda adicional?");
        ReglaMensaje regla21 = new ReglaMensaje(21, RESPUESTA, "No","Bien, gracias por contactarnos. Recuerda que cada consulta que realices por el chat Esika te guía te dará puntaje para ganar un reconocimiento y serás felicitado por el influencer del momento.");

        //reglasRepository.save(regla1);
        reglasRepository.save(regla2);
        reglasRepository.save(regla3);
        reglasRepository.save(regla4);
        reglasRepository.save(regla5);
        reglasRepository.save(regla6);
        reglasRepository.save(regla7);
        reglasRepository.save(regla8);
        reglasRepository.save(regla9);
        reglasRepository.save(regla10);
        reglasRepository.save(regla11);
        reglasRepository.save(regla12);
        reglasRepository.save(regla13);
        reglasRepository.save(regla14);
        reglasRepository.save(regla15);
        reglasRepository.save(regla16);
        reglasRepository.save(regla18);
        reglasRepository.save(regla19);
        //reglasRepository.save(regla20);
        reglasRepository.save(regla21);

        Contact contact1 = new Contact(1, "+51955179518", "Fran", "human");
        Contact contact2 = new Contact(2, "+51944400610", "Karolayn", "human");
        Contact contact3 = new Contact(3, "+51922223780", "Aleksandra", "admin");

        contactRepository.save(contact1);
        //contactRepository.save(contact2);
        //contactRepository.save(contact3);


    }
}
