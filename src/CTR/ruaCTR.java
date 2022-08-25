/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CTR;

import Dao.RuaDAO;
import Model.RuaModel;
import java.sql.ResultSet;

/**
 *
 * @author alang
 */
public class ruaCTR {
   public void InsereruaCTR(String rua)
    {
        // Cria um objeto da MODEL
        RuaModel objrua = new RuaModel();
        //Envia por meio de SET o valor de nome
   
        objrua.setNomerua(rua);

        
        //Declara objeto da DAO
        RuaDAO objdao = new RuaDAO();
        //Utiliza método insere e parametro MODEL
        objdao.insereRua(objrua);
                
    }
         public void AlteraruaCTR(String rua,int id_rua)
    {
        // Cria um objeto da MODEL
        RuaModel objrua = new RuaModel();
        //Envia por meio de SET o valor de nome
        objrua.setNomerua(rua);
          objrua.setCodrua(id_rua);
       
   

        //Declara objeto da DAO
        RuaDAO objdao = new  RuaDAO();
        //Utiliza método insere e parametro MODEL
        objdao.AlteraRua(objrua);
    }
  
     
    
      public void ExcluiruaCTR(int id_Rua)
     {
        RuaModel objfunc = new RuaModel();
         
         
         objfunc.setCodrua(id_Rua);
         
         RuaDAO objdao = new RuaDAO();
         objdao.Excluirua(objfunc);
     }
    
    
  /*/  public ResultSet PesquisarmarcaCTR(String marca)
    {
        marca_DAO objfunc = new marca_DAO();
         marca_model objmarca = new marca_model();
        
        objmarca.setMarca_produto(marca);
        
        return objfunc.Pesquisarmarca(objmarca);
    } 

       /*/
       
       
    public ResultSet PesquisarruaCTR(String nome)
    {
        RuaDAO objfunc = new RuaDAO();
        
        return objfunc.PesquisarRua(nome);
        
    }
}
   

