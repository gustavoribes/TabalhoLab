/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Cliente;
import dao.ClienteDao;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bjewjb ndfas
 */
public class FormCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormCliente
     */
    public FormCliente() {
        initComponents();
        this.setVisible(true);
        this.atualizaLista();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nomeTxt = new javax.swing.JTextField();
        enderecoTxt = new javax.swing.JTextField();
        emailTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        idTxt = new javax.swing.JTextField();
        telefoneTxt = new javax.swing.JTextField();
        rgTxt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        clienteTable = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro Clientes");

        jLabel1.setText("Nome");

        jLabel2.setText("Endereço");

        jLabel3.setText("Email");

        jLabel4.setText("Rg");

        jLabel5.setText("Telefone");

        jLabel6.setText("Id");

        idTxt.setEditable(false);

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Excluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Reload");

        clienteTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Endereço", "Telefone", "Email", "Rg"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        clienteTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clienteTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(clienteTable);
        if (clienteTable.getColumnModel().getColumnCount() > 0) {
            clienteTable.getColumnModel().getColumn(0).setResizable(false);
            clienteTable.getColumnModel().getColumn(1).setResizable(false);
            clienteTable.getColumnModel().getColumn(2).setResizable(false);
            clienteTable.getColumnModel().getColumn(3).setResizable(false);
            clienteTable.getColumnModel().getColumn(4).setResizable(false);
            clienteTable.getColumnModel().getColumn(5).setResizable(false);
        }

        jButton4.setText("Limpa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGap(25, 25, 25)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(enderecoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel5))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(nomeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel4)))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(rgTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton1))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(telefoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton2)))
                                    .addGap(0, 0, Short.MAX_VALUE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(rgTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(enderecoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(telefoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.limpatela();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            Cliente cliente = new Cliente();
            cliente.setNome(this.nomeTxt.getText());
            cliente.setTelefone(Integer.parseInt(this.telefoneTxt.getText()));
            cliente.setEndereco(this.enderecoTxt.getText());
            if (this.rgTxt.getText().length() == 10) {
                cliente.setRg(Integer.parseInt(this.rgTxt.getText()));
            } else {
                JOptionPane.showMessageDialog(null, "Rg invalido!");
                this.rgTxt.requestFocus();
                return;
            }
            if (this.emailTxt.getText().contains("@") && this.emailTxt.getText().contains(".com")) {
                cliente.setEmail(this.emailTxt.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Email invalido!");
                this.emailTxt.requestFocus();
                return;
            }
            ClienteDao clientedao = new ClienteDao(ViewSistema.getConexao());
            int cod = this.intCampoTelas(this.idTxt.getText());
            if (cod > 0) {
                cliente.setId(cod);
                clientedao.update(cliente);
                this.atualizaLista();
                this.limpatela();

            } else {

                clientedao.create(cliente);
                this.atualizaLista();
                this.limpatela();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Número mal formatado [Rg|Telefone]");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void clienteTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clienteTableMouseClicked
        if (evt.getClickCount() > 1) {
            JTable obj = (JTable) evt.getComponent();
            int linha = obj.getSelectedRow();
            Integer cod = (Integer) obj.getModel().getValueAt(linha, 0);
            Cliente cliente = new Cliente(cod);
            this.preencheTela(cliente);
        }
    }//GEN-LAST:event_clienteTableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int cod = this.intCampoTelas(this.idTxt.getText());
        if (cod > 0) {
            Cliente cliente = new Cliente(cod);
            ClienteDao clienteDao = new ClienteDao(ViewSistema.getConexao());
            try {
                clienteDao.delete(cliente);
            } catch (SQLException ex) {
                Logger.getLogger(FormCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.limpatela();
            this.atualizaLista();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void atualizaLista() {
        try {
            ClienteDao clienteDAO = new ClienteDao(ViewSistema.getConexao());
            List<Cliente> lista = clienteDAO.listaTodos();
            DefaultTableModel dtm = (DefaultTableModel) this.clienteTable.getModel();
            dtm.setRowCount(0);
            for (Cliente cliente : lista) {
                dtm.addRow(new Object[]{cliente.getId(), cliente.getNome(), cliente.getTelefone(), cliente.getEndereco(), cliente.getEmail(), cliente.getRg()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, String.format("Erro ao ler os Clientes:%s", ex.getMessage()), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean preencheTela(Cliente cliente) {
        boolean ret = false;
        try {
            ClienteDao clienteDAO = new ClienteDao(ViewSistema.getConexao());
            cliente = clienteDAO.retrieve(cliente);
            if (cliente != null && cliente.getId() > 0) {
                this.nomeTxt.setText(cliente.getNome());
                this.rgTxt.setText(Integer.toString(cliente.getRg()));
                this.emailTxt.setText(cliente.getEmail());
                this.enderecoTxt.setText(cliente.getEndereco());
                this.telefoneTxt.setText(Integer.toString(cliente.getTelefone()));
                this.idTxt.setText(Integer.toString(cliente.getId()));
                ret = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, String.format("Não foi possível carregar Cliente: %s", ex.getMessage()), "Erro", JOptionPane.ERROR_MESSAGE);

        }
        return ret;
    }

    private void limpatela() {
        this.idTxt.setText("");
        this.nomeTxt.setText("");
        this.telefoneTxt.setText("");
        this.enderecoTxt.setText("");
        this.rgTxt.setText("");
        this.emailTxt.setText("");

    }

    private int intCampoTelas(String valor) {
        int ret = 0;
        try {
            ret = Integer.parseInt(valor);
        } catch (NumberFormatException ex) {
        }
        return ret;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable clienteTable;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JTextField enderecoTxt;
    private javax.swing.JTextField idTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeTxt;
    private javax.swing.JTextField rgTxt;
    private javax.swing.JTextField telefoneTxt;
    // End of variables declaration//GEN-END:variables
}