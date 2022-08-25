/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CTR;

import Dao.EstadoDAO;
import Model.EstadoModel;
import java.sql.ResultSet;

/**
 *
 * @author alang
 */
public class EstadoCTR {
     public void InsereestadoCTR(String estado)
    {
        // Cria um objeto da MODEL
        EstadoModel objestado = new EstadoModel();
        //Envia por meio de SET o valor de nome
   
        objestado.setNomeestado(estado);

        
        //Declara objeto da DAO
        EstadoDAO objdao = new EstadoDAO();
        //Utiliza método insere e parametro MODEL
        objdao.insereestado(objestado);
                
    }
         public void AlteraestadoCTR(String estado,int id_estado)
    {
        // Cria um objeto da MODEL
        EstadoModel objmarca = new EstadoModel();
        //Envia por meio de SET o valor de nome
        objmarca.setNomeestado(estado);
          objmarca.setCod_estado(id_estado);
       
   

        //Declara objeto da DAO
        EstadoDAO objdao = new  EstadoDAO();
        //Utiliza método insere e parametro MODEL
        objdao.Alterestado(objmarca);
    }
  
     
    
      public void ExcluiestadoCTR(int id_estado)
     {
        EstadoModel objfunc = new EstadoModel();
         
         
         objfunc.setCod_estado(id_estado);
         
         EstadoDAO objdao = new EstadoDAO();
         objdao.Excluirestado(objfunc);
     }
    
    
  /*/  public ResultSet PesquisarmarcaCTR(String marca)
    {
        marca_DAO objfunc = new marca_DAO();
         marca_model objmarca = new marca_model();
        
        objmarca.setMarca_produto(marca);
        
        return objfunc.Pesquisarmarca(objmarca);
    } 

       /*/
       
       
    public ResultSet PesquisarestadoCTR(String nome)
    {
        EstadoDAO objfunc = new EstadoDAO();
        
        return objfunc.Pesquisarestado(nome);
        
    }
}
