/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imac.ferramentas.view;

import imac.ferramentas.dao.AddFerramentasDao;
import imac.ferramentas.dao.LancamentosDao;
import imac.ferramentas.dao.UsuariosDao;
import imac.ferramentas.model.AddFerramentas;
import imac.ferramentas.model.Lancamentos;
import imac.ferramentas.model.Usuarios;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Suporte-01
 */
public class FratribuirFerramenta extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrAtribuirFerramenta
     */
    public FratribuirFerramenta() {
        initComponents();
        URL imgicon = getClass().getResource("/img/hs-iconl.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(imgicon);
        EdexcluirCod.setVisible(false);
        BtExcluir.setEnabled(false);
        BtRetornar.setEnabled(false);
    }

    public void checkAddFerramenta() throws SQLException {
        AddFerramentasDao pdao = new AddFerramentasDao();
        if (EdCodFerramenta.getText().equals("") || EdCodMaquina.getText().equals("") || EdCodProduto.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        } else {
            try {
                if (pdao.checkAddFerramenta(EdCodFerramenta.getText())) {
                    checkAddMaquina();
                } else {
                    JOptionPane.showMessageDialog(null, "Ferramenta não cadastrada!");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void checkAddMaquina() throws SQLException {
        AddFerramentasDao pdao = new AddFerramentasDao();
        try {
            if (pdao.checkAddMaquina(EdCodMaquina.getText())) {
                atribuirTool();
            } else {
                JOptionPane.showMessageDialog(null, "Maquina não cadastrada!");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atribuirTool() {
        AddFerramentas af = new AddFerramentas();
        AddFerramentasDao dao = new AddFerramentasDao();

        af.setFk_codMaquina(EdCodMaquina.getText());
        af.setFk_codFerramenta(EdCodFerramenta.getText());
        af.setCodigoProduto(EdCodProduto.getText());
        af.setLoginUsuario("Não Informado");
        try {
            dao.create(af);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrcadFerramenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        lancamentoAtr();
        EdCodFerramenta.setText(null);
        EdCodMaquina.setText(null);
        EdCodProduto.setText(null);
        readTool();
    }

    public void lancamentoAtr() {
        UsuariosDao pdao = new UsuariosDao();

        Lancamentos la = new Lancamentos();
        LancamentosDao dao = new LancamentosDao();

        la.setFr_codMaquina(EdCodMaquina.getText());
        la.setFr_codFerramenta(EdCodFerramenta.getText());
        la.setTipoLancamento("Emprestimo");
        la.setFr_codigoProduto(EdCodProduto.getText());
        la.setFr_loginUsuario("Não Informado");

        try {
            dao.create(la);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Lancamentos.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void lancamentoRt() {
        UsuariosDao pdao = new UsuariosDao();

        Lancamentos la = new Lancamentos();
        LancamentosDao dao = new LancamentosDao();
        la.setFr_codMaquina(EdCodMaquina.getText());
        la.setFr_codFerramenta(EdCodFerramenta.getText());
        la.setTipoLancamento("Retorno");
        la.setFr_codigoProduto(EdCodProduto.getText());
        la.setFr_loginUsuario("Não Informado");

        try {
            dao.create(la);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Lancamentos.class.getName()).log(Level.SEVERE, null, ex);
        }

        excluirRt();
        JOptionPane.showMessageDialog(null, "Lançamento de retorno realizado com sucesso!");
    }

    public void readTool() {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        AddFerramentasDao pdao = new AddFerramentasDao();

        if (EdBuscaCodMaquina.getText().equals("")) {
            try {
                for (AddFerramentas f : pdao.read()) {
                    modelo.addRow(new Object[]{
                        f.getCod(),
                        f.getFk_codFerramenta(),
                        f.getFk_codMaquina(),
                        f.getCodigoProduto(),
                        f.getDataLancamento(),
                        f.getHoraLancamento(),
                        f.getLoginUsuario(),
                        f.getTempoCalibracao()});
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrcadFerramenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            try {
                for (AddFerramentas u : pdao.readForDesc(EdBuscaCodMaquina.getText())) {
                    modelo.addRow(new Object[]{
                        u.getCod(),
                        u.getFk_codFerramenta(),
                        u.getFk_codMaquina(),
                        u.getCodigoProduto(),
                        u.getDataLancamento(),
                        u.getHoraLancamento(),
                        u.getLoginUsuario(),
                        u.getTempoCalibracao()});
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrcadUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void excluirFerramentaAtr() {
        AddFerramentas af = new AddFerramentas();
        AddFerramentasDao dao = new AddFerramentasDao();

        if (EdexcluirCod.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Para excluír uma ferramenta atribuída, selecione na listagem");
        } else {
            af.setCod(Integer.parseInt(EdexcluirCod.getText()));
            try {
                dao.delete(af);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrcadFerramenta.class.getName()).log(Level.SEVERE, null, ex);
            }
            EdexcluirCod.setText(null);

            readTool();
        }
    }

    public void excluirRt() {
        AddFerramentas af = new AddFerramentas();
        AddFerramentasDao dao = new AddFerramentasDao();

        if (EdexcluirCod.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Para excluír uma ferramenta, selecione na tabela");
        } else {
            af.setCod(Integer.parseInt(EdexcluirCod.getText()));
            try {
                dao.deleteRt(af);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrcadFerramenta.class.getName()).log(Level.SEVERE, null, ex);
            }
            EdexcluirCod.setText(null);

            readTool();
            BtRetornar.setEnabled(false);
            EdCodFerramenta.setText(null);
            EdCodMaquina.setText(null);
            EdCodProduto.setText(null);
            BtExcluir.setEnabled(false);
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        EdBuscaCodMaquina = new javax.swing.JTextField();
        BtAtribuir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        BtRetornar = new javax.swing.JButton();
        BtBuscarMaqui = new javax.swing.JButton();
        EdCodFerramenta = new javax.swing.JTextField();
        EdCodMaquina = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        BtExcluir = new javax.swing.JButton();
        EdexcluirCod = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        EdCodProduto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Atribuir e Retornar Ferramenta");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-fechar-janela-48 (2).png"))); // NOI18N
        jButton5.setText("Sair");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 460, 80, 30));

        EdBuscaCodMaquina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EdBuscaCodMaquinaActionPerformed(evt);
            }
        });
        jPanel1.add(EdBuscaCodMaquina, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 100, -1));

        BtAtribuir.setBackground(new java.awt.Color(0, 153, 255));
        BtAtribuir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CIMA (1).png"))); // NOI18N
        BtAtribuir.setText("Atribuir");
        BtAtribuir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAtribuirActionPerformed(evt);
            }
        });
        jPanel1.add(BtAtribuir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 110, -1));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        jLabel7.setText("Atribuir Ferramenta");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        jLabel6.setText("Ferramentas Atribuídas as Máquinas ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 190, -1, 20));

        BtRetornar.setBackground(new java.awt.Color(255, 153, 153));
        BtRetornar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-abaixo-dentro-de-um-círculo-64 (1).png"))); // NOI18N
        BtRetornar.setText("Retornar");
        BtRetornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtRetornarActionPerformed(evt);
            }
        });
        jPanel1.add(BtRetornar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 110, -1));

        BtBuscarMaqui.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-localizar-e-substituir-24 (1).png"))); // NOI18N
        BtBuscarMaqui.setText("Buscar");
        BtBuscarMaqui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBuscarMaquiActionPerformed(evt);
            }
        });
        jPanel1.add(BtBuscarMaqui, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 90, -1));
        jPanel1.add(EdCodFerramenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 180, -1));
        jPanel1.add(EdCodMaquina, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 180, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        jLabel3.setText("CÓDIGO FERRAMENTA");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 20));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        jLabel2.setText("Consulta Máquina");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código Lançamento", "Código Máquina", "Código Ferramenta", "Código do Produto", "Data Lançamento", "Hora Lançamento", "Usuário", "Dias de Emprestimo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        tabela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setMinWidth(10);
            tabela.getColumnModel().getColumn(0).setMaxWidth(30);
            tabela.getColumnModel().getColumn(1).setMinWidth(60);
            tabela.getColumnModel().getColumn(1).setPreferredWidth(60);
            tabela.getColumnModel().getColumn(1).setMaxWidth(60);
            tabela.getColumnModel().getColumn(2).setMinWidth(60);
            tabela.getColumnModel().getColumn(2).setPreferredWidth(60);
            tabela.getColumnModel().getColumn(2).setMaxWidth(60);
            tabela.getColumnModel().getColumn(3).setMinWidth(80);
            tabela.getColumnModel().getColumn(3).setPreferredWidth(80);
            tabela.getColumnModel().getColumn(3).setMaxWidth(80);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 880, 190));

        BtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-excluir-26 (1).png"))); // NOI18N
        BtExcluir.setText("Excluir");
        BtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(BtExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, 30));
        jPanel1.add(EdexcluirCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, 30, -1));

        jLabel5.setText("Selecione na tabela para Excluír");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        jLabel4.setText("CÓDIGO MÁQUINA");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, 20));
        jPanel1.add(EdCodProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 180, -1));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        jLabel8.setText("CÓDIGO PRODUTO");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, 20));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-cancelar-24 (1).png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 460, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -10, 930, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void EdBuscaCodMaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EdBuscaCodMaquinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EdBuscaCodMaquinaActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void BtAtribuirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAtribuirActionPerformed
        try {
            checkAddFerramenta();

        } catch (SQLException ex) {
            Logger.getLogger(FratribuirFerramenta.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_BtAtribuirActionPerformed


    private void BtBuscarMaquiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBuscarMaquiActionPerformed
        readTool();
    }//GEN-LAST:event_BtBuscarMaquiActionPerformed

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed
        excluirFerramentaAtr();
        EdCodFerramenta.setText(null);
        EdCodMaquina.setText(null);
        EdBuscaCodMaquina.setText(null);
        EdCodProduto.setText(null);
        BtRetornar.setEnabled(false);
        BtExcluir.setEnabled(false);
    }//GEN-LAST:event_BtExcluirActionPerformed

    private void tabelaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaKeyPressed
        if (tabela.getSelectedRow() != -1) {
            EdexcluirCod.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_tabelaKeyPressed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        BtRetornar.setEnabled(true);
        BtExcluir.setEnabled(true);
        if (tabela.getSelectedRow() != -1) {
            EdexcluirCod.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
            EdCodMaquina.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
            EdCodFerramenta.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
            EdCodProduto.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());

        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void BtRetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtRetornarActionPerformed
        lancamentoRt();
    }//GEN-LAST:event_BtRetornarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        EdCodFerramenta.setText(null);
        EdCodMaquina.setText(null);
        EdBuscaCodMaquina.setText(null);
        EdCodProduto.setText(null);
        BtRetornar.setEnabled(false);
        BtExcluir.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private javax.swing.JDesktopPane desktop;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAtribuir;
    private javax.swing.JButton BtBuscarMaqui;
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton BtRetornar;
    private javax.swing.JTextField EdBuscaCodMaquina;
    private javax.swing.JTextField EdCodFerramenta;
    private javax.swing.JTextField EdCodMaquina;
    private javax.swing.JTextField EdCodProduto;
    private javax.swing.JTextField EdexcluirCod;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
