/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imac.ferramentas.model;

/**
 *
 * @author @andre_ments
 */
public class Ferramentas {

    private int codFerramenta;
    private String codigoFerramenta;
    private String nomeFerramenta;
    private String descriFerramenta;
    private String tempCaliFerramenta;

    public Ferramentas() {
    }

    public Ferramentas(int codFerramenta, String codigoFerramenta, String nomeFerramenta, String descriFerramenta, String tempCaliFerramenta) {

    }

    public int getCodFerramenta() {
        return codFerramenta;
    }

    public void setCodFerramenta(int codFerramenta) {
        this.codFerramenta = codFerramenta;
    }

    public String getCodigoFerramenta() {
        return codigoFerramenta;
    }

    public void setCodigoFerramenta(String codigoFerramenta) {
        this.codigoFerramenta = codigoFerramenta;
    }

    public String getNomeFerramenta() {
        return nomeFerramenta;
    }

    public void setNomeFerramenta(String nomeFerramenta) {
        this.nomeFerramenta = nomeFerramenta;
    }

    public String getDescriFerramenta() {
        return descriFerramenta;
    }

    public void setDescriFerramenta(String descriFerramenta) {
        this.descriFerramenta = descriFerramenta;
    }

    public String getTempCaliFerramenta() {
        return tempCaliFerramenta;
    }

    public void setTempCaliFerramenta(String tempCaliFerramenta) {
        this.tempCaliFerramenta = tempCaliFerramenta;
    }

    @Override
    public String toString() {
        return "Ferramentas{" + "codFerramenta=" + codFerramenta + ", codigoFerramenta=" + codigoFerramenta + ", nomeFerramenta=" + nomeFerramenta + ", descriFerramenta=" + descriFerramenta + ", tempCaliFerramenta=" + tempCaliFerramenta + '}';
    }

}
