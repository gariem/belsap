package com.myorg.controller;

import com.myorg.DataLoader;
import com.myorg.service.MensajeService;
import com.myorg.service.TwilioService;
import com.twilio.Twilio;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;


@RestController
@RequestMapping(path = "/api/messages")
public class MessageController {

    public static final String ACCOUNT_SID = "AC6fb6b605dfdaa34584cc995069382573";
    public static final String AUTH_TOKEN = "096a2b3f5c5e933cae33c46410f74cdc";

    @Autowired
    MensajeService service;

    @Autowired
    TwilioService twilioService;

    @RequestMapping(path = "/daily", method = RequestMethod.GET)
    public String daily() {
        service.sendMessageDiario(DataLoader.INICIAR_DIARIO, "all");
        return "OK: " + new Date().toString();
    }

    @RequestMapping(path = "/dailyvideo", method = RequestMethod.GET)
    public String dailyVideo() {
        service.sendMessageDiario(DataLoader.DIARIO_VIDEO, "all");

        return "OK: " + new Date().toString();
    }

    @RequestMapping(path = "/pregunta", method = RequestMethod.GET)
    public String pregunta() {
        service.sendMessageDiario(DataLoader.PREGUNTA, "all");

        return "OK: " + new Date().toString();
    }

    @RequestMapping(path = "/final", method = RequestMethod.GET)
    public String finalWe() {
        service.sendMessageDiario(DataLoader.FINAL, "all");

        return "OK: " + new Date().toString();
    }

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String test() {
        twilioService.sendMessage("+14155238886", "+51955179518", "Mensaje de prueba: " + new Date().toString());
        return "Fecha: " + new Date().toString();
    }
    @RequestMapping(path = "/images", method = RequestMethod.GET)
    public String images() {
        twilioService.sendImage("+14155238886", "+51955179518","https://cdn1-marcas.belcorp.biz/pe/wp-content/uploads/sites/11/2019/02/Conoce-el-mundo-con-la-Nueva-Fragancia-Mia-de-Esika-1.jpg" );
        return "Fecha: " + new Date().toString();
    }

    @RequestMapping(path = "/receive", method = RequestMethod.POST)
    public void reply(HttpServletRequest request, HttpServletResponse response) {

        String body = request.getParameter("Body");
        String from = request.getParameter("From");

        String respuesta = service.findRespuesta(body, from);

        respuesta = new String(respuesta.getBytes(UTF_8), ISO_8859_1);

        MessagingResponse twiml = twilioService.response(respuesta);

        response.setContentType("application/xml");

        try {
            response.getWriter().print(twiml.toXml());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

