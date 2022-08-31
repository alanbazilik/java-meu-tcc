/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.TelefoneTipomodel;
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
public class TelefoneTipoDAO {
   Connection con;
    PreparedStatement pgsql;
    Statement st;
    ResultSet rs;

     public ResultSet listatodos()
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
        
        ResultSet rs = null;
        String sql = "select * from Telefone";
        
        try {
            st = con.createStatement(ResultSet.CONCUR_UPDATABLE,
                    ResultSet.TYPE_SCROLL_INSENSITIVE);
            
           rs = st.executeQuery(sql);
                       
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneTipoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
        
        
    }
    public void inseretipotel(TelefoneTipomodel gs)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
        
        String sql = "insert into Tipo_Telefone"
                + "(nometipotel)"
                + " values (upper(?))";
        
        try {
            pgsql = con.prepareStatement(sql);
            //pgsql.setInt(1, gs.getCod_marca_produto());
            pgsql.setString(1, gs.getNometipotel());

            
            pgsql.executeUpdate();
            JOptionPane.showMessageDialog(null, "tipo Telefone foi  Cadastrado com Sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneTipoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
 public void Alteratipotel(TelefoneTipomodel gs)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
        
        String sql = "UPDATE Tipo_Telefone SET "
                + "nometipotel = ? "
                + "WHERE codtipotel = ?";
        
        try {
            pgsql = con.prepareStatement(sql);
            pgsql.setString(1, gs.getNometipotel());
            pgsql.setInt(2, gs.getCodtipotel());
            
            int rowsUpdated = pgsql.executeUpdate();
            if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(null, "A tipo Telefone foi alterado com sucesso");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneTipoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    
  public void Excluitipotel(TelefoneTipomodel gs)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
        
        String sql ="delete from Tipo_Telefone where"
                + " codtipotel = ?";
        
        try {
            pgsql = con.prepareStatement(sql);
            pgsql.setInt(1, gs.getCodtipotel());
            pgsql.executeUpdate();
            JOptionPane.showMessageDialog(null, "tipo Telefone foi Excluído com Sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneTipoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     public ResultSet Pesquisartipotel(String tipotelefone)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
       
        
        String sql = "select * from Tipo_Telefone where "
                + "upper(nometipotel) like upper(?)";
        
        try {
            pgsql = con.prepareStatement(sql);
            pgsql.setString(1,"%" + tipotelefone + "%");
            
            st = con.createStatement(ResultSet.CONCUR_UPDATABLE,
                                     ResultSet.TYPE_SCROLL_INSENSITIVE);
            
            rs = st.executeQuery(pgsql.toString());
            
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneTipoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
        
    }
    
     
       public ResultSet listaTodos()
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
       
        
        String sql = "select * from Tipo_Telefone";
        
        try {
                        
            st = con.createStatement(ResultSet.CONCUR_UPDATABLE,
                                     ResultSet.TYPE_SCROLL_INSENSITIVE);
            
            rs = st.executeQuery(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneTipoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
        
    }
    
    
}
