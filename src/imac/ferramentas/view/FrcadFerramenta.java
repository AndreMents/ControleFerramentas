/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imac.ferramentas.view;

import imac.ferramentas.dao.FerramentasDao;
import imac.ferramentas.model.Ferramentas;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Suporte-01
 */
public class FrcadFerramenta extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrcadFerramenta
     */
    public FrcadFerramenta() throws ClassNotFoundException {
        initComponents();
        habilitarB(1);

    }

    public void checkCreate() throws SQLException {
        FerramentasDao pdao = new FerramentasDao();
        if (EdCod.getText().equals("") || EdNome.getText().equals("") || EdDescri.getText().equals("") || EdTempCali.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        } else {
            try {
                if (pdao.checkCreate(EdCod.getText())) {
                    JOptionPane.showMessageDialog(null, "Ferramenta Já cadastrada!");
                } else {
                    createTool();
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void createTool() {
        Ferramentas u = new Ferramentas();
        FerramentasDao dao = new FerramentasDao();
        habilitarB(1);
        if (EdCod.getText().equals("") || EdNome.getText().equals("") || EdDescri.getText().equals("") || EdTempCali.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "ATENÇÃO\n Você deve preencher todos os campos");
        } else {
            u.setCodigoFerramenta(EdCod.getText());
            u.setNomeFerramenta(EdNome.getText());
            u.setDescriFerramenta(EdDescri.getText());
            u.setTempCaliFerramenta(EdTempCali.getText());

            try {
                dao.create(u);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrcadFerramenta.class.getName()).log(Level.SEVERE, null, ex);
            }
            readTool();
            EdCod.setText(null);
            EdNome.setText(null);
            EdDescri.setText(null);
            EdTempCali.setText(null);
        }
    }

    public void readTool() {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        FerramentasDao pdao = new FerramentasDao();

        if (EdBuscaNome.getText().equals("")) {

            try {
                for (Ferramentas f : pdao.read()) {
                    modelo.addRow(new Object[]{
                        f.getCodigoFerramenta(),
                        f.getNomeFerramenta(),
                        f.getDescriFerramenta(),
                        f.getTempCaliFerramenta(),});
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrcadFerramenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                for (Ferramentas f : pdao.readForDesc(EdBuscaNome.getText())) {
                    modelo.addRow(new Object[]{
                        f.getCodigoFerramenta(),
                        f.getNomeFerramenta(),
                        f.getDescriFerramenta(),
                        f.getTempCaliFerramenta(),});
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrcadFerramenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void editTool() {
        if (tabela.getSelectedRow() != -1) {
            Ferramentas f = new Ferramentas();
            FerramentasDao dao = new FerramentasDao();

            habilitarB(1);
            if (EdCod.getText().equals("") || EdNome.getText().equals("") || EdDescri.getText().equals("") || EdTempCali.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "ATENÇÃO\n Você deve preencher todos os campos");
            } else {

                f.setNomeFerramenta(EdNome.getText());
                f.setDescriFerramenta(EdDescri.getText());
                f.setTempCaliFerramenta(EdTempCali.getText());
                f.setCodigoFerramenta((String) tabela.getValueAt(tabela.getSelectedRow(), 0));
                try {
                    dao.update(f);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FrcadUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }

                EdNome.setText(null);
                EdDescri.setText(null);
                EdTempCali.setText(null);
                EdCod.setText(null);
            }
        }
    }

    public void deleteTool() {
        Ferramentas f = new Ferramentas();
        FerramentasDao dao = new FerramentasDao();
        habilitarB(1);
        if (EdCod.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Para excluír uma ferramenta, selecione na listagem ou informe seu código");
        } else {
            f.setCodigoFerramenta(EdCod.getText());
            try {
                dao.delete(f);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrcadFerramenta.class.getName()).log(Level.SEVERE, null, ex);
            }
            EdCod.setText(null);
            EdNome.setText(null);
            EdDescri.setText(null);
            EdTempCali.setText(null);
            readTool();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BtNovo = new javax.swing.JButton();
        EdTempCali = new javax.swing.JTextField();
        EdCod = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        EdDescri = new javax.swing.JTextField();
        BtCancelar = new javax.swing.JButton();
        BtSalvar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        EdNome = new javax.swing.JTextField();
        BtSalvarEdit = new javax.swing.JButton();
        BtExcluir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        EdBuscaNome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        BtBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Cadastrar Ferramenta");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        jLabel1.setText("TEMPO PARA CALIBRAÇÃO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        jLabel2.setText("CÓDIGO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        BtNovo.setBackground(new java.awt.Color(0, 153, 102));
        BtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-adicionar-64 (1).png"))); // NOI18N
        BtNovo.setText("Nova");
        BtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtNovoActionPerformed(evt);
            }
        });
        jPanel1.add(BtNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 100, 30));
        jPanel1.add(EdTempCali, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 130, -1));
        jPanel1.add(EdCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 180, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        jLabel3.setText("NOME");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));
        jPanel1.add(EdDescri, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 400, -1));

        BtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-cancelar-24 (1).png"))); // NOI18N
        BtCancelar.setText("Cancelar");
        BtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(BtCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, -1, -1));

        BtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        BtSalvar.setText("Salvar");
        BtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(BtSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 100, 30));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        jLabel4.setText("DESCRIÇÃO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel5.setText("Em dias");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-fechar-janela-48 (2).png"))); // NOI18N
        jButton3.setText("Sair");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, -1, -1));
        jPanel1.add(EdNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 240, -1));

        BtSalvarEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        BtSalvarEdit.setText("Salvar");
        BtSalvarEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSalvarEditActionPerformed(evt);
            }
        });
        jPanel1.add(BtSalvarEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 100, 30));

        BtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-excluir-26 (1).png"))); // NOI18N
        BtExcluir.setText("Excluír");
        BtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(BtExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        jTabbedPane1.addTab("Cadastrar Ferramenta", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(EdBuscaNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 130, -1));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        jLabel7.setText("NOME");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        BtBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-localizar-e-substituir-24 (1).png"))); // NOI18N
        BtBuscar.setText("Buscar");
        BtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(BtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Descrição", "Tempo Recali."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tabelaMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setMinWidth(50);
            tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabela.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 570, 210));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-fechar-janela-48 (2).png"))); // NOI18N
        jButton4.setText("Sair");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, -1, -1));

        jLabel8.setText("Duplo clique para editar");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, -1));

        jTabbedPane1.addTab("Listar Ferramenta", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarActionPerformed
        try {
            checkCreate();
        } catch (SQLException ex) {
            Logger.getLogger(FrcadFerramenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtSalvarActionPerformed

    private void BtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtNovoActionPerformed
        habilitarB(2);
        EdCod.setText(null);
        EdNome.setText(null);
        EdDescri.setText(null);
        EdTempCali.setText(null);
        EdCod.requestFocus();
    }//GEN-LAST:event_BtNovoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed
        EdCod.setText(null);
        EdNome.setText(null);
        EdDescri.setText(null);
        EdTempCali.setText(null);
        habilitarB(1);

    }//GEN-LAST:event_BtCancelarActionPerformed


    private void BtSalvarEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarEditActionPerformed
        editTool();
    }//GEN-LAST:event_BtSalvarEditActionPerformed

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed
     deleteTool();
    }//GEN-LAST:event_BtExcluirActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tabelaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaMouseEntered

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        if (tabela.getSelectedRow() != -1) {
            EdCod.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
            EdNome.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
            EdDescri.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
            EdTempCali.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
            habilitarB(3);

        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void BtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBuscarActionPerformed
        readTool();
    }//GEN-LAST:event_BtBuscarActionPerformed

    public void habilitarB(int op) {
        switch (op) {
            case 1:
                BtNovo.setEnabled(true);
                BtSalvar.setVisible(true);
                BtSalvar.setEnabled(false);
                BtSalvarEdit.setEnabled(false);
                BtSalvarEdit.setVisible(false);
                BtBuscar.setEnabled(true);
                EdNome.setEnabled(false);
                EdCod.setEnabled(false);
                EdDescri.setEnabled(false);
                EdTempCali.setEnabled(false);
                EdDescri.requestFocus();
                BtExcluir.setEnabled(false);
                break;

            case 2:
                BtNovo.setEnabled(false);
                BtSalvar.setEnabled(true);
                BtBuscar.setEnabled(true);
                BtCancelar.setEnabled(true);
                EdNome.setEnabled(true);
                EdCod.setEnabled(true);
                EdDescri.setEnabled(true);
                EdTempCali.setEnabled(true);
                EdCod.requestFocus();
                break;

            case 3:
                BtNovo.setEnabled(false);
                BtSalvar.setEnabled(false);
                BtSalvar.setVisible(false);
                BtBuscar.setEnabled(true);
                BtSalvarEdit.setEnabled(true);
                BtSalvarEdit.setVisible(true);
                BtCancelar.setEnabled(true);
                EdNome.setEnabled(true);
                EdCod.setEnabled(false);
                EdDescri.setEnabled(true);
                EdTempCali.setEnabled(true);
                EdCod.requestFocus();
                BtExcluir.setEnabled(true);

                break;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtBuscar;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton BtNovo;
    private javax.swing.JButton BtSalvar;
    private javax.swing.JButton BtSalvarEdit;
    private javax.swing.JTextField EdBuscaNome;
    private javax.swing.JTextField EdCod;
    private javax.swing.JTextField EdDescri;
    private javax.swing.JTextField EdNome;
    private javax.swing.JTextField EdTempCali;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
