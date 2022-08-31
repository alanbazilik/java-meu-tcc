/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CTR;

import Dao.TelefoneDAO;
import Dao.TelefoneTipoDAO;
import Model.TelefoneTipomodel;
import Model.telefoneModel;
import Model.tipoModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author alang
 */
public class TelefoneCTR {
    
   public List<TelefoneTipomodel> carregaCombo() {
        List<TelefoneTipomodel> tipoTelefone = new ArrayList<>();
        TelefoneTipoDAO objdao = new TelefoneTipoDAO();
        ResultSet rstipotelefone = objdao.listaTodos();

        try {
            while (rstipotelefone.next()) {
                TelefoneTipomodel gs = new TelefoneTipomodel();
                gs.setCodtipotel(rstipotelefone.getInt("codtipotel"));
                gs.setNometipotel(rstipotelefone.getString("nometipotel"));
                

                tipoTelefone.add(gs);
            }
            return tipoTelefone;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteCTR.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void InseretelefoneCTR(String telefone,int codtipotel)
    {
        // Cria um objeto da MODEL
        telefoneModel objtelefone = new telefoneModel();
        //Envia por meio de SET o valor de nome
        objtelefone.setNumerotel(telefone);
        objtelefone.setFk_codtipotel(codtipotel);
           System.out.println(""+telefone);
           System.out.println(""+codtipotel);        
        //Declara objeto da DAO
        TelefoneDAO objdao = new TelefoneDAO();
        //Utiliza método insere e parametro MODEL
        objdao.Inseretelefone(objtelefone);
                
    }
             public void AlteratelCTR(String telefone,int fktelefone,int id_tel)
    {
        // Cria um objeto da MODEL
        telefoneModel objrua = new telefoneModel();
        //Envia por meio de SET o valor de nome
        objrua.setNumerotel(telefone);
          objrua.setFk_codtipotel(fktelefone);
       objrua.setCodtelefone(id_tel);
   

        //Declara objeto da DAO
        TelefoneDAO objdao = new  TelefoneDAO();
        //Utiliza método insere e parametro MODEL
        objdao.Alteratipotel(objrua);
    }
  
     
    
      public void ExcluitelCTR(int id_telefone)
     {
        telefoneModel objfunc = new telefoneModel();
         
         
         objfunc.setCodtelefone(id_telefone);
         
         TelefoneDAO objdao = new TelefoneDAO();
         objdao.Excluitipotel(objfunc);
     }
     public ResultSet PesquisartelCTR(String numel)
    {
        TelefoneDAO objfunc = new TelefoneDAO();
        
        return objfunc.PesquisarTodosTelefone(numel);
        
    }
}
