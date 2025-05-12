package com.sec02.Bridge;
public class UserMessage extends Message {
    public UserMessage(MessageSender sender) {
        super(sender);
    }
    public void send(String text) {
        sender.send("User: " + text);
    }
}
