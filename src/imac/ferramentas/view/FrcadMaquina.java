/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imac.ferramentas.view;

import imac.ferramentas.dao.MaquinasDao;
import imac.ferramentas.model.Maquinas;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrcadMaquina extends javax.swing.JInternalFrame {

    public FrcadMaquina() {
        initComponents();
        habilitarB(1);
    }

    public void checkCreate() throws SQLException {
        MaquinasDao pdao = new MaquinasDao();
        if (EdCod.getText().equals("") || EdNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        } else {
            try {
                if (pdao.checkCreate(EdCod.getText())) {
                    JOptionPane.showMessageDialog(null, "Ferramenta Já cadastrada!");
                } else {
                    createMaquina();
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            readMaquina();
        }
    }

    public void createMaquina() {
        Maquinas m = new Maquinas();
        MaquinasDao dao = new MaquinasDao();
        habilitarB(1);

        m.setCodMaquina(EdCod.getText());
        m.setNomeMaquina(EdNome.getText());

        try {
            dao.create(m);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrcadMaquina.class.getName()).log(Level.SEVERE, null, ex);
        }
        EdCod.setText(null);
        EdNome.setText(null);

    }

    public void readMaquina() {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        MaquinasDao pdao = new MaquinasDao();

        if (EdBuscaNome.getText().equals("")) {
            try {
                for (Maquinas f : pdao.read()) {
                    modelo.addRow(new Object[]{
                        f.getCodMaquina(),
                        f.getNomeMaquina()

                    });
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrcadMaquina.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            try {
                for (Maquinas f : pdao.readForDesc(EdBuscaNome.getText())) {
                    modelo.addRow(new Object[]{
                        f.getCodMaquina(),
                        f.getNomeMaquina()

                    });
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrcadMaquina.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void editMaquina() {
        if (tabela.getSelectedRow() != -1) {
            Maquinas m = new Maquinas();
            MaquinasDao dao = new MaquinasDao();

            habilitarB(1);
            if (EdNome.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "ATENÇÃO\n Você deve preencher todos os campos");
            } else {
                m.setNomeMaquina(EdNome.getText());
                m.setCodMaquina((String) tabela.getValueAt(tabela.getSelectedRow(), 0));
                try {
                    dao.update(m);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FrcadMaquina.class.getName()).log(Level.SEVERE, null, ex);
                }
                readMaquina();
                EdNome.setText(null);

            }

        }
    }

    public void deleteMaquina() {
        Maquinas m = new Maquinas();
        MaquinasDao dao = new MaquinasDao();
        habilitarB(1);

        if (EdCod.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Para excluír uma máquina, selecione na listagem ou informe seu código");
        } else {
            m.setCodMaquina(EdCod.getText());
            try {
                dao.delete(m);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrcadMaquina.class.getName()).log(Level.SEVERE, null, ex);
            }
            EdCod.setText(null);
            EdNome.setText(null);
            readMaquina();
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BtSair = new javax.swing.JButton();
        BtCancelar = new javax.swing.JButton();
        BtExcluir = new javax.swing.JButton();
        BtSalvar = new javax.swing.JButton();
        BtBuscar = new javax.swing.JButton();
        EdBuscaNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        BtNova = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        EdCod = new javax.swing.JTextField();
        EdNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        BtSalvarEdit = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("Cadastrar Máquina");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-fechar-janela-48 (2).png"))); // NOI18N
        BtSair.setText("Sair");
        BtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSairActionPerformed(evt);
            }
        });
        jPanel1.add(BtSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, -1, -1));

        BtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-cancelar-24 (1).png"))); // NOI18N
        BtCancelar.setText("Cancelar");
        BtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(BtCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, -1, -1));

        BtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-excluir-26 (1).png"))); // NOI18N
        BtExcluir.setText("Excluír");
        BtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(BtExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        BtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        BtSalvar.setText("Salvar");
        BtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(BtSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, 34));

        BtBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-localizar-e-substituir-24 (1).png"))); // NOI18N
        BtBuscar.setText("Buscar");
        BtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(BtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 90, 30));
        jPanel1.add(EdBuscaNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 141, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        jLabel4.setText("NOME");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        BtNova.setBackground(new java.awt.Color(0, 153, 102));
        BtNova.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-adicionar-64 (1).png"))); // NOI18N
        BtNova.setText("Nova");
        BtNova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtNovaActionPerformed(evt);
            }
        });
        jPanel1.add(BtNova, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 80, 30));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setColumnSelectionAllowed(true);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);
        tabela.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setMinWidth(60);
            tabela.getColumnModel().getColumn(0).setPreferredWidth(60);
            tabela.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 350, 220));

        EdCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EdCodActionPerformed(evt);
            }
        });
        jPanel1.add(EdCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 141, -1));
        jPanel1.add(EdNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 230, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        jLabel2.setText("NOME");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 50, 10));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        jLabel1.setText("CÓDIGO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        BtSalvarEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        BtSalvarEdit.setText("Salvar");
        BtSalvarEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSalvarEditActionPerformed(evt);
            }
        });
        jPanel1.add(BtSalvarEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed
        EdCod.setText(null);
        EdNome.setText(null);
        habilitarB(1);

    }//GEN-LAST:event_BtCancelarActionPerformed

    public void habilitarB(int op) {
        switch (op) {
            case 1:

                BtNova.setEnabled(true);
                BtSalvar.setVisible(true);
                BtSalvar.setEnabled(false);
                BtBuscar.setEnabled(true);
                BtSalvarEdit.setVisible(false);
                BtSalvarEdit.setEnabled(false);
                EdNome.setEnabled(false);
                EdCod.setEnabled(false);
                EdNome.requestFocus();
                break;

            case 2:
                BtNova.setEnabled(false);
                BtSalvar.setEnabled(true);
                BtSalvar.setVisible(true);
                BtBuscar.setEnabled(true);
                BtSalvarEdit.setEnabled(false);
                BtSalvarEdit.setVisible(false);
                BtCancelar.setEnabled(true);
                EdNome.setEnabled(true);
                EdCod.setEnabled(true);
                EdCod.requestFocus();
                break;

            case 3:
                BtNova.setEnabled(false);
                BtSalvar.setEnabled(false);
                BtSalvar.setVisible(false);
                BtBuscar.setEnabled(true);
                BtSalvarEdit.setEnabled(true);
                BtSalvarEdit.setVisible(true);
                BtCancelar.setEnabled(true);
                EdNome.setEnabled(true);
                EdCod.setEnabled(false);
                EdNome.requestFocus();
                break;
        }
    }

    private void BtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSairActionPerformed
        dispose();
    }//GEN-LAST:event_BtSairActionPerformed

    private void BtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBuscarActionPerformed
        readMaquina();
    }//GEN-LAST:event_BtBuscarActionPerformed

    private void BtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarActionPerformed
        try {
            checkCreate();
        } catch (SQLException ex) {
            Logger.getLogger(FrcadMaquina.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_BtSalvarActionPerformed


    private void BtNovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtNovaActionPerformed
        habilitarB(2);

    }//GEN-LAST:event_BtNovaActionPerformed

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed
        deleteMaquina();
    }//GEN-LAST:event_BtExcluirActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        if (tabela.getSelectedRow() != -1) {
            EdCod.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
            EdNome.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());

            habilitarB(3);

        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void BtSalvarEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarEditActionPerformed
        editMaquina();
    }//GEN-LAST:event_BtSalvarEditActionPerformed

    private void EdCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EdCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EdCodActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtBuscar;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton BtNova;
    private javax.swing.JButton BtSair;
    private javax.swing.JButton BtSalvar;
    private javax.swing.JButton BtSalvarEdit;
    private javax.swing.JTextField EdBuscaNome;
    private javax.swing.JTextField EdCod;
    private javax.swing.JTextField EdNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
