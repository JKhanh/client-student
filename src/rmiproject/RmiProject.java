/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiproject;


/**
 *
 * @author 503
 */
public class RmiProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoginFrm loginFrm = new LoginFrm();
        ClientControl clientControl = new ClientControl();
        LoginControl loginControl = new LoginControl(loginFrm, clientControl);
    }
    
}
