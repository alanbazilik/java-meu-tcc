/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.EstadoModel;
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
public class EstadoDAO {
    Connection con;
    PreparedStatement pgsql;
    Statement st;
    ResultSet rs;
    public void insereestado(EstadoModel gs)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
        
        String sql = "insert into estado"
                + "(nome_estado)"
                + " values (upper(?))";
        
        try {
            pgsql = con.prepareStatement(sql);
            //pgsql.setInt(1, gs.getCod_marca_produto());
            pgsql.setString(1, gs.getNomeestado());

            
            pgsql.executeUpdate();
            JOptionPane.showMessageDialog(null, "estado foi  Cadastrado com Sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
 public void Alterestado(EstadoModel gs)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
        
        String sql = "UPDATE estado SET "
                + "nome_estado = ? "
                + "WHERE codestado = ?";
        
        try {
            pgsql = con.prepareStatement(sql);
            pgsql.setString(1, gs.getNomeestado());
            pgsql.setInt(2, gs.getCod_estado());
            
            int rowsUpdated = pgsql.executeUpdate();
            if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(null, "A estado foi alterado com sucesso");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    
  public void Excluirestado(EstadoModel gs)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
        
        String sql ="delete from estado where"
                + " codestado = ?";
        
        try {
            pgsql = con.prepareStatement(sql);
            pgsql.setInt(1, gs.getCod_estado());
            pgsql.executeUpdate();
            JOptionPane.showMessageDialog(null, "estado foi Excluído com Sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     public ResultSet Pesquisarestado(String estado)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
       
        
        String sql = "select * from estado where "
                + "upper(nome_estado) like upper(?)";
        
        try {
            pgsql = con.prepareStatement(sql);
            pgsql.setString(1,"%" + estado + "%");
            
            st = con.createStatement(ResultSet.CONCUR_UPDATABLE,
                                     ResultSet.TYPE_SCROLL_INSENSITIVE);
            
            rs = st.executeQuery(pgsql.toString());
            
        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
        
    }
    
    
    
}
