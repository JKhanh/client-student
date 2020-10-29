
import studentprojects.controller.ThreadServer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 503
 */
public class RunClass {
    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadServer());
        thread.start();
    }
}
