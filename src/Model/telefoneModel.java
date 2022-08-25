/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author alang
 */
public class telefoneModel {
    private int codtelefone;
    private String numerotel;
    private int fk_codtipotel;        

    /**
     * @return the codtelefone
     */
    public int getCodtelefone() {
        return codtelefone;
    }

    /**
     * @param codtelefone the codtelefone to set
     */
    public void setCodtelefone(int codtelefone) {
        this.codtelefone = codtelefone;
    }

    /**
     * @return the numerotel
     */
    public String getNumerotel() {
        return numerotel;
    }

    /**
     * @param numerotel the numerotel to set
     */
    public void setNumerotel(String numerotel) {
        this.numerotel = numerotel;
    }

    /**
     * @return the fk_codtipotel
     */
    public int getFk_codtipotel() {
        return fk_codtipotel;
    }

    /**
     * @param fk_codtipotel the fk_codtipotel to set
     */
    public void setFk_codtipotel(int fk_codtipotel) {
        this.fk_codtipotel = fk_codtipotel;
    }
}
