/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imac.ferramentas.model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author @andre_ments
 */
public class Lancamentos {

    private int cod;
    private String tipoLancamento;
    private String fr_codMaquina;
    private String fr_codFerramenta;
    private String fr_codigoProduto;
    private Date fr_dataLancamento;
    private Time fr_horaLancamento;
    private String fr_loginUsuario;

    public void AddFerramentaDao(int cod, String tipoLancamento, String fr_codMaquina, String fr_codFerramenta, String fr_codProduto, Date fr_dataLancamento, Time fr_horaLancamento, String fr_loginUsuario) {

    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(String tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    public String getFr_codMaquina() {
        return fr_codMaquina;
    }

    public void setFr_codMaquina(String fr_codMaquina) {
        this.fr_codMaquina = fr_codMaquina;
    }

    public String getFr_codFerramenta() {
        return fr_codFerramenta;
    }

    public void setFr_codFerramenta(String fr_codFerramenta) {
        this.fr_codFerramenta = fr_codFerramenta;
    }

    public String getFr_codigoProduto() {
        return fr_codigoProduto;
    }

    public void setFr_codigoProduto(String fr_codigoProduto) {
        this.fr_codigoProduto = fr_codigoProduto;
    }

    public Date getFr_dataLancamento() {
        return fr_dataLancamento;
    }

    public void setFr_dataLancamento(Date fr_dataLancamento) {
        this.fr_dataLancamento = fr_dataLancamento;
    }

    public Time getFr_horaLancamento() {
        return fr_horaLancamento;
    }

    public void setFr_horaLancamento(Time fr_horaLancamento) {
        this.fr_horaLancamento = fr_horaLancamento;
    }

    public String getFr_loginUsuario() {
        return fr_loginUsuario;
    }

    public void setFr_loginUsuario(String fr_loginUsuario) {
        this.fr_loginUsuario = fr_loginUsuario;
    }

    @Override
    public String toString() {
        return "Lancamentos{" + "cod=" + cod + ", tipoLancamento=" + tipoLancamento + ", fr_codMaquina=" + fr_codMaquina + ", fr_codFerramenta=" + fr_codFerramenta + ", fr_codigoProduto=" + fr_codigoProduto + ", fr_dataLancamento=" + fr_dataLancamento + ", fr_horaLancamento=" + fr_horaLancamento + ", fr_codUsuario=" + fr_loginUsuario + '}';
    }

}
