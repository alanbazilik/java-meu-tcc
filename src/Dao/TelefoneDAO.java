/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.telefoneModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author alang
 */
public class TelefoneDAO {
     Connection con;
    PreparedStatement pgsql;
    Statement st;
    ResultSet rs;
    
   /* public void inseretelefone(telefoneModel gs)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
        
        String sql = "insert into bairro"
                + "(bairro)"
                + " values (upper(?))";
        
        try {
            pgsql = con.prepareStatement(sql);
            //pgsql.setInt(1, gs.getCod_marca_produto());
            pgsql.setString(1, gs.getBairros());

            
            pgsql.executeUpdate();
            JOptionPane.showMessageDialog(null, "Bairro foi  Cadastrado com Sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(BairroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        */
        
    }

