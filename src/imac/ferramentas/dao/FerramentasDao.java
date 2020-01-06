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

import imac.ferramentas.model.Ferramentas;
import imac.ferramentas.view.FrMenu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FerramentasDao {

    public boolean checkCreate(String codigoFerramenta) throws ClassNotFoundException {
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        try {
            stmt = con.prepareStatement("Select * from tbferramentas where codigoFerramenta=?");
            stmt.setString(1, codigoFerramenta);
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

    public void create(Ferramentas f) throws ClassNotFoundException {

        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tbferramentas(codigoFerramenta,nomeFerramenta,descriFerramenta,tempCaliFerramenta)" + "VALUES(?,?,?,?)");
            stmt.setString(1, f.getCodigoFerramenta());
            stmt.setString(2, f.getNomeFerramenta());
            stmt.setString(3, f.getDescriFerramenta());
            stmt.setString(4, f.getTempCaliFerramenta());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "salvo com sucesso");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }

    public boolean checkLogin(String usuario, String senha) throws ClassNotFoundException, SQLException {
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        try {
            stmt = con.prepareStatement("Select * from tbuser where usuario=? and senha=?");
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            if (rs.next()) {
                check = true;
                if (check == true) {
                    FrMenu Fr = new FrMenu();
                    Fr.setVisible(true);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FerramentasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
    }

    public List<Ferramentas> read() throws ClassNotFoundException {
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Ferramentas> Ferramentas = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbferramentas");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Ferramentas ferra = new Ferramentas();

                ferra.setCodigoFerramenta(rs.getString("codigoFerramenta"));
                ferra.setNomeFerramenta(rs.getString("nomeFerramenta"));
                ferra.setDescriFerramenta(rs.getString("descriFerramenta"));
                ferra.setTempCaliFerramenta(rs.getString("tempcaliFerramenta"));
                Ferramentas.add(ferra);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FerramentasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return Ferramentas;
    }

    public List<Ferramentas> readForDesc(String desc) throws ClassNotFoundException {
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Ferramentas> Ferramentas = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbferramentas WHERE nomeFerramenta LIKE ?");
            stmt.setString(1, "%" + desc + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Ferramentas ferra = new Ferramentas();
                ferra.setCodigoFerramenta(rs.getString("codigoFerramenta"));
                ferra.setNomeFerramenta(rs.getString("nomeFerramenta"));
                ferra.setDescriFerramenta(rs.getString("descriFerramenta"));
                ferra.setTempCaliFerramenta(rs.getString("tempcaliFerramenta"));
                Ferramentas.add(ferra);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FerramentasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return Ferramentas;
    }

    public void update(Ferramentas f) throws ClassNotFoundException {
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbferramentas SET nomeFerramenta = ?,descriFerramenta = ?, TempCaliFerramenta = ? WHERE codigoFerramenta = ?");
            stmt.setString(1, f.getNomeFerramenta());
            stmt.setString(2, f.getDescriFerramenta());
            stmt.setString(3, f.getTempCaliFerramenta());
            stmt.setString(4, f.getCodigoFerramenta());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Ferramentas f) throws ClassNotFoundException {
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tbferramentas WHERE codigoFerramenta = ?");
            stmt.setString(1, f.getCodigoFerramenta());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluír" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
