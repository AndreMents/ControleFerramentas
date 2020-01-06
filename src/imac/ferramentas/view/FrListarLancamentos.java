/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imac.ferramentas.view;

import imac.ferramentas.dao.LancamentosDao;
import imac.ferramentas.model.Lancamentos;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Suporte-01
 */
public class FrListarLancamentos extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrListarLancamentos
     */
    public FrListarLancamentos() {
        initComponents();
    }

    public void readTool() {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        LancamentosDao pdao = new LancamentosDao();

        if (EdBuscaCodMaquina.getText().equals("")) {
            try {
                for (Lancamentos l : pdao.read()) {
                    modelo.addRow(new Object[]{
                        l.getTipoLancamento(),
                        l.getCod(),
                        l.getFr_codFerramenta(),
                        l.getFr_codMaquina(),
                        l.getFr_codigoProduto(),
                        l.getFr_dataLancamento(),
                        l.getFr_horaLancamento(),
                        l.getFr_loginUsuario()});
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrListarLancamentos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            try {
                for (Lancamentos l : pdao.readForDesc(EdBuscaCodMaquina.getText())) {
                    modelo.addRow(new Object[]{
                        l.getTipoLancamento(),
                        l.getCod(),
                        l.getFr_codFerramenta(),
                        l.getFr_codMaquina(),
                        l.getFr_codigoProduto(),
                        l.getFr_dataLancamento(),
                        l.getFr_horaLancamento(),
                        l.getFr_loginUsuario()});
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrcadUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        BtBuscarMaqui = new javax.swing.JButton();
        EdBuscaCodMaquina = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Lançamentos de Ferramentas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-fechar-janela-48 (2).png"))); // NOI18N
        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 430, -1, -1));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tipo Lançamento", "Nº Lançamento", "Código Máquina", "Código Ferramenta", "Código do Produto", "Data Lançamento", "Hora Lançamento", "Usuário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
            tabela.getColumnModel().getColumn(1).setMaxWidth(60);
            tabela.getColumnModel().getColumn(2).setMinWidth(60);
            tabela.getColumnModel().getColumn(2).setPreferredWidth(60);
            tabela.getColumnModel().getColumn(2).setMaxWidth(60);
            tabela.getColumnModel().getColumn(3).setMinWidth(60);
            tabela.getColumnModel().getColumn(3).setPreferredWidth(60);
            tabela.getColumnModel().getColumn(3).setMaxWidth(60);
            tabela.getColumnModel().getColumn(4).setMinWidth(80);
            tabela.getColumnModel().getColumn(4).setPreferredWidth(80);
            tabela.getColumnModel().getColumn(4).setMaxWidth(80);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 880, 340));

        BtBuscarMaqui.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-localizar-e-substituir-24 (1).png"))); // NOI18N
        BtBuscarMaqui.setText("Buscar");
        BtBuscarMaqui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBuscarMaquiActionPerformed(evt);
            }
        });
        jPanel1.add(BtBuscarMaqui, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 90, -1));

        EdBuscaCodMaquina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EdBuscaCodMaquinaActionPerformed(evt);
            }
        });
        jPanel1.add(EdBuscaCodMaquina, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 100, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        jLabel2.setText("Consulta Máquina");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EdBuscaCodMaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EdBuscaCodMaquinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EdBuscaCodMaquinaActionPerformed

    private void BtBuscarMaquiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBuscarMaquiActionPerformed
        readTool();
    }//GEN-LAST:event_BtBuscarMaquiActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked

    }//GEN-LAST:event_tabelaMouseClicked

    private void tabelaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaKeyPressed

    }//GEN-LAST:event_tabelaKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtBuscarMaqui;
    private javax.swing.JTextField EdBuscaCodMaquina;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}