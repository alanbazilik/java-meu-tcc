/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.tipoModel;
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
public class tipoDAO {
     Connection con;
    PreparedStatement pgsql;
    Statement st;
    ResultSet rs;
     public void inseretipo(tipoModel gs)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
        
        String sql = "insert into tipos"
                + "(tipo)"
                + " values (?)";
        
        try {
            pgsql = con.prepareStatement(sql);
            //pgsql.setInt(1, gs.getCod_marca_produto());
            pgsql.setString(1, gs.getTipo());

            
            pgsql.executeUpdate();
            JOptionPane.showMessageDialog(null, "tipo produto foi  Cadastrado com Sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(tipoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
   /* public void AlteraFuncionario(tipoModel gs)
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
 
    
  public void Excluirmarca(tipoModel gs)
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
    */
    
     public ResultSet Pesquisartipo(String tipo)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
       
        
        String sql = "select * from tipos where "
                + "upper(tipo) like upper(?)";
        
        try {
            pgsql = con.prepareStatement(sql);
            pgsql.setString(1,"%" + tipo + "%");
            
            st = con.createStatement(ResultSet.CONCUR_UPDATABLE,
                                     ResultSet.TYPE_SCROLL_INSENSITIVE);
            
            rs = st.executeQuery(pgsql.toString());
            
        } catch (SQLException ex) {
            Logger.getLogger(tipoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
        
    }
    
    
    
}


