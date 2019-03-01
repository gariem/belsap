package com.myorg.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {

    public static final String ACCOUNT_SID = "AC6fb6b605dfdaa34584cc995069382573";
    public static final String AUTH_TOKEN = "096a2b3f5c5e933cae33c46410f74cdc";


    public void sendMessage(String from, String to, String message) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message.creator(new PhoneNumber("whatsapp:" + to), new PhoneNumber("whatsapp:" + from), message).create();
    }
}
