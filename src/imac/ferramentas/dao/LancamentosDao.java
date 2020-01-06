/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imac.ferramentas.dao;

import imac.ferramentas.model.Lancamentos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author @andre_ments
 */
public class LancamentosDao {

    public void create(Lancamentos la) throws ClassNotFoundException {

        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO lancamentoferramentas(cod, tipolancamento,  tbferramentasatr_tbmaquinas_codigoMaquina, tbferramentasatr_tbferramentas_codigoFerramenta, tbferramentasatr_codigoProduto, tbferramentasatr_dataLancamento, tbferramentasatr_horaLancamento, tbferramentasatr_tbusuarios_loginUsuario)" + "VALUES(?,?,?,?,?,NOW(),CURTIME(),?)");
            stmt.setInt(1, la.getCod());
            stmt.setString(2, la.getTipoLancamento());
            stmt.setString(3, la.getFr_codMaquina());
            stmt.setString(4, la.getFr_codFerramenta());
            stmt.setString(5, la.getFr_codigoProduto());
            stmt.setString(6, la.getFr_loginUsuario());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }

    }

    public List<Lancamentos> read() throws ClassNotFoundException {
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Lancamentos> Lancamentos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM lancamentoferramentas");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Lancamentos la = new Lancamentos();
                la.setCod(rs.getInt("cod"));
                la.setTipoLancamento(rs.getString("tipolancamento"));
                la.setFr_codMaquina(rs.getString("tbferramentasatr_tbferramentas_codigoFerramenta"));
                la.setFr_codFerramenta(rs.getString("tbferramentasatr_tbmaquinas_codigoMaquina"));
                la.setFr_codigoProduto(rs.getString("tbferramentasatr_codigoProduto"));
                la.setFr_dataLancamento(rs.getDate("tbferramentasatr_dataLancamento"));
                la.setFr_horaLancamento(rs.getTime("tbferramentasatr_horaLancamento"));
                la.setFr_loginUsuario(rs.getString("tbferramentasatr_tbusuarios_loginUsuario"));
                Lancamentos.add(la);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddFerramentasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return Lancamentos;
    }

    // READFORDESC = METODO QUE PESQUISA AVANÇADA DE FERRAMENTA
    public List<Lancamentos> readForDesc(String desc) throws ClassNotFoundException {
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Lancamentos> Lancamentos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM lancamentoferramentas WHERE tbferramentasatr_tbmaquinas_codigoMaquina LIKE ?");
            stmt.setString(1, "%" + desc + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Lancamentos la = new Lancamentos();
                la.setCod(rs.getInt("cod"));
                la.setTipoLancamento(rs.getString("tipolancamento"));
                la.setFr_codFerramenta(rs.getString("tbferramentasatr_tbmaquinas_codigoMaquina"));
                la.setFr_codMaquina(rs.getString("tbferramentasatr_tbferramentas_codigoFerramenta"));
                la.setFr_codigoProduto(rs.getString("tbferramentasatr_codigoProduto"));
                la.setFr_dataLancamento(rs.getDate("tbferramentasatr_dataLancamento"));
                la.setFr_horaLancamento(rs.getTime("tbferramentasatr_horaLancamento"));
                la.setFr_loginUsuario(rs.getString("tbferramentasatr_tbusuarios_loginUsuario"));
                Lancamentos.add(la);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddFerramentasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return Lancamentos;

    }

}
