/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 503
 */
public class Message {
    private static final long serialVersionUID = 6529685098267757690L;
    private Object object;
    private MessageType messageType;

    public Message(Object object, MessageType messageType) {
        this.object = object;
        this.messageType = messageType;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }
    
}
