/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import Model.bairroModel;
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
public class BairroDAO {
    Connection con;
    PreparedStatement pgsql;
    Statement st;
    ResultSet rs;
    
    public void inserebairro(bairroModel gs)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
        
        String sql = "insert into bairro"
                + "(bairro)"
                + " values (?)";
        
        try {
            pgsql = con.prepareStatement(sql);
            //pgsql.setInt(1, gs.getCod_marca_produto());
            pgsql.setString(1, gs.getBairros());

            
            pgsql.executeUpdate();
            JOptionPane.showMessageDialog(null, "Bairro foi  Cadastrado com Sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(marca_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public void AlteraFuncionario(bairroModel gs)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
        
        String sql = "update bairro set "
                + "bairro = ?";
        
        try {
            pgsql = con.prepareStatement(sql);
            pgsql.setString(1, gs.getBairros());

            
            pgsql.executeUpdate();
            JOptionPane.showMessageDialog(null, "A Bairro foi alterado com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(marca_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    
  public void Excluirmarca(bairroModel gs)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
        
        String sql = "delete from bairro where"
                + " codbairro = ?";
        
        try {
            pgsql = con.prepareStatement(sql);
            pgsql.setInt(1, gs.getCodbairro());
            pgsql.executeUpdate();
            JOptionPane.showMessageDialog(null, "bairro foi Excluído com Sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(marca_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     public ResultSet Pesquisarbairro(String bairro)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
       
        
        String sql = "select * from bairro where "
                + "upper(bairro) like upper(?)";
        
        try {
            pgsql = con.prepareStatement(sql);
            pgsql.setString(1,"%" + bairro + "%");
            
            st = con.createStatement(ResultSet.CONCUR_UPDATABLE,
                                     ResultSet.TYPE_SCROLL_INSENSITIVE);
            
            rs = st.executeQuery(pgsql.toString());
            
        } catch (SQLException ex) {
            Logger.getLogger(marca_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
        
    }
    
    
    
}


