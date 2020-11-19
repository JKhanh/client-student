package rmiproject.controller;

import rmiproject.model.Room;
import rmiproject.model.User;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;

public class LoginController extends UnicastRemoteObject implements LoginInterface  {
    private int serverPort = 1080;
    private Registry registry;
    private Connection con;
    private String rmiService = "rmiRoomServer";

    public LoginController() throws RemoteException {
        getDBConnection("tblroom", "root", "phong611");
        try{
            registry = LocateRegistry.createRegistry(serverPort);
            registry.rebind(rmiService, this);
        }catch(RemoteException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public boolean checkLogin(User user) throws RemoteException {
        return checkUser(user);
    }

    @Override
    public boolean addRoom(Room room) throws RemoteException {
        String query = "INSERT INTO room (name, price, description) VALUES (?, ?, ?)";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, room.getName());
            ps.setInt(2, room.getPrice());
            ps.setString(3, room.getDescription());
            int result = ps.executeUpdate();
            return result != -1;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList<Room> searchRoom(String name) throws RemoteException, SQLException {
        ArrayList<Room> result = new ArrayList<>();
        String query = "SELECT * FROM room WHERE name LIKE ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Room room = new Room(rs.getString("name"), rs.getInt("price"), rs.getString("description"));
            result.add(room);
        }
        return result;
    }

    private void getDBConnection(String dbName, String username,
                                 String password){
        String dbUrl = "jdbc:mysql://localhost:3306/" + dbName;
        String dbClass = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(dbClass);
            con = DriverManager.getConnection (
                    dbUrl, username, password);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    private boolean checkUser(User user) {
        String query = "Select * FROM users WHERE username = ? AND password = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                return true;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
