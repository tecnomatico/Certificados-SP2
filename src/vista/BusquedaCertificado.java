/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import vista.AltaCertificado;
import vista.AltaPersona;
import java.awt.TextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import modelo.Certificado;
import modelo.ModeloCertificado;
import modelo.ModeloPersona;
import modelo.Persona;


/**
 *
 * @author dario
 */
public class BusquedaCertificado extends javax.swing.JDialog {

    Certificado certificado;
    ModeloCertificado modeloCertificado = new ModeloCertificado();
    private final TableRowSorter sorter;
    int numeroSeleccion;
    AltaCertificado parent;
    private final JTextField tipoPersona;
    private final String qPersonas;

    public Certificado getCertificado() {
        return certificado;
    }

    public void setCertificado(Certificado certificado) {
        this.certificado = certificado;
    }

    /**
     * Creates new form BusquedaPersona
     */
    public BusquedaCertificado(Certificado certificado, AltaCertificado parent, boolean modal, JTextField tipoPersona, String quePersona) {
        super(parent, modal);
        initComponents();
        
        sorter = new TableRowSorter(modeloCertificado);
        tblBusquedaCertificado.setModel(modeloCertificado);
        this.parent = parent;//Estoy creando una variable global, le asigno el parent 
        this.tipoPersona = tipoPersona;//Estoy creando una variable global, le asigno el parent 
        //q traigo del anterior
        this.qPersonas = quePersona;
        setLocationRelativeTo(parent);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBusquedaCertificado = new javax.swing.JTable();
        txtBusquedaNumCertificado = new javax.swing.JTextField();
        btnAgrePersCeritifcado = new javax.swing.JToggleButton();
        btnCancelarBusq = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Busque el Certificado por Datos");

        tblBusquedaCertificado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblBusquedaCertificado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBusquedaCertificadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBusquedaCertificado);

        txtBusquedaNumCertificado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBusquedaNumCertificadoKeyPressed(evt);
            }
        });

        btnAgrePersCeritifcado.setText("Agregar a Certificado");
        btnAgrePersCeritifcado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgrePersCeritifcadoActionPerformed(evt);
            }
        });

        btnCancelarBusq.setText("Cancelar");
        btnCancelarBusq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarBusqActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAgrePersCeritifcado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelarBusq))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBusquedaNumCertificado, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBusquedaNumCertificado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarBusq)
                    .addComponent(btnAgrePersCeritifcado))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblBusquedaCertificadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBusquedaCertificadoMouseClicked

    }//GEN-LAST:event_tblBusquedaCertificadoMouseClicked

    private void txtBusquedaNumCertificadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaNumCertificadoKeyPressed
        if (modeloCertificado.getRowCount() != 0) {
            sorter.setRowFilter(RowFilter.regexFilter("(?i).*" + txtBusquedaNumCertificado.getText() + ".*"));
            tblBusquedaCertificado.setRowSorter(sorter);
        }                // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaNumCertificadoKeyPressed

    private void btnAgrePersCeritifcadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgrePersCeritifcadoActionPerformed
        if (tblBusquedaCertificado.getSelectedRow() != -1) {
            numeroSeleccion = sorter.convertRowIndexToModel(tblBusquedaCertificado.getSelectedRow());
            // agrego al certificado
            setCertificado(modeloCertificado.getCertificado(numeroSeleccion));
            
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila");
        }
    }//GEN-LAST:event_btnAgrePersCeritifcadoActionPerformed

    private void btnCancelarBusqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarBusqActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarBusqActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAgrePersCeritifcado;
    private javax.swing.JButton btnCancelarBusq;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBusquedaCertificado;
    private javax.swing.JTextField txtBusquedaNumCertificado;
    // End of variables declaration//GEN-END:variables
}
