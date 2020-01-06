/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imac.ferramentas.view;

import imac.ferramentas.dao.UsuariosDao;
import imac.ferramentas.model.Usuarios;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Suporte-01
 */
public class FrcadUsuario extends javax.swing.JInternalFrame {

    public FrcadUsuario() {
        initComponents();
        habilitarB(1);
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        BtExcluir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        EdLogin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        EdSetor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        EdEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        EdCargo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        EdCod = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        BtNovo = new javax.swing.JButton();
        BtSalvar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        BtCancelar = new javax.swing.JButton();
        EdNome = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        BtSalvarEdit = new javax.swing.JButton();
        EdSenha = new javax.swing.JPasswordField();
        BtSair1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        BtBuscar = new javax.swing.JButton();
        EdBuscaNome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        BtSair = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cadastrar Usuários");

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtExcluir.setText("Excluír");
        BtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtExcluirActionPerformed(evt);
            }
        });
        jPanel2.add(BtExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        jLabel2.setText("LOGIN");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));
        jPanel2.add(EdLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 168, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        jLabel3.setText("SENHA");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, -1, -1));
        jPanel2.add(EdSetor, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 168, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        jLabel4.setText("SETOR");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));
        jPanel2.add(EdEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 168, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        jLabel5.setText("E-MAIL");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));
        jPanel2.add(EdCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 168, -1));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        jLabel6.setText("CARGO");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, -1, -1));
        jPanel2.add(EdCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 70, -1));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        jLabel11.setText("CÓDIGO");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        BtNovo.setBackground(new java.awt.Color(0, 153, 102));
        BtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-adicionar-64 (1).png"))); // NOI18N
        BtNovo.setText("Novo");
        BtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtNovoActionPerformed(evt);
            }
        });
        jPanel2.add(BtNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 100, 30));

        BtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        BtSalvar.setText("Salvar");
        BtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSalvarActionPerformed(evt);
            }
        });
        jPanel2.add(BtSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 100, 30));

        jButton3.setText("Sair");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, -1, -1));

        BtCancelar.setText("Cancelar");
        BtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(BtCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, -1, -1));
        jPanel2.add(EdNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 168, -1));

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        jLabel12.setText("NOME");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        BtSalvarEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        BtSalvarEdit.setText("Salvar");
        BtSalvarEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSalvarEditActionPerformed(evt);
            }
        });
        jPanel2.add(BtSalvarEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 100, 30));
        jPanel2.add(EdSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 170, -1));

        BtSair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-fechar-janela-48 (2).png"))); // NOI18N
        BtSair1.setText("Sair");
        BtSair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSair1ActionPerformed(evt);
            }
        });
        jPanel2.add(BtSair1, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 250, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-cancelar-24 (1).png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, -1));

        jTabbedPane1.addTab("Cadastrar Usuário", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-localizar-e-substituir-24 (1).png"))); // NOI18N
        BtBuscar.setText("Buscar");
        BtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBuscarActionPerformed(evt);
            }
        });
        jPanel3.add(BtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 100, 30));
        jPanel3.add(EdBuscaNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 180, -1));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        jLabel7.setText("NOME");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Setor", "Login", "Senha", "E-mail", "Cargo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false
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
        jScrollPane1.setViewportView(tabela);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 460, 140));

        jLabel8.setText("Duplo clique para editar");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 130, -1));

        BtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-fechar-janela-48 (2).png"))); // NOI18N
        BtSair.setText("Sair");
        BtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSairActionPerformed(evt);
            }
        });
        jPanel3.add(BtSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, -1, -1));

        jTabbedPane1.addTab("Listar Usuário", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        public void checkCreate() throws SQLException {
        UsuariosDao pdao = new UsuariosDao();
        if (EdNome.getText().equals("") || EdSetor.getText().equals("") || EdLogin.getText().equals("") || EdSenha.getText().equals("") || EdEmail.getText().equals("")
                || EdCargo.getText().equals("") || EdNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        } else {
            try {
                if (pdao.checkCreate(EdLogin.getText())) {
                    JOptionPane.showMessageDialog(null, "Usuário já possui cadastro");
                } else {
                    createUser();
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void createUser() {

        Usuarios u = new Usuarios();
        UsuariosDao dao = new UsuariosDao();
        habilitarB(2);

        u.setNomeUsuario(EdNome.getText());
        u.setSetorUsuario(EdSetor.getText());
        u.setLoginUsuario(EdLogin.getText());
        u.setSenhaUsuario(EdSenha.getText());
        u.setEmailUsuario(EdEmail.getText());
        u.setCargoUsuario(EdCargo.getText());

        try {
            dao.create(u);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrcadFerramenta.class.getName()).log(Level.SEVERE, null, ex);
        }

        EdNome.setText(null);
        EdSetor.setText(null);
        EdLogin.setText(null);
        EdSenha.setText(null);
        EdEmail.setText(null);
        EdCargo.setText(null);

    }

    public void readUser() {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        UsuariosDao pdao = new UsuariosDao();

        if (EdBuscaNome.getText().equals("")) {
            try {
                for (Usuarios u : pdao.read()) {
                    modelo.addRow(new Object[]{
                        u.getCodUsuario(),
                        u.getNomeUsuario(),
                        u.getSetorUsuario(),
                        u.getLoginUsuario(),
                        u.getSenhaUsuario(),
                        u.getEmailUsuario(),
                        u.getCargoUsuario()});
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrcadUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                for (Usuarios u : pdao.readForDesc(EdBuscaNome.getText())) {
                    modelo.addRow(new Object[]{
                        u.getCodUsuario(),
                        u.getNomeUsuario(),
                        u.getSetorUsuario(),
                        u.getLoginUsuario(),
                        u.getSenhaUsuario(),
                        u.getEmailUsuario(),
                        u.getCargoUsuario()});
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrcadUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void editUser() {
        if (tabela.getSelectedRow() != -1) {
            Usuarios u = new Usuarios();
            UsuariosDao dao = new UsuariosDao();

            habilitarB(1);
            if (EdNome.getText().equals("") || EdSetor.getText().equals("") || EdLogin.getText().equals("") || EdSenha.getText().equals("") || EdEmail.getText().equals("")
                    || EdCargo.getText().equals("") || EdNome.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "ATENÇÃO\n Você deve preencher todos os campos");
            } else {

                u.setNomeUsuario(EdNome.getText());
                u.setSetorUsuario(EdSetor.getText());
                u.setLoginUsuario(EdLogin.getText());
                u.setSenhaUsuario(EdSenha.getText());
                u.setEmailUsuario(EdEmail.getText());
                u.setCargoUsuario(EdCargo.getText());
                u.setCodUsuario((int) tabela.getValueAt(tabela.getSelectedRow(), 0));
                try {
                    dao.update(u);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FrcadUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }

                EdNome.setText(null);
                EdSetor.setText(null);
                EdLogin.setText(null);
                EdSenha.setText(null);
                EdEmail.setText(null);
                EdCargo.setText(null);
            }

        }
    }

    public void deleteUser() {
        Usuarios f = new Usuarios();
        UsuariosDao dao = new UsuariosDao();
        habilitarB(3);
        if (EdCod.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe o código do usuário para excluír");
        } else {
            f.setCodUsuario(Integer.parseInt(EdCod.getText()));
            try {
                dao.delete(f);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrcadUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            EdCod.setText(null);
            EdNome.setText(null);
            EdSetor.setText(null);
            EdLogin.setText(null);
            EdSenha.setText(null);
            EdEmail.setText(null);
            EdCargo.setText(null);
            habilitarB(1);
            readUser();
        }
    }


    private void BtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBuscarActionPerformed
        readUser();
    }//GEN-LAST:event_BtBuscarActionPerformed

    private void BtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSairActionPerformed
        dispose();
    }//GEN-LAST:event_BtSairActionPerformed

    private void BtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtNovoActionPerformed
        habilitarB(2);
        EdCod.setText(null);
        EdNome.setText(null);
        EdSetor.setText(null);
        EdLogin.setText(null);
        EdSenha.setText(null);
        EdEmail.setText(null);
        EdCargo.setText(null);
        EdNome.requestFocus();
    }//GEN-LAST:event_BtNovoActionPerformed

    private void BtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarActionPerformed
        try {
            checkCreate();
        } catch (SQLException ex) {
            Logger.getLogger(FrcadUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtSalvarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed
        EdCod.setText(null);
        EdNome.setText(null);
        EdSetor.setText(null);
        EdLogin.setText(null);
        EdSenha.setText(null);
        EdEmail.setText(null);
        EdCargo.setText(null);
        habilitarB(1);

    }//GEN-LAST:event_BtCancelarActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        if (tabela.getSelectedRow() != -1) {
            EdCod.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
            EdNome.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
            EdSetor.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
            EdLogin.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
            EdSenha.setText(tabela.getValueAt(tabela.getSelectedRow(), 4).toString());
            EdEmail.setText(tabela.getValueAt(tabela.getSelectedRow(), 5).toString());
            EdCargo.setText(tabela.getValueAt(tabela.getSelectedRow(), 6).toString());
            habilitarB(3);

        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void BtSalvarEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarEditActionPerformed
        editUser();
    }//GEN-LAST:event_BtSalvarEditActionPerformed

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed
        deleteUser();
    }//GEN-LAST:event_BtExcluirActionPerformed

    private void BtSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSair1ActionPerformed
    dispose();
    }//GEN-LAST:event_BtSair1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    habilitarB(1);
    EdNome.setText(null);
    EdCargo.setText(null);
    EdEmail.setText(null);
    EdLogin.setText(null);
    EdSenha.setText(null);
    EdSetor.setText(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void habilitarB(int op) {
        switch (op) {
            case 1:

                BtNovo.setEnabled(true);
                BtSalvar.setVisible(true);
                BtSalvar.setEnabled(false);
                BtBuscar.setEnabled(true);
                BtSalvarEdit.setVisible(false);
                BtSalvarEdit.setEnabled(false);
                EdNome.setEnabled(false);
                EdCod.setEnabled(false);
                EdSetor.setEnabled(false);
                EdLogin.setEnabled(false);
                EdSenha.setEnabled(false);
                EdEmail.setEnabled(false);
                EdCargo.setEnabled(false);
                BtExcluir.setEnabled(false);
                EdNome.requestFocus();
                break;

            case 2:
                BtNovo.setEnabled(false);
                BtSalvar.setEnabled(true);
                BtSalvar.setVisible(true);
                BtBuscar.setEnabled(true);
                BtSalvarEdit.setEnabled(false);
                BtSalvarEdit.setVisible(false);
                BtCancelar.setEnabled(true);
                EdNome.setEnabled(true);
                EdCod.setEnabled(false);
                EdSetor.setEnabled(true);
                EdLogin.setEnabled(true);
                EdSenha.setEnabled(true);
                EdEmail.setEnabled(true);
                EdCargo.setEnabled(true);
                BtExcluir.setEnabled(false);
                EdNome.requestFocus();
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
                EdSetor.setEnabled(true);
                EdLogin.setEnabled(false);
                EdSenha.setEnabled(true);
                EdEmail.setEnabled(true);
                EdCargo.setEnabled(true);
                BtExcluir.setEnabled(true);
                EdNome.requestFocus();
                break;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtBuscar;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton BtNovo;
    private javax.swing.JButton BtSair;
    private javax.swing.JButton BtSair1;
    private javax.swing.JButton BtSalvar;
    private javax.swing.JButton BtSalvarEdit;
    private javax.swing.JTextField EdBuscaNome;
    private javax.swing.JTextField EdCargo;
    private javax.swing.JTextField EdCod;
    private javax.swing.JTextField EdEmail;
    private javax.swing.JTextField EdLogin;
    private javax.swing.JTextField EdNome;
    private javax.swing.JPasswordField EdSenha;
    private javax.swing.JTextField EdSetor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
