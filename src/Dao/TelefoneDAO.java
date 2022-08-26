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
   public void inseretelefone(telefoneModel gs)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
        
        String sql = "insert into Telefone"
                + "(numerotel)"
                + "(fk_codtipotel)"
                + " values (upper(?)upper(?))";
        
        try {
            pgsql = con.prepareStatement(sql);
            //pgsql.setInt(1, gs.getCod_marca_produto());
            pgsql.setString(1, gs.getNumerotel());
            pgsql.setInt(2, gs.getFk_codtipotel());
            
            pgsql.executeUpdate();
            JOptionPane.showMessageDialog(null, "telefone foi  Cadastrado com Sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(BairroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
    }

