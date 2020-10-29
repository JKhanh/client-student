/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentprojects.model;

import java.io.Serializable;

/**
 *
 * @author 503
 */
public class Message implements Serializable{
    private static final long serialVersionUID = 6529685098267757690L;
    private Object content;
    private Type type;

    public Message() {
    }
    
    public Message(Object content, Type type) {
        this.content = content;
        this.type = type;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    
     
}