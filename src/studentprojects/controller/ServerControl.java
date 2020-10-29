/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentprojects.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import studentprojects.model.Message;
import studentprojects.model.Student;
import studentprojects.model.Type;

/**
 *
 * @author 503
 */
public class ServerControl implements Runnable {

    private Socket clientSocket;
    private ArrayList<Student> listResult = new ArrayList<>();
    MainDao mainDao = new MainDao();
    ObjectInputStream ois;
    ObjectOutputStream oos;

    public ServerControl(Socket clientSocket) {
        this.clientSocket = clientSocket;
        try {
            ois = new ObjectInputStream(clientSocket.getInputStream());
            oos = new ObjectOutputStream(clientSocket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ServerControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
//                if (clientSocket.isClosed()) {
//                    ois.close();
//                    oos.close();
//                }
                Object o = ois.readObject();
                if (o instanceof Message) {
                    Message mesSend = new Message();
                    Message mesReceive = (Message) o;
                    System.out.println(mesReceive);
                    if (mesReceive.getType() == Type.ADD_STUDENT) {
                        boolean isSuccess = mainDao.addStudent((Student) mesReceive.getContent());
                        mesSend = new Message(isSuccess, Type.ADD_STUDENT);
                    } else if (mesReceive.getType() == Type.SEARCH_STUDENT_BY_NAME) {
                        listResult = mainDao.searchStudentByName(mesReceive.getContent().toString());
                        mesSend = new Message(listResult, Type.RETURN_SEARCH);
                    } else if (mesReceive.getType() == Type.SEARCH_STUDENT_BY_YEAR) {
                        listResult = mainDao.searchStudentByYear(Integer.parseInt(mesReceive.getContent().toString()));
                        mesSend = new Message(listResult, Type.RETURN_SEARCH);
                    }

                    oos.writeObject(mesSend);
                }

                Thread.sleep(100);
            }

//            clientSocket.close();
        } catch (Exception ex) {
//            ex.printStackTrace();
            try {
                ois.close();
                oos.close();
                clientSocket.close();
            } catch (IOException ex1) {
                Logger.getLogger(ServerControl.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }
    }

}
