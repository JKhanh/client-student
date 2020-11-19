package rmiproject;

import rmiproject.controller.LoginController;

import java.rmi.RemoteException;

public class RmiServerView {
    public RmiServerView() throws RemoteException {
        new LoginController();
        showMessage("RMI server is running...");
    }

    private void showMessage(String s) {
        System.out.println(s);
    }
}
