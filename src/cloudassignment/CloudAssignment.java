/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudassignment;

import java.util.HashMap;
import javax.swing.JFrame;

public class CloudAssignment {

    public static void main(String[] args) {
        HashMap myhash = new HashMap();
        NewJFrame jframe = new NewJFrame(myhash);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(1000, 700);
        jframe.setVisible(true);
    }
    
}
