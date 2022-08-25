/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CTR;

import Dao.TelefoneTipoDAO;
import Model.TelefoneTipomodel;
import java.sql.ResultSet;

/**
 *
 * @author alang
 */
public class TelefoneTipoCTR {
     public void InseretelCTR(String tipos)
    {
        // Cria um objeto da MODEL
        TelefoneTipomodel objtipos = new TelefoneTipomodel();
        //Envia por meio de SET o valor de nome
   
        objtipos.setNometipotel(tipos);

        
        //Declara objeto da DAO
        TelefoneTipoDAO objdao = new TelefoneTipoDAO();
        //Utiliza método insere e parametro MODEL
        objdao.inseretipotel(objtipos);
                
    }
         public void AlteratelCTR(String tipos,int id_tipos)
    {
        // Cria um objeto da MODEL
        TelefoneTipomodel objrua = new TelefoneTipomodel();
        //Envia por meio de SET o valor de nome
        objrua.setNometipotel(tipos);
          objrua.setCodtipotel(id_tipos);
       
   

        //Declara objeto da DAO
        TelefoneTipoDAO objdao = new  TelefoneTipoDAO();
        //Utiliza método insere e parametro MODEL
        objdao.Alteratipotel(objrua);
    }
  
     
    
      public void ExcluitelCTR(int id_tipos)
     {
        TelefoneTipomodel objfunc = new TelefoneTipomodel();
         
         
         objfunc.setCodtipotel(id_tipos);
         
         TelefoneTipoDAO objdao = new TelefoneTipoDAO();
         objdao.Excluitipotel(objfunc);
     }
    
    
  /*/  public ResultSet PesquisarmarcaCTR(String marca)
    {
        marca_DAO objfunc = new marca_DAO();
         marca_model objmarca = new marca_model();
        
        objmarca.setMarca_produto(marca);
        
        return objfunc.Pesquisarmarca(objmarca);
    } 

       /*/
       
       
    public ResultSet PesquisartelCTR(String tipos)
    {
        TelefoneTipoDAO objfunc = new TelefoneTipoDAO();
        
        return objfunc.Pesquisartipotel(tipos);
        
    }
}
