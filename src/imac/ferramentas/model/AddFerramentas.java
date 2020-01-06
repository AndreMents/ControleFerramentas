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
public class AddFerramentas {

    private int cod;
    private String fk_codMaquina;
    private String fk_codFerramenta;
    private String codigoProduto;
    private Date dataLancamento;
    private Time horaLancamento;
    private int tempoCalibracao;
    private String loginUsuario;

    public void AddFerramentaDao(int cod, String fk_codMaquina, String fk_codFerramenta, String codigoProduto, Date dataLancamento, Time horaLancamento, int tempoCalibracao, String loginUsuario) {

    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getFk_codMaquina() {
        return fk_codMaquina;
    }

    public void setFk_codMaquina(String fk_codMaquina) {
        this.fk_codMaquina = fk_codMaquina;
    }

    public String getFk_codFerramenta() {
        return fk_codFerramenta;
    }

    public void setFk_codFerramenta(String fk_codFerramenta) {
        this.fk_codFerramenta = fk_codFerramenta;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Time getHoraLancamento() {
        return horaLancamento;
    }

    public void setHoraLancamento(Time horaLancamento) {
        this.horaLancamento = horaLancamento;
    }

    public int getTempoCalibracao() {
        return tempoCalibracao;
    }

    public void setTempoCalibracao(int tempoCalibracao) {
        this.tempoCalibracao = tempoCalibracao;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    @Override
    public String toString() {
        return "AddFerramentas{" + "cod=" + cod + ", fk_codMaquina=" + fk_codMaquina + ", fk_codFerramenta=" + fk_codFerramenta + ", codigoProduto=" + codigoProduto + ", dataLancamento=" + dataLancamento + ", horaLancamento=" + horaLancamento + ", tempoCalibracao=" + tempoCalibracao + ", loginUsuario=" + loginUsuario + '}';
    }

}
