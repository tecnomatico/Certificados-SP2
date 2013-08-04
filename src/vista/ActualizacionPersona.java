/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dao.PersonaDAO;
import dao.imp.PersonaDAOImp;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;
import modelo.Persona;

/**
 *
 * @author dario
 */
public class ActualizacionPersona extends javax.swing.JDialog {
    
    String padre;
    private String seraCura;
    Persona persona;
    PersonaDAO personaDAO = new PersonaDAOImp();
    int n;
    /**
     * Creates new form AltaPersonas
     */
    ActualizacionPersona(BusquedaPersona aThis, boolean b, Persona persona, String qOperacion) {
        super(aThis, b);
        initComponents();
        setLocationRelativeTo(aThis);
        this.persona = persona;
        cargaTipoHijo();
//        String [] tipoHijo = {" ","Legitimo", "Union Civil","Natural", "Natural Reconocido"};
//        String th = persona.getTipoDeHijo();
//        cmbTipoHijo.addItem(persona.getTipoDeHijo());
//        for (int i = 0; i < 5; i++) {
//            if (tipoHijo[i].equals(persona.getTipoDeHijo())) {
//            }else{
//                cmbTipoHijo.addItem(tipoHijo[i]);                            
//            }
//            
//        }

        System.out.println(n);
//        if (persona.getCura().equals("NO")) {
//            lblCura.setEnabled(false);
//            cmbCura.setEnabled(false);
//            cmbTipoHijo.setActionCommand(persona.getTipoDeHijo());
//        } else {
//            cargaCura();
//        }
        
        txtApellido.setText(persona.getApellido());
        txtNombre.setText(persona.getNombre());
        txtDni.setText(persona.getDni());
        cmbSexo.setActionCommand(persona.getSexo());
        cldFechNac.setDate(persona.getFechaNaciemiento());
        txtLugarNac.setText(persona.getLugarNacimiento());
        cmbProvincia.setActionCommand(persona.getProvNacimiento());
        txtNacionalidad.setText(persona.getNacionalidad());
        txtDomTutor.setText(persona.getDomicilio());
        txtBario.setText(persona.getBarrio());
        txtTelFijo.setText(persona.getTelefonoFijo());
        txtTelCel.setText(persona.getTelefonoCelular());        
        
//        if (qOperacion.equals("borrar")) {
//            btnAceptarAltaPersona.setVisible(false);
//        } else {
//            btnElimPersona.setVisible(false);
//        }
    }

    ActualizacionPersona(BusquedaPersona aThis, boolean b) {
        super(aThis, b);
        initComponents();
        setLocationRelativeTo(aThis);
    }

    public void cargaTipoHijo(){
        String [] tipoHijo = {" ","Legitimo", "Union Civil","Natural", "Natural Reconocido"};
        
        cmbTipoHijo.addItem(persona.getTipoDeHijo());
        for (int i = 0; i < 5; i++) {
            if (tipoHijo[i].equals(persona.getTipoDeHijo())) {
            }else{
                cmbTipoHijo.addItem(tipoHijo[i]);                            
            }
            
        }  
        String [] sexo = {"Femenino","Masculino"};
        
        cmbSexo.addItem(persona.getSexo());
        for (int i = 0; i < 2; i++) {
            if (sexo[i].equals(persona.getSexo())) {
            }else{
                cmbSexo.addItem(sexo[i]);                            
            }
            
        }  
    }
    
//    public void cargaCura (){
//        String [] esCura = {"SI","NO"};
////        cmbCura.addItem(persona.getCura());
//        for (int i = 0; i < 2; i++) {
////            if (esCura[i].equals(persona.getCura())) {
//            }else{
//                cmbCura.addItem(esCura[i]);                            
//            }
//            
//        }          
//    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtApellido = new javax.swing.JTextPane();
        txtNombre = new javax.swing.JTextField();
        txtLugarNac = new javax.swing.JTextField();
        cmbProvincia = new javax.swing.JComboBox();
        txtNacionalidad = new javax.swing.JTextField();
        btnAceptarAltaPersona = new javax.swing.JButton();
        cmbSexo = new javax.swing.JComboBox();
        btnCancelarAltaPersona = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        cldFechNac = new com.toedter.calendar.JCalendar();
        jLabel9 = new javax.swing.JLabel();
        txtDomTutor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtBario = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtTelFijo = new javax.swing.JTextField();
        txtTelCel = new javax.swing.JTextField();
        cmbTipoHijo = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        lblCura = new javax.swing.JLabel();
        cmbCura = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actualizar Datos Persona");
        setPreferredSize(new java.awt.Dimension(1100, 700));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actualizar datos de una Persona", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel1.setText("Apellido/s:");

        jLabel2.setText("Nombre/s:");

        jLabel3.setText("Sexo:");

        jLabel4.setText("Fecha de Nacimiento:");

        jLabel5.setText("Lugar de Nacimiento:");

        jLabel6.setText("Provincia de Nacimiento:");

        jLabel7.setText("Nacionalidad:");

        jScrollPane1.setViewportView(txtApellido);

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        cmbProvincia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jujuy", "Catamarca", "Chaco", "Chubut", "Córdoba", "Corrientes", "Entre Ríos", "Formosa", "La Pampa", "La Rioja", "Mendoza", "Misiones", "Neuquén", "Río Negro", "Salta", "San Juan", "San Luis", "Santa Cruz", "Santa Fe", "Santiago del Estero", "Tucumán", "Tierra del Fuego", "Buenos Aires" }));

        btnAceptarAltaPersona.setText("Aceptar");
        btnAceptarAltaPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarAltaPersonaActionPerformed(evt);
            }
        });

        btnCancelarAltaPersona.setText("Cancelar");
        btnCancelarAltaPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAltaPersonaActionPerformed(evt);
            }
        });

        jLabel8.setText("DNI/Pasaporte/Cedula:");

        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });

        jLabel9.setText("Domicilio:");

        jLabel10.setText("Barrio:");

        jLabel11.setText("Telefono Fijo:");

        jLabel12.setText("Telefono Celular:");

        txtTelFijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelFijoActionPerformed(evt);
            }
        });

        cmbTipoHijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoHijoActionPerformed(evt);
            }
        });

        jLabel13.setText("Tipo de Hijo:");

        lblCura.setText("Es Cura:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 558, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 28, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jLabel1)
                            .addGap(4, 4, 4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jLabel2)
                            .addGap(4, 4, 4)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(77, 77, 77)
                            .addComponent(lblCura)
                            .addGap(10, 10, 10)
                            .addComponent(cmbCura, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jLabel8)
                            .addGap(4, 4, 4)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addComponent(jLabel13)
                            .addGap(10, 10, 10)
                            .addComponent(cmbTipoHijo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addComponent(jLabel3)
                            .addGap(22, 22, 22)
                            .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(cldFechNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addComponent(jLabel9))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(47, 47, 47)
                                    .addComponent(jLabel10))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addComponent(jLabel11))
                                .addComponent(jLabel12))
                            .addGap(7, 7, 7)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDomTutor, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtBario, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTelFijo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addComponent(txtTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(txtLugarNac, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(cmbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addComponent(txtNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(139, 139, 139)
                            .addComponent(btnAceptarAltaPersona)
                            .addGap(61, 61, 61)
                            .addComponent(btnCancelarAltaPersona)))
                    .addGap(0, 28, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 2, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(jLabel1))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addComponent(jLabel2))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(lblCura))
                        .addComponent(cmbCura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbTipoHijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel13))))
                    .addGap(11, 11, 11)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel3))
                        .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(11, 11, 11)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(cldFechNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel9)
                            .addGap(17, 17, 17)
                            .addComponent(jLabel10)
                            .addGap(24, 24, 24)
                            .addComponent(jLabel11)
                            .addGap(17, 17, 17)
                            .addComponent(jLabel12))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtDomTutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(11, 11, 11)
                            .addComponent(txtBario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtTelFijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(11, 11, 11)
                            .addComponent(txtTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(6, 6, 6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel5))
                        .addComponent(txtLugarNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(11, 11, 11)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel6))
                        .addComponent(cmbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(11, 11, 11)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel7))
                        .addComponent(txtNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(33, 33, 33)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnAceptarAltaPersona)
                        .addComponent(btnCancelarAltaPersona))
                    .addGap(0, 2, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 80, 570, 470);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setText("San Pedro y San Pablo");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(30, 590, 380, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Parroquia");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(30, 570, 80, 17);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/spsp2.png"))); // NOI18N
        jLabel14.setText("jLabel14");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(0, 0, 640, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnAceptarAltaPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarAltaPersonaActionPerformed
        //Persona persona = new Persona();        Esto es un ERRROR
        
        persona.setIdPersona(persona.getIdPersona());
        persona.setApellido(txtApellido.getText());
        persona.setNombre(txtNombre.getText());
        persona.setDni(txtDni.getText());
        persona.setSexo(cmbSexo.getSelectedItem().toString());
        persona.setLugarNacimiento(txtLugarNac.getText());
//        persona.setCura(cmbCura.getSelectedItem().toString());
        persona.setTipoDeHijo(cmbCura.getSelectedItem().toString());
        persona.setFechaNaciemiento(cldFechNac.getDate());
        persona.setProvNacimiento(cmbProvincia.getSelectedItem().toString());
        persona.setNacionalidad(txtNacionalidad.getText());
        persona.setDomicilio(txtDomTutor.getText());
        persona.setBarrio(txtBario.getText());
        persona.setTelefonoFijo(txtTelFijo.getText());
        persona.setTelefonoCelular(txtTelCel.getText());
       
        if (rootPaneCheckingEnabled) {
            
        } else {
        }
        
        personaDAO.update(persona);
        this.dispose();
    }//GEN-LAST:event_btnAceptarAltaPersonaActionPerformed

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void txtTelFijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelFijoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelFijoActionPerformed

    private void cmbTipoHijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoHijoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoHijoActionPerformed

    private void btnCancelarAltaPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAltaPersonaActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarAltaPersonaActionPerformed
//ESTO ES PARA ELIMINAR PERSONA EN BOTON ELIMINAR
        //        personaDAO.delete(persona);
        //        this.dispose();// TODO add your handling code here:

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarAltaPersona;
    private javax.swing.JButton btnCancelarAltaPersona;
    private com.toedter.calendar.JCalendar cldFechNac;
    private javax.swing.JComboBox cmbCura;
    private javax.swing.JComboBox cmbProvincia;
    private javax.swing.JComboBox cmbSexo;
    private javax.swing.JComboBox cmbTipoHijo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCura;
    private javax.swing.JTextPane txtApellido;
    private javax.swing.JTextField txtBario;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtDomTutor;
    private javax.swing.JTextField txtLugarNac;
    private javax.swing.JTextField txtNacionalidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelCel;
    private javax.swing.JTextField txtTelFijo;
    // End of variables declaration//GEN-END:variables
}
