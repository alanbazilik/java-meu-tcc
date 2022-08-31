/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import CTR.UsuarioCTR;
import Model.UsuarioMODEL;
import View.Tela_principal;
import View.UsuarioLoginVIEW;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static sun.security.jgss.GSSUtil.login;

/**
 *
 * @author Codinhoto
 */
public class UsuarioDAO {

    Connection con;
    PreparedStatement pgsql;
    Statement st;
 
    public void cadastrarUsuario(UsuarioMODEL gs)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
        
        String sql = "insert into usuario"
                + "(nome_user,email,telefone,senha_user) "
                + "values(?,?,?,?)";
        
        try {
            pgsql = con.prepareStatement(sql);
            pgsql.setString(1, gs.getNome_usuario());
            pgsql.setString(2, gs.getEmail());
              pgsql.setString(3, gs.getTelefone());
            pgsql.setString(4, gs.getSenha_usuario());
            
            pgsql.executeUpdate();
            
            JOptionPane.showMessageDialog
                        (null, "Usuário Cadastrado!");
  
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
    }
    public boolean loginUsuario(UsuarioMODEL gs)
    {
        ConexaoDAO cb = new ConexaoDAO();
         con = cb.conectaPostgre();
         
        boolean status;
        ResultSet rs;
        String sql = "select * from usuario"
                + " where nome_user = ?"
                + "and senha_user = ?";
        
        try {
            pgsql = con.prepareStatement(sql);
             pgsql.setString(1, gs.getNome_usuario());
               pgsql.setString(2, gs.getSenha_usuario());
            rs = pgsql.executeQuery();
            if(rs.next()){
      Tela_principal objtel = new Tela_principal();
      objtel.setVisible(true);
      
  
      
               return status = true;
            }
            else{
  JOptionPane.showMessageDialog(null,"login incorreto","incorreto", JOptionPane.ERROR_MESSAGE);
  Tela_principal objtel = new Tela_principal();
      objtel.setVisible(false);
             return status = false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
               return status = false;
        }
        }
       public boolean recuperar(UsuarioMODEL gs) throws NoSuchAlgorithmException
    {
        ConexaoDAO cb = new ConexaoDAO();
         con = cb.conectaPostgre();
         
        boolean status;
        ResultSet rs;
        String sql = "select * from usuario"
                + " where email = ?"
                + "and telefone = ?";
         
        
        try {
            pgsql = con.prepareStatement(sql);
             pgsql.setString(1, gs.getEmail());
             pgsql.setString(2, gs.getTelefone());
                  
            
              
            rs = pgsql.executeQuery();
            if(rs.next()){
  JOptionPane.showMessageDialog(null,"codigo ir na tela senha","Aviso", JOptionPane.INFORMATION_MESSAGE);
    JOptionPane.showMessageDialog(null,"seu codigo: " + rs.getString("senha_user"));
                
                
      UsuarioLoginVIEW objtel1 = new UsuarioLoginVIEW();
      objtel1.setVisible(true);
      
  
      
               return status = true;
            }
            else{
  JOptionPane.showMessageDialog(null,"não tem nem uma senha registrada","Aviso", JOptionPane.ERROR_MESSAGE);
  Tela_principal objtel = new Tela_principal();
      objtel.setVisible(false);
             return status = false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
               return status = false;
        }
    }   
    
    

         
}
