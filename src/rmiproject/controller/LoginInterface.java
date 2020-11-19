package rmiproject.controller;

import rmiproject.model.Room;
import rmiproject.model.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface LoginInterface extends Remote {
    public boolean checkLogin(User user) throws RemoteException;
    public boolean addRoom(Room room) throws RemoteException;
    public ArrayList<Room> searchRoom(String name) throws RemoteException, SQLException;
}
