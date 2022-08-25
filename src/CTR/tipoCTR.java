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
        tipoModel objtipo = new tipoModel();
        //Envia por meio de SET o valor de nome
   
        objtipo.setTipo(tipo_produto);

        
        //Declara objeto da DAO
        tipoDAO objdao = new tipoDAO();
        //Utiliza método insere e parametro MODEL
        objdao.inseretipo(objtipo);
                
    }
 
       public void AlteramarcaCTR(String tipo,int id_tipo)
    {
        // Cria um objeto da MODEL
       tipoModel objtipo = new tipoModel();
        //Envia por meio de SET o valor de nome
        objtipo.setTipo(tipo);
          objtipo.setCod_tipo(id_tipo);
       
   

        //Declara objeto da DAO
        tipoDAO objdao = new tipoDAO();
        //Utiliza método insere e parametro MODEL
        objdao.Alteramarca(objtipo);
    }
  
     
    
      public void ExcluimarcaCTR(int id_tipo)
     {
         tipoModel objtipo = new tipoModel();
         
         
         objtipo.setCod_tipo(id_tipo);
         
         tipoDAO objdao = new tipoDAO();
         objdao.Excluirmarca(objtipo);
     }
       
       
    public ResultSet PesquisartipoCTR(String nome)
    {
        tipoDAO objfunc = new tipoDAO();
        
        return objfunc.Pesquisartipo(nome);
    }
       
}

