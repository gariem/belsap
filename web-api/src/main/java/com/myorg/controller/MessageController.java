package com.myorg.controller;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.TwiMLException;

@RestController
@RequestMapping(path = "/api/messages")
public class MessageController {

    public static final String ACCOUNT_SID = "AC6fb6b605dfdaa34584cc995069382573";
    public static final String AUTH_TOKEN = "096a2b3f5c5e933cae33c46410f74cdc";

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String test() {

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber("whatsapp:+51955179518"),
                new PhoneNumber("whatsapp:+14155238886"),
                "Mensaje de prueba: " + new Date().toString()).create();

        return "SID: " + message.getSid() + " Fecha: " + new Date().toString();
    }

    @RequestMapping(path = "/receive", method = RequestMethod.POST)
    public void reply(HttpServletRequest request, HttpServletResponse response){

        String body = request.getParameter("Body");
        String message = "Message";
        if (body.equals("hello")) {
            // Say hi
            message = "Hi there!";
        } else if (body.equals("bye")) {
            // Say goodbye
            message = "Goodbye!";
        }

        // Create a TwiML response and add our friendly message.
        Body messageBody = new Body.Builder(message).build();
        com.twilio.twiml.messaging.Message sms = new com.twilio.twiml.messaging.Message.Builder().body(messageBody).build();
        MessagingResponse twiml = new MessagingResponse.Builder().message(sms).build();

        response.setContentType("application/xml");

        try {
            response.getWriter().print(twiml.toXml());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

