/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTR;

import Dao.tipoDAO;
import Model.tipoModel;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class tipoCTR {
     public void InseremarcaCTR(String tipo_produto)
    {
        // Cria um objeto da MODEL
        tipoModel objmarca = new tipoModel();
        //Envia por meio de SET o valor de nome
   
        objmarca.setTipo(tipo_produto);

        
        //Declara objeto da DAO
        tipoDAO objdao = new tipoDAO();
        //Utiliza método insere e parametro MODEL
        objdao.inseretipo(objmarca);
                
    }
    /*   public void AlteramarcaCTR(String marca)
    {
        // Cria um objeto da MODEL
        tipoModel objmarca = new tipoModel();
        //Envia por meio de SET o valor de nome
        objmarca.setMarca_produto(marca);

        //Declara objeto da DAO
        marca_DAO objdao = new marca_DAO();
        //Utiliza método insere e parametro MODEL
        objdao.AlteraFuncionario(objmarca);
    }
  
     
    
      public void ExcluimarcaCTR(int id_marca)
     {
         tipoModel objfunc = new tipoModel();
         
         objfunc.setCod_marca_produto(id_marca);
         
         marca_DAO objdao = new marca_DAO();
         objdao.Excluirmarca(objfunc);
     }
    
    
    
    
  /*  public ResultSet PesquisarmarcaCTR(String marca)
    {
        marca_DAO objfunc = new marca_DAO();
         marca_model objmarca = new marca_model();
        
        objmarca.setMarca_produto(marca);
        
        return objfunc.Pesquisarmarca(objmarca);
    } 

       */
       
       
    public ResultSet PesquisartipoCTR(String nome)
    {
        tipoDAO objfunc = new tipoDAO();
        
        return objfunc.Pesquisartipo(nome);
    }
       
}

