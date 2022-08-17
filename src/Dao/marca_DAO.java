/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.marca_model;
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
 * @author User
 */
public class marca_DAO {
    Connection con;
    PreparedStatement pgsql;
    Statement st;
    ResultSet rs;
    
    public void insereMarca(marca_model gs)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
        
        String sql = "insert into marca"
                + "(marca_produto)"
                + " values (?)";
        
        try {
            pgsql = con.prepareStatement(sql);
            //pgsql.setInt(1, gs.getCod_marca_produto());
            pgsql.setString(1, gs.getMarca_produto());

            
            pgsql.executeUpdate();
            JOptionPane.showMessageDialog(null, "Marca produto foi  Cadastrado com Sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(marca_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public void AlteraFuncionario(marca_model gs)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
        
        String sql = "update marca set "
                + "marca_produto = ?";
        
        try {
            pgsql = con.prepareStatement(sql);
            pgsql.setString(1, gs.getMarca_produto());

            
            pgsql.executeUpdate();
            JOptionPane.showMessageDialog(null, "A marca foi alterado com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(marca_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    
  public void Excluirmarca(marca_model gs)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
        
        String sql = "delete from marca where"
                + " cod_marca_produto = ?";
        
        try {
            pgsql = con.prepareStatement(sql);
            pgsql.setInt(1, gs.getCod_marca_produto());
            pgsql.executeUpdate();
            JOptionPane.showMessageDialog(null, "marca foi Excluído com Sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(marca_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     public ResultSet PesquisarMarca(String marca)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
       
        
        String sql = "select * from marca where "
                + "upper(marca_produto) like upper(?)";
        
        try {
            pgsql = con.prepareStatement(sql);
            pgsql.setString(1,"%" + marca + "%");
            
            st = con.createStatement(ResultSet.CONCUR_UPDATABLE,
                                     ResultSet.TYPE_SCROLL_INSENSITIVE);
            
            rs = st.executeQuery(pgsql.toString());
            
        } catch (SQLException ex) {
            Logger.getLogger(marca_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
        
    }
    
    
    
}
