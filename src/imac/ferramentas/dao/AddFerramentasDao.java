/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imac.ferramentas.dao;

import imac.ferramentas.model.AddFerramentas;
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
public class AddFerramentasDao {
    // CREAT = METODO QUE CADASTRA A FERRAMENTA

    public boolean checkAddFerramenta(String codigoFerramenta) throws ClassNotFoundException {
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

    public boolean checkAddMaquina(String codigoMaquina) throws ClassNotFoundException {
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
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
    }

    public void create(AddFerramentas af) throws ClassNotFoundException {

        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO ferramentasatr(tbmaquinas_codigoMaquina, tbferramentas_codigoFerramenta, codigoProduto, dataLancamento, horaLancamento, tbusuarios_loginUsuario)" + "VALUES(?,?,?,NOW(),CURTIME(), ?)");
            stmt.setString(1, af.getFk_codMaquina());
            stmt.setString(2, af.getFk_codFerramenta());
            stmt.setString(3, af.getCodigoProduto());
            stmt.setString(4, af.getLoginUsuario());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "salvo com sucesso");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }

    }

    // READ = METODO QUE LISTA AS FERRAMENTAS CADASTRADAS
    public List<AddFerramentas> read() throws ClassNotFoundException {
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<AddFerramentas> AddFerramentas = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT  cod, tbmaquinas_codigoMaquina, tbferramentas_codigoFerramenta, codigoProduto, dataLancamento, horaLancamento, tbusuarios_loginUsuario, dataLancamento, DATEDIFF(NOW(), dataLancamento) as tempoCalibracao FROM ferramentasatr");
            rs = stmt.executeQuery();
            while (rs.next()) {
                AddFerramentas af = new AddFerramentas();
                af.setCod(rs.getInt("cod"));
                af.setFk_codFerramenta(rs.getString("tbmaquinas_codigoMaquina"));
                af.setFk_codMaquina(rs.getString("tbferramentas_codigoFerramenta"));
                af.setCodigoProduto(rs.getString("codigoProduto"));
                af.setDataLancamento(rs.getDate("dataLancamento"));
                af.setHoraLancamento(rs.getTime("horaLancamento"));
                af.setLoginUsuario(rs.getString("tbusuarios_loginUsuario"));
                af.setDataLancamento(rs.getDate("dataLancamento"));
                af.setTempoCalibracao(rs.getInt("tempoCalibracao"));
                AddFerramentas.add(af);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddFerramentasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return AddFerramentas;
    }

    // READFORDESC = METODO QUE PESQUISA AVANÇADA DE FERRAMENTA
    public List<AddFerramentas> readForDesc(String desc) throws ClassNotFoundException {
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<AddFerramentas> AddFerramentas = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT  cod, tbmaquinas_codigoMaquina, tbferramentas_codigoFerramenta, codigoProduto, dataLancamento, horaLancamento, tbusuarios_loginUsuario, dataLancamento, DATEDIFF(NOW(), dataLancamento) as tempoCalibracao FROM ferramentasatr WHERE tbmaquinas_codigoMaquina LIKE ?");
            stmt.setString(1, "%" + desc + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                AddFerramentas af = new AddFerramentas();
                af.setCod(rs.getInt("cod"));
                af.setFk_codMaquina(rs.getString("tbferramentas_codigoFerramenta"));
                af.setFk_codFerramenta(rs.getString("tbmaquinas_codigoMaquina"));
                af.setCodigoProduto(rs.getString("codigoProduto"));
                af.setDataLancamento(rs.getDate("dataLancamento"));
                af.setHoraLancamento(rs.getTime("horaLancamento"));
                af.setTempoCalibracao(rs.getInt("tempoCalibracao"));
                af.setLoginUsuario(rs.getString("tbusuarios_loginUsuario"));
                AddFerramentas.add(af);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddFerramentasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return AddFerramentas;

    }

    public void delete(AddFerramentas af) throws ClassNotFoundException {
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM ferramentasatr WHERE cod = ?");
            stmt.setInt(1, af.getCod());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluír" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void deleteRt(AddFerramentas af) throws ClassNotFoundException {
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM ferramentasatr WHERE cod = ?");
            stmt.setInt(1, af.getCod());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluír" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

}
