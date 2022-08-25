/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alan
 */
public class ConexaoDAO {

    private String caminho = "jdbc:postgresql://localhost:5432/";
    private String usuario = "postgres";
    private String senha = "unifunec";
    private Connection con = null;
    private String bancoPrincipal = "estoque";

    public Connection conectaPostgre() {
        try {
            Class.forName("org.postgresql.Driver");

            try {
                con = DriverManager.getConnection(caminho + bancoPrincipal, usuario, senha);
                //JOptionPane.showMessageDialog(null,"Conectado com Sucesso!!!");
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
           // System.out.println("Driver não encontrada.");
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
