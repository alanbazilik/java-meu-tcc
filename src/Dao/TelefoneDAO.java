/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.telefoneModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author alang
 */
public class TelefoneDAO {
     Connection con;
    PreparedStatement pgsql;
    Statement st;
    ResultSet rs;
    public ResultSet listatelefone(int fk_telefone)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
        
        ResultSet rs = null;
        String sql = "select * from Telefone where fk_codtipotel = ?" 
                                                        + fk_telefone;
        
        try {
            st = con.createStatement(ResultSet.CONCUR_UPDATABLE,
                    ResultSet.TYPE_SCROLL_INSENSITIVE);
            
           rs = st.executeQuery(sql);
                       
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneTipoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
        
        
    }
    
    
    
   public void Inseretelefone(telefoneModel gs)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
        
        String sql = "insert into Telefone"
                + "(numerotel ,fk_codtipotel)"
                + " values (?,?)";
        
        try {
            pgsql = con.prepareStatement(sql);
            pgsql.setString(1, gs.getNumerotel());
            pgsql.setInt(2, gs.getFk_codtipotel());
            //retornar valor está sendo inserindo
          System.out.println(""+gs.getNumerotel());
            System.out.println(""+gs.getFk_codtipotel());
            
            pgsql.executeUpdate();
            JOptionPane.showMessageDialog(null, "telefone foi  Cadastrado com Sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Alteratipotel(telefoneModel gs)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
        
        String sql = "UPDATE Telefone SET "
                + "numerotel = ?,fk_codtipotel = ?"
                + "WHERE codtelefone = ?";
        
        try {
            pgsql = con.prepareStatement(sql);
            pgsql.setString(1, gs.getNumerotel());
            pgsql.setInt(2, gs.getFk_codtipotel());
            pgsql.setInt(3, gs.getCodtelefone());
            
            System.out.println(""+gs.getNumerotel());
             System.out.println(""+gs.getFk_codtipotel());
              System.out.println(""+gs.getCodtelefone());
            
            int rowsUpdated = pgsql.executeUpdate();
            if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(null, "A Telefone foi alterado com sucesso");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneTipoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    
  public void Excluitipotel(telefoneModel gs)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
        
        String sql ="delete from Telefone where"
                + " codtelefone = ?";
        
        try {
            pgsql = con.prepareStatement(sql);
            pgsql.setInt(1, gs.getCodtelefone());
            pgsql.executeUpdate();
            JOptionPane.showMessageDialog(null, "Telefone foi Excluído com Sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneTipoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public ResultSet PesquisarTodosTelefone(String telefone)
    {
           ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
       
        
        String sql = "select * from Telefone where "
                + "upper(numerotel) like upper(?)";
        
        try {
            pgsql = con.prepareStatement(sql);
            pgsql.setString(1,"%" + telefone + "%");
            
            st = con.createStatement(ResultSet.CONCUR_UPDATABLE,
                                     ResultSet.TYPE_SCROLL_INSENSITIVE);
            
            rs = st.executeQuery(pgsql.toString());
            
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneTipoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
        
        
    }    
        
    }

