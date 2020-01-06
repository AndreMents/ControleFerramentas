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
public class Usuarios {

    private int codUsuario;
    private String nomeUsuario;
    private String setorUsuario;
    private String loginUsuario;
    private String senhaUsuario;
    private String emailUsuario;
    private String cargoUsuario;

    public Usuarios() {

    }

    public Usuarios(int codUsuario, String nomeUsuario, String setorUsuario, String loginUsuario, String senhaUsuario, String emailUsuario, String cargoUsuario) {
        this.codUsuario = codUsuario;
        this.nomeUsuario = nomeUsuario;
        this.setorUsuario = setorUsuario;
        this.loginUsuario = loginUsuario;
        this.senhaUsuario = senhaUsuario;
        this.emailUsuario = emailUsuario;
        this.cargoUsuario = cargoUsuario;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSetorUsuario() {
        return setorUsuario;
    }

    public void setSetorUsuario(String setorUsuario) {
        this.setorUsuario = setorUsuario;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getCargoUsuario() {
        return cargoUsuario;
    }

    public void setCargoUsuario(String cargoUsuario) {
        this.cargoUsuario = cargoUsuario;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "codUsuario=" + codUsuario + ", nomeUsuario=" + nomeUsuario + ", setorUsuario=" + setorUsuario + ", loginUsuario=" + loginUsuario + ", senhaUsuario=" + senhaUsuario + ", emailUsuario=" + emailUsuario + ", cargoUsuario=" + cargoUsuario + '}';
    }

}
