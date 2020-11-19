/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import rmiproject.model.User;

/**
 *
 * @author 503
 */
public class LoginControl {
    private LoginFrm loginFrm;
    private ClientControl clientControl;
    public LoginControl(LoginFrm loginFrm, ClientControl clientControl){
        this.loginFrm = loginFrm;
        this.loginFrm.setVisible(true);
        this.clientControl = clientControl;
        this.loginFrm.setAction(new BtnLoginListener());
    }
    class BtnLoginListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           User user = loginFrm.getUser();
           boolean isLoginSuccess = clientControl.checkLogin(user);
           if(isLoginSuccess){
               loginFrm.showMessage("Login Success");
           }
           else{
               loginFrm.showMessage("Login Fail");
           }
        }
        
    }
}
