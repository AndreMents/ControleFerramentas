/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imac.ferramentas.dao;

import imac.ferramentas.model.Maquinas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 *
 * @author @andre_ments
 */
public class MaquinasDao {
    // CREAT = METODO QUE CRIA O USUÁRIO

    public boolean checkCreate(String codigoMaquina) throws ClassNotFoundException {
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        try {
            stmt = con.prepareStatement("Select * from tbmaquinas where codigoMaquina=?");
            stmt.setString(1, codigoMaquina);
            rs = stmt.executeQuery();
            if (rs.next()) {
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaquinasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
    }

    public void create(Maquinas m) throws ClassNotFoundException {

        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tbmaquinas(codigoMaquina,nomeMaquina)" + "VALUES(?,?)");
            stmt.setString(1, m.getCodMaquina());
            stmt.setString(2, m.getNomeMaquina());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "salvo com sucesso");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }

    // READ = METODO QUE LISTA OS USUÁRIOS CADASTRADOS
    public List<Maquinas> read() throws ClassNotFoundException {
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Maquinas> Maquinas = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbmaquinas");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Maquinas maqui = new Maquinas();
                maqui.setCodMaquina(rs.getString("codigoMaquina"));
                maqui.setNomeMaquina(rs.getString("nomeMaquina"));
                Maquinas.add(maqui);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaquinasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return Maquinas;
    }

    // READFORDESC = METODO QUE PESQUISA O USUÁRIO
    public List<Maquinas> readForDesc(String desc) throws ClassNotFoundException {
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Maquinas> Maquinas = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbmaquinas WHERE nomeMaquina LIKE ?");
            stmt.setString(1, "%" + desc + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Maquinas maqui = new Maquinas();
                maqui.setCodMaquina(rs.getString("codigoMaquina"));
                maqui.setNomeMaquina(rs.getString("nomeMaquina"));
                Maquinas.add(maqui);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaquinasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return Maquinas;
    }

    // UPDATE = METODO QUE EDITA O USUÁRIO
    public void update(Maquinas m) throws ClassNotFoundException {
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbmaquinas SET nomeMaquina = ? WHERE codigoMaquina = ?");
            stmt.setString(1, m.getNomeMaquina());
            stmt.setString(2, m.getCodMaquina());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    // DELETE = METODO QUE DELETA O USUÁRIO
    public void delete(Maquinas f) throws ClassNotFoundException {
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tbmaquinas WHERE codigoMaquina = ?");
            stmt.setString(1, f.getCodMaquina());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluír" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
