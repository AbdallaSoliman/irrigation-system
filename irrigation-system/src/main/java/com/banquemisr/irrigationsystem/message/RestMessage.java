package com.banquemisr.irrigationsystem.message;


import com.banquemisr.irrigationsystem.message.constant.*;
import lombok.*;

import java.util.*;

@Getter
@AllArgsConstructor
public class RestMessage {
    private String header;
    private MessageType messageType;
    private List<String> messages;

    public RestMessage(List<String> messages) {
        this.messages = messages;
    }


    public RestMessage(String header, MessageType messageType) {
        this.header = header;
        this.messageType = messageType;
    }

    @Override
    public String toString() {
        return "{" +
                "\"header\":\"" + header + "\""+
                ", \"messages\":" + messages +
                "}";
    }
}