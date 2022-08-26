/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CTR;

import Dao.TelefoneDAO;
import Model.telefoneModel;
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
    public List<telefoneModel> ListatelefoneBD(int fk_codtipotel) {
        List<telefoneModel> acliente = new ArrayList<>();
        TelefoneDAO objdao = new TelefoneDAO();
        ResultSet rstelefone = objdao.listatelefone(fk_codtipotel);

        try {
            while (rstelefone.next()) {
                telefoneModel gs = new telefoneModel();
                gs.setFk_codtipotel(rstelefone.getInt(fk_codtipotel));
                

                acliente.add(gs);
            }
            return acliente;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteCTR.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void InseretelefoneCTR(String telefone,int id_tipotel)
    {
        // Cria um objeto da MODEL
        telefoneModel objtelefone = new telefoneModel();
        //Envia por meio de SET o valor de nome
        objtelefone.setNumerotel(telefone);
        objtelefone.setFk_codtipotel(id_tipotel);

        
        //Declara objeto da DAO
        TelefoneDAO objdao = new TelefoneDAO();
        //Utiliza método insere e parametro MODEL
        objdao.inseretelefone(objtelefone);
                
    }
}
