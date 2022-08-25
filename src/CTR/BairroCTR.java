/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CTR;
import Dao.BairroDAO;
import Model.bairroModel;
import java.sql.ResultSet;
/**
 *
 * @author alang
 */
public class BairroCTR {
     public void InserebairroCTR(String Bairro)
    {
        // Cria um objeto da MODEL
        bairroModel objbairro = new bairroModel();
        //Envia por meio de SET o valor de nome
   
        objbairro.setBairros(Bairro);

        
        //Declara objeto da DAO
        BairroDAO objdao = new BairroDAO();
        //Utiliza método insere e parametro MODEL
        objdao.inserebairro(objbairro);
                
    }
         public void AlterabairroCTR(String bairro,int id_bairro)
    {
        // Cria um objeto da MODEL
        bairroModel objmarca = new bairroModel();
        //Envia por meio de SET o valor de nome
        objmarca.setBairros(bairro);
          objmarca.setCodbairro(id_bairro);
       
   

        //Declara objeto da DAO
        BairroDAO objdao = new  BairroDAO();
        //Utiliza método insere e parametro MODEL
        objdao.Alterabairro(objmarca);
    }
  
     
    
      public void ExcluiBairroCTR(int id_bairro)
     {
        bairroModel objfunc = new bairroModel();
         
         
         objfunc.setCodbairro(id_bairro);
         
         BairroDAO objdao = new BairroDAO();
         objdao.Excluirbairro(objfunc);
     }
    
    
  /*/  public ResultSet PesquisarmarcaCTR(String marca)
    {
        marca_DAO objfunc = new marca_DAO();
         marca_model objmarca = new marca_model();
        
        objmarca.setMarca_produto(marca);
        
        return objfunc.Pesquisarmarca(objmarca);
    } 

       /*/
       
       
    public ResultSet PesquisarbairroCTR(String nome)
    {
        BairroDAO objfunc = new BairroDAO();
        
        return objfunc.Pesquisarbairro(nome);
    }
       
}


