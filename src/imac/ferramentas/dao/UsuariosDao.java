/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author @andre_ments
 */
package imac.ferramentas.dao;

import imac.ferramentas.model.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuariosDao {

    public boolean checkCreate(String loginUsuario) throws ClassNotFoundException {
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        try {
            stmt = con.prepareStatement("Select * from tbusuarios where loginUsuario=?");
            stmt.setString(1, loginUsuario);
            rs = stmt.executeQuery();
            if (rs.next()) {
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
    }

    public void create(Usuarios f) throws ClassNotFoundException {

        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tbusuarios(codUsuario,nomeUsuario, setorUsuario, loginUsuario, senhaUsuario, emailUsuario, cargoUsuario)" + "VALUES(?,?,?,?,?,?,?)");
            stmt.setInt(1, f.getCodUsuario());
            stmt.setString(2, f.getNomeUsuario());
            stmt.setString(3, f.getSetorUsuario());
            stmt.setString(4, f.getLoginUsuario());
            stmt.setString(5, f.getSenhaUsuario());
            stmt.setString(6, f.getEmailUsuario());
            stmt.setString(7, f.getCargoUsuario());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "salvo com sucesso");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }

    public boolean checkLogin(String loginUsuario, String senhaUsuario) throws ClassNotFoundException {
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        try {
            Usuarios usu = new Usuarios();
            stmt = con.prepareStatement("Select * from tbusuarios where loginUsuario=? and senhaUsuario=?");
            stmt.setString(1, loginUsuario);
            stmt.setString(2, senhaUsuario);
            rs = stmt.executeQuery();

            if (rs.next()) {

                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FerramentasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
    }

    public List<Usuarios> read() throws ClassNotFoundException {
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuarios> Usuarios = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbusuarios");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Usuarios usu = new Usuarios();
                usu.setCodUsuario(rs.getInt("codUsuario"));
                usu.setNomeUsuario(rs.getString("nomeUsuario"));
                usu.setSetorUsuario(rs.getString("setorUsuario"));
                usu.setLoginUsuario(rs.getString("loginUsuario"));
                usu.setSenhaUsuario(rs.getString("senhaUsuario"));
                usu.setEmailUsuario(rs.getString("emailUsuario"));
                usu.setCargoUsuario(rs.getString("cargoUsuario"));
                Usuarios.add(usu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return Usuarios;
    }

    public List<Usuarios> readForDesc(String desc) throws ClassNotFoundException {
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuarios> Usuarios = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbusuarios WHERE nomeUsuario LIKE ?");
            stmt.setString(1, "%" + desc + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Usuarios usu = new Usuarios();
                usu.setCodUsuario(rs.getInt("codUsuario"));
                usu.setNomeUsuario(rs.getString("nomeUsuario"));
                usu.setSetorUsuario(rs.getString("setorUsuario"));
                usu.setLoginUsuario(rs.getString("loginUsuario"));
                usu.setSenhaUsuario(rs.getString("senhaUsuario"));
                usu.setEmailUsuario(rs.getString("emailUsuario"));
                usu.setCargoUsuario(rs.getString("cargoUsuario"));
                Usuarios.add(usu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return Usuarios;
    }

    public void update(Usuarios f) throws ClassNotFoundException {
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbusuarios SET nomeUsuario = ?, setorUsuario = ?, loginUsuario = ?, senhaUsuario = ?, emailUsuario = ?, cargoUsuario = ? WHERE codUsuario = ?");

            stmt.setString(1, f.getNomeUsuario());
            stmt.setString(2, f.getSetorUsuario());
            stmt.setString(3, f.getLoginUsuario());
            stmt.setString(4, f.getSenhaUsuario());
            stmt.setString(5, f.getEmailUsuario());
            stmt.setString(6, f.getCargoUsuario());
            stmt.setInt(7, f.getCodUsuario());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Usuarios f) throws ClassNotFoundException {
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tbusuarios WHERE codUsuario = ?");
            stmt.setInt(1, f.getCodUsuario());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluír" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
