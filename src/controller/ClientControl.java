/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiproject;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmiproject.model.User;

/**
 *
 * @author 503
 */
public class ClientControl {

    private String serverHost = "10.170.46.194";
    private int serverPort = 8080;
    private LoginInterface rmiServer;
    private Registry registry;
    private String rmiService = "ahihiDoCho";

    public ClientControl() {
//        try {
//            LoginInterface myServer = (LoginInterface) Naming.lookup(
//                    "rmi://localhost:4588/ahihiDoCho");
//        } catch (Exception e) {
//            System.out.println(e);
//        }
        System.setProperty("java.rmi.server.hostname", serverHost);
        try {
            registry = LocateRegistry.getRegistry(serverHost,
                    serverPort);
            System.out.println(registry);
            rmiServer = (LoginInterface) (registry.lookup(rmiService));
            System.out.println(rmiServer);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }

    public boolean checkLogin(User user) {
        boolean isLoginSuccess = false;
        try {
            isLoginSuccess = rmiServer.checkLogin(user);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isLoginSuccess;
    }

}
