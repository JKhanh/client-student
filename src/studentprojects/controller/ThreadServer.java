/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentprojects.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
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
public class ThreadServer implements Runnable {

    private ArrayList<Student> listResult = new ArrayList<>();
    MainDao mainDao = new MainDao();
    private ServerSocket myServer;
    private int port = 4567;
    ObjectInputStream ois = null;
    ObjectOutputStream oos = null;
    Socket clientSocket;

    public ThreadServer() {

    }

    @Override
    public void run() {
        while (true) {
            try {
                try {
                    myServer = new ServerSocket(port);
                } catch (IOException ex) {
                    Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
                }
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        clientSocket = myServer.accept();
                        System.out.println(clientSocket.getRemoteSocketAddress());
                        ServerControl sc = new ServerControl(clientSocket);
                        new Thread(sc).start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
//                Socket clientSocket = myServer.accept();
//                System.out.println("123");
//                ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
//                System.out.println("1");
//                ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
//                System.out.println("2");
//                System.out.println("333");
//                Object o = ois.readObject();
//                System.out.println("222");
//                if (o instanceof Message) {
//                    Message mesSend = new Message();
//                    Message mesReceive = (Message) o;
//                    System.out.println(mesReceive);
//                    if (mesReceive.getType() == Type.ADD_STUDENT) {
//                        boolean isSuccess = mainDao.addStudent((Student) mesReceive.getContent());
//                        mesSend = new Message(isSuccess, Type.ADD_STUDENT);
//                    } else if (mesReceive.getType() == Type.SEARCH_STUDENT_BY_NAME) {
//                        listResult = mainDao.searchStudentByName(mesReceive.getContent().toString());
//                        mesSend = new Message(listResult, Type.RETURN_SEARCH);
//                    } else if (mesReceive.getType() == Type.SEARCH_STUDENT_BY_YEAR) {
//                        listResult = mainDao.searchStudentByYear(Integer.parseInt(mesReceive.getContent().toString()));
//                        mesSend = new Message(listResult, Type.RETURN_SEARCH);
//                    }
//
//                    oos.writeObject(mesSend);
//                }

                Thread.sleep(100);
                clientSocket.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
}
