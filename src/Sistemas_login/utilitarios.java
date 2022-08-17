/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistemas_login;


import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author alang
 */
public class utilitarios {
    
     public void inserirIcone(JFrame frm){
        try {
            
            frm.setIconImage(Toolkit.getDefaultToolkit().getImage("src/img/logo.png"));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
      
}
