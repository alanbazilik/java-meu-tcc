/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.RuaModel;
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
public class RuaDAO {
     Connection con;
    PreparedStatement pgsql;
    Statement st;
    ResultSet rs;
    public void insereRua(RuaModel gs)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
        
        String sql = "insert into Rua"
                + "(nomerua)"
                + " values (upper(?))";
        
        try {
            pgsql = con.prepareStatement(sql);
            //pgsql.setInt(1, gs.getCod_marca_produto());
            pgsql.setString(1, gs.getNomerua());

            
            pgsql.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rua foi  Cadastrado com Sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(RuaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
 public void AlteraRua(RuaModel gs)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
        
        String sql = "UPDATE Rua SET "
                + "nomerua = ? "
                + "WHERE codrua = ?";
        
        try {
            pgsql = con.prepareStatement(sql);
            pgsql.setString(1, gs.getNomerua());
            pgsql.setInt(2, gs.getCodrua());
            
            int rowsUpdated = pgsql.executeUpdate();
            if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(null, "A rua foi alterado com sucesso");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RuaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    
  public void Excluirua(RuaModel gs)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
        
        String sql ="delete from Rua where"
                + " codrua = ?";
        
        try {
            pgsql = con.prepareStatement(sql);
            pgsql.setInt(1, gs.getCodrua());
            pgsql.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rua foi Excluído com Sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(RuaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     public ResultSet PesquisarRua(String rua)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
       
        
        String sql = "select * from Rua where "
                + "upper(nomerua) like upper(?)";
        
        try {
            pgsql = con.prepareStatement(sql);
            pgsql.setString(1,"%" + rua + "%");
            
            st = con.createStatement(ResultSet.CONCUR_UPDATABLE,
                                     ResultSet.TYPE_SCROLL_INSENSITIVE);
            
            rs = st.executeQuery(pgsql.toString());
            
        } catch (SQLException ex) {
            Logger.getLogger(RuaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
        
    }
    
    
    
}


