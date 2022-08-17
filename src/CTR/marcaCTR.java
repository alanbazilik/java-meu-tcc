/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTR;

import Dao.marca_DAO;
import Model.marca_model;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class marcaCTR {
       public void InseremarcaCTR(String marca_produto)
    {
        // Cria um objeto da MODEL
        marca_model objmarca = new marca_model();
        //Envia por meio de SET o valor de nome
   
        objmarca.setMarca_produto(marca_produto);

        
        //Declara objeto da DAO
        marca_DAO objdao = new marca_DAO();
        //Utiliza método insere e parametro MODEL
        objdao.insereMarca(objmarca);
                
    }
       public void AlteramarcaCTR(String marca)
    {
        // Cria um objeto da MODEL
        marca_model objmarca = new marca_model();
        //Envia por meio de SET o valor de nome
        objmarca.setMarca_produto(marca);

        //Declara objeto da DAO
        marca_DAO objdao = new marca_DAO();
        //Utiliza método insere e parametro MODEL
        objdao.AlteraFuncionario(objmarca);
    }
  
     
    
      public void ExcluimarcaCTR(int id_marca)
     {
         marca_model objfunc = new marca_model();
         
         objfunc.setCod_marca_produto(id_marca);
         
         marca_DAO objdao = new marca_DAO();
         objdao.Excluirmarca(objfunc);
     }
    
    
    
    
  /*/  public ResultSet PesquisarmarcaCTR(String marca)
    {
        marca_DAO objfunc = new marca_DAO();
         marca_model objmarca = new marca_model();
        
        objmarca.setMarca_produto(marca);
        
        return objfunc.Pesquisarmarca(objmarca);
    } 

       /*/
       
       
    public ResultSet PesquisarMarcaCTR(String nome)
    {
        marca_DAO objfunc = new marca_DAO();
        
        return objfunc.PesquisarMarca(nome);
    }
       
}
