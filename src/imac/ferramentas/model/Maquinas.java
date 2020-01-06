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
public class Maquinas {

    private int cod;
    private String codMaquina;
    private String nomeMaquina;

    public Maquinas() {
    }

    public Maquinas(int cod, String codMaquina, String nomeMaquina) {
        this.cod = cod;
        this.codMaquina = codMaquina;
        this.nomeMaquina = nomeMaquina;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getCodMaquina() {
        return codMaquina;
    }

    public void setCodMaquina(String codMaquina) {
        this.codMaquina = codMaquina;
    }

    public String getNomeMaquina() {
        return nomeMaquina;
    }

    public void setNomeMaquina(String nomeMaquina) {
        this.nomeMaquina = nomeMaquina;
    }

    @Override
    public String toString() {
        return "Maquinas{" + "cod=" + cod + ", codMaquina=" + codMaquina + ", nomeMaquina=" + nomeMaquina + '}';
    }

}
