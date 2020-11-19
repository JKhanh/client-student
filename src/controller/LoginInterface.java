/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiproject;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import rmiproject.model.Room;
import rmiproject.model.User;

/**
 *
 * @author 503
 */
public interface LoginInterface extends Remote {
    public boolean checkLogin(User user) throws RemoteException;
    public boolean addRoom(Room room) throws RemoteException;
    public ArrayList<Room> searchRoom(String name) throws RemoteException, SQLException;
}
