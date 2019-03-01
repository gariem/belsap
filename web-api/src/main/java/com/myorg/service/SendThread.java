package com.myorg.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendThread implements Runnable {

    private String contact;
    private String message;

    @Override
    public void run() {

        try {
            Thread.sleep(2000);
            TwilioService service = new TwilioService();
            service.sendMessage("+14155238886", this.contact, this.message);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
