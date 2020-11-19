package rmiproject;

import java.rmi.RemoteException;

public class ServerRun {
    public static void main(String[] args) throws RemoteException {
        RmiServerView view = new RmiServerView();
    }
}
