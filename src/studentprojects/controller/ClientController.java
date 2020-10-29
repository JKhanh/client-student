/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentprojects.controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import studentprojects.model.Message;
import studentprojects.model.Student;

/**
 *
 * @author 503
 */
public class ClientController {

    private Socket mSocket;
    private String host = "10.170.46.182";
    private int serverPort = 4567;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public ClientController() {
        System.out.println("111");
    }

    public Socket openConnection() {
        System.out.println("222");
        try {
            mSocket = new Socket(host, serverPort);
            oos = new ObjectOutputStream(mSocket.getOutputStream());
            ois = new ObjectInputStream(mSocket.getInputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return mSocket;
    }

    public void sendData(Message message) {
        try {
            oos.writeObject(message);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Object recieveData() {
        try {
            Object data = ois.readObject();
            if (data instanceof Message) {
                Message message = (Message) data;
                switch (message.getType()) {
                    case RETURN_SEARCH:
                        ArrayList<Student> result = new ArrayList();
                        result.addAll((ArrayList<Student>) message.getContent());
                        return result;
                    case ADD_STUDENT:
                        return message.getContent();
                }
            }
//            oos.close();
//            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void closeConnection() {
        try {
            oos.close();
            ois.close();
            mSocket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
