/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import vista.BusquedaCertificado;
import vista.BusquedaPersona;
import dao.CertificadoDAO;
import dao.PersonaDAO;
import dao.imp.CertificadoDAOImp;
import dao.imp.PersonaDAOImp;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import modelo.Certificado;
import modelo.Persona;
import vista.PersonaEditadaCertificado;

/**
 *
 * @author dario
 */
public final class ActualizacionCertificado extends javax.swing.JDialog {
    
    //String padre;
    private static String sCura;
    private static String sAhijado;
    private static String sTutor;
    private static String sTutora;
    private static String sPadrino;
    private static String sMadrina;
    private static Persona pCura;
    private static Persona pAhijado;
    private static Persona pTutor;
    private static Persona pTutora;
    private static Persona pPadrino;
    private static Persona pMadrina;
    private String qPersona;
    private Integer idPersona;
    private String seraCura;
    Certificado certificado;
    CertificadoDAO certificadoDAO = new CertificadoDAOImp();
    private static Persona cura;
    private static Persona niño;
    private static Persona padre;
    private static Persona madre;
    private static Persona padrino;
    private static Persona madrina;
        
    
    PersonaDAO personaDAO = new PersonaDAOImp();
    int n;
    /**
     * Creates new form AltaPersonas
     */
    ActualizacionCertificado(BusquedaCertificado aThis, boolean b, Certificado certificado, String qOperacion) {
        super(aThis, b);
        initComponents();
        setLocationRelativeTo(aThis);
        this.certificado = certificado;
        cargaCmb();        
        txtNombParroquia.setText(this.certificado.getNombreParroquia());
        txtDomiParroq.setText(this.certificado.getDomicilioParooquia());
        txtBarrio.setText(this.certificado.getBarrioParroquia());
        cura = personaDAO.getPersona(this.certificado.getIdCura());
        txtCura.setText(cura.getApellido()+", "+cura.getNombre());
        
        niño = personaDAO.getPersona(this.certificado.getIdAhijado());
        txtNombNiño.setText(niño.getApellido()+", "+niño.getNombre());
        txtDNI.setText(niño.getDni());
        cldFechaNac.setDate(niño.getFechaNaciemiento());
        txtLugarNac.setText(niño.getLugarNacimiento());
        
        padre = personaDAO.getPersona(this.certificado.getIdTutor());
        txtNombPadre.setText(padre.getApellido()+", "+padre.getNombre());
        
        madre = personaDAO.getPersona(this.certificado.getIdTutora());
        txtNombMadre.setText(madre.getApellido()+", "+madre.getNombre());
        txtDomPadres.setText(this.certificado.getDomicilioPadres());
        cldFechaBautismo.setDate(this.certificado.getFechaBautizmo());
        
        padrino = personaDAO.getPersona(this.certificado.getIdPadrino());
        txtNombPadrino.setText(padrino.getApellido()+", "+padrino.getNombre());
        
        madrina = personaDAO.getPersona(this.certificado.getIdMadrina());
        txtNombMadrina.setText(madrina.getApellido()+", "+madrina.getNombre());
        
        txtLibro.setText(this.certificado.getLibro());
        txtPartida.setText(this.certificado.getPartida());
        txtFolio.setText(this.certificado.getFolio());
        txtAreaNotaMarginal.setText(this.certificado.getNotasMarginales());

    }

    ActualizacionCertificado(BusquedaPersona aThis, boolean b) {
        super(aThis, b);
        initComponents();
        setLocationRelativeTo(aThis);
    }

    public void agregar(Persona p,String qPersona){
        this.qPersona = qPersona;
        //this.idPersona = idPerso;
        
        if ("cura".equals(qPersona)) {
            txtCura.setText(p.getApellido()+", "+p.getNombre());
            pCura = p;
            sCura = qPersona;
        } else {
            if ("tutor".equals(qPersona)) {
                txtNombPadre.setText(p.getApellido()+", "+p.getNombre());
                pTutor = p;
                sTutor = qPersona;
            } else {
                if ("tutora".equals(qPersona)) {
                    txtNombMadre.setText(p.getApellido()+", "+p.getNombre());
                    pTutora = p;
                    sTutora = qPersona;
                } else {
                    if ("padrino".equals(qPersona)) {
                        txtNombPadrino.setText(p.getApellido()+", "+p.getNombre());
                        pPadrino = p;
                        sPadrino = qPersona;
                    } else {
                        if ("madrina".equals(qPersona)) {
                            txtNombMadrina.setText(p.getApellido()+", "+p.getNombre());
                            pMadrina = p;
                            sMadrina = qPersona;
                        } else {
                            txtNombNiño.setText(p.getApellido()+", "+p.getNombre());
                            txtDNI.setText(p.getDni());
                            cldFechaNac.setDate(p.getFechaNaciemiento());
                            txtLugarNac.setText(p.getLugarNacimiento());
                            pAhijado = p;
                            sAhijado = qPersona;
                        }
                    }
                }
            }
        }
        p = null;
    }
    
    public void cargaCmb(){
        String [] ciudad = {" ","San Salvador de Jujuy", "Abra Pampa", "Abralaite", "Aguas Calientes", "Alfarcito", "Arrayanal", "Arroyo Colorado", "Bárcena", "Barrancas", "Barrios", "Bermejito", "Caimancito", "Calilegua", "Cangrejillos", "Carahunco", "Casabindo", "Casira", "Caspalá", "Catúa", "Centro Forestal", "Chalicán", "Cieneguillas", "Cochinoca", "Coctaca", "Colonia San José", "El Cóndor", "Coranzulí", "Cusi Cusi", "Don Emilio", "El Acheral", "El Aguilar", "El Angosto", "El Bananal", "El Carmen", "El Ceibal", "El Fuerte", "El Moreno", "El Piquete", "El Puesto", "El Quemado", "El Talar", "El Toro", "Fraile Pintado", "Guerrero", "Hipólito Yrigoyen", "Iturbe", "Hornaditas", "Huacalera", "Huancar", "Humahuaca", "Juella", "La Almona", "La Ciénaga", "La Esperanza", "La Intermedia", "La Manga", "La Mendieta", "La Quiaca", "Lagunillas", "León", "Libertador General San Martín", "Libertad", "Liviara", "Llulluchayoc", "Los Lapachos", "Los Manatiales", "Loteo Navea", "Lozano", "Maimará", "Mina 9 de Octubre", "Mina Pirquitas", "Miraflores", "Misa Rumi", "Monterrico", "Ocloyas", "Olaroz Chico", "Oratorio", "Paicone", "Palma Sola", "Palo Blanco", "Palpalá", "Pampa Planca", "Pampichuela", "Parapeti", "Paulina", "Perico", "Piedritas", "Puente Lavayén", "Puesto del Marqués", "Puesto Sey", "Puesto Viejo", "Pumahuasi", "Purmamarca", "Rinconada", "Rinconadilla", "Rodeíto", "Rosario del Río Grande", "San Antonio", "San Pedro", "San Francisco", "San Juan de Oros", "San Lucas", "San Pedro de Jujuy", "Santa Ana", "Santa Catalina", "Santa Clara", "Sauzal", "Susques", "Tabladitas", "Tafna", "Termas de Reyes", "Tilcara", "Tiraxi", "Tres Cruces", "Tres Pozos", "Tumbaya", "Tusaquillas", "Uquía", "Valle Colorado", "Valle Grande", "Vinalito", "Volcán", "Yala", "Yavi", "Yavi Chico", "Yoscaba", "Yuto"};
        
        cmbCiudad.addItem(certificado.getCiudad());
        for (int i = 0; i < 5; i++) {
            if (ciudad[i].equals(certificado.getCiudad())) {
            }else{
                cmbCiudad.addItem(ciudad[i]);                            
            }
            
        }  
        String [] provincia = {" ","Jujuy", "Catamarca", "Chaco", "Chubut", "Córdoba", "Corrientes", "Entre Ríos", "Formosa", "La Pampa", "La Rioja", "Mendoza", "Misiones", "Neuquén", "Río Negro", "Salta", "San Juan", "San Luis", "Santa Cruz", "Santa Fe", "Santiago del Estero", "Tucumán", "Tierra del Fuego", "Buenos Aires"};
        
        cmbProvincia.addItem(certificado.getProvincia());
        for (int i = 0; i < 2; i++) {
            if (provincia[i].equals(certificado.getProvincia())) {
            }else{
                cmbProvincia.addItem(provincia[i]);                            
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNombParroquia = new javax.swing.JTextPane();
        txtDomiParroq = new javax.swing.JTextField();
        txtLugarNac = new javax.swing.JTextField();
        cmbProvincia = new javax.swing.JComboBox();
        btnAceptarAltaPersona = new javax.swing.JButton();
        btnCancelarAltaPersona = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtBarrio = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtLibro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPartida = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtFolio = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        lblCura = new javax.swing.JLabel();
        txtCura = new javax.swing.JTextField();
        txtNombNiño = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtNombPadre = new javax.swing.JTextField();
        txtNombMadre = new javax.swing.JTextField();
        txtDomPadres = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cmbCiudad = new javax.swing.JComboBox();
        cldFechaBautismo = new com.toedter.calendar.JCalendar();
        jLabel19 = new javax.swing.JLabel();
        txtNombPadrino = new javax.swing.JTextField();
        txtNombMadrina = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaNotaMarginal = new javax.swing.JTextArea();
        cldFechaNac = new com.toedter.calendar.JCalendar();
        btnEditarCura = new javax.swing.JButton();
        btnEditarNiño = new javax.swing.JButton();
        btnEditarPadre = new javax.swing.JButton();
        btnEditarMadre = new javax.swing.JButton();
        btnEditarPadrino = new javax.swing.JButton();
        btnEditarMadrina = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("txtNacionalidad");
        getContentPane().setLayout(null);

        jLabel1.setText("Parroquia:");

        jLabel2.setText("Domicilio de Parroquia:");

        jLabel3.setText("Pbro./Diacono:");

        jLabel4.setText("Nombre del Niño:");

        jLabel5.setText("Lugar de Nacimiento:");

        jLabel6.setText("Provincia de Nacimiento:");

        jLabel7.setText("Ciudad:");

        jScrollPane1.setViewportView(txtNombParroquia);

        txtDomiParroq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDomiParroqActionPerformed(evt);
            }
        });

        txtLugarNac.setEditable(false);

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

        jLabel8.setText("Barrio:");

        txtBarrio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBarrioActionPerformed(evt);
            }
        });

        jLabel9.setText("Libro:");

        jLabel10.setText("Partida:");

        jLabel11.setText("Folio:");

        jLabel12.setText("Notas Marginales:");

        txtFolio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFolioActionPerformed(evt);
            }
        });

        jLabel13.setText("Nombre Madrina:");

        lblCura.setText("Nombre Padrino:");

        jLabel14.setText("Fecha de Nacimiento:");

        jLabel15.setText("D.N.I.:");

        txtDNI.setEditable(false);

        jLabel17.setText("Nombre Padre:");

        jLabel16.setText("Nombre Madre:");

        jLabel18.setText("Domicilio Padres:");

        jLabel19.setText("Fecha dia del Bautismo:");

        txtAreaNotaMarginal.setColumns(20);
        txtAreaNotaMarginal.setRows(5);
        jScrollPane2.setViewportView(txtAreaNotaMarginal);

        btnEditarCura.setText("Editar");
        btnEditarCura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCuraActionPerformed(evt);
            }
        });

        btnEditarNiño.setText("Editar");
        btnEditarNiño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarNiñoActionPerformed(evt);
            }
        });

        btnEditarPadre.setText("Editar");
        btnEditarPadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPadreActionPerformed(evt);
            }
        });

        btnEditarMadre.setText("Editar");
        btnEditarMadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarMadreActionPerformed(evt);
            }
        });

        btnEditarPadrino.setText("Editar");
        btnEditarPadrino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPadrinoActionPerformed(evt);
            }
        });

        btnEditarMadrina.setText("Editar");
        btnEditarMadrina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarMadrinaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(77, 77, 77)
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtLugarNac, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel16)
                                            .addGap(32, 32, 32))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(20, 20, 20)
                                                    .addComponent(jLabel17))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(16, 16, 16)
                                                    .addComponent(jLabel18)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNombPadre)
                                        .addComponent(txtNombMadre)
                                        .addComponent(txtDomPadres, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnEditarPadre)
                                        .addComponent(btnEditarMadre))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addComponent(jLabel3)
                                                .addGap(27, 27, 27))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel14)
                                                    .addComponent(jLabel8)
                                                    .addComponent(jLabel15))
                                                .addGap(18, 18, 18)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(txtCura, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(btnEditarCura))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(txtNombNiño, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(btnEditarNiño))))
                                            .addComponent(cldFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(473, 473, 473)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jScrollPane1)
                                                    .addComponent(txtDomiParroq, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(35, 35, 35)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCura)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombPadrino)
                                    .addComponent(txtNombMadrina, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEditarPadrino)
                                    .addComponent(btnEditarMadrina))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtPartida, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtFolio)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cldFechaBautismo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(71, 71, 71))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAceptarAltaPersona)
                        .addGap(61, 61, 61)
                        .addComponent(btnCancelarAltaPersona)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 952, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cldFechaBautismo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDomiParroq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditarCura))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(cldFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtLugarNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(txtNombPadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEditarPadre))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNombMadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)
                                    .addComponent(btnEditarMadre))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDomPadres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(cmbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(cmbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNombNiño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEditarNiño))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCura)
                                    .addComponent(txtNombPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEditarPadrino))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(txtNombMadrina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEditarMadrina))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAceptarAltaPersona)
                            .addComponent(btnCancelarAltaPersona))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(81, 20, 0, 0);

        jLabel20.setText("jLabel20");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(0, 0, 1350, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDomiParroqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDomiParroqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDomiParroqActionPerformed

    private void btnAceptarAltaPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarAltaPersonaActionPerformed
        //Persona certificado = new Persona();        Esto es un ERRROR
//        try {
            certificado.setNombreParroquia(txtNombParroquia.getText());
            certificado.setDomicilioParooquia(txtDomiParroq.getText());
            certificado.setBarrioParroquia(txtBarrio.getText());
            if (sCura==null) {
                certificado.setIdCura(cura.getIdPersona());
            } else {
                certificado.setIdCura(pCura.getIdPersona());
            }
            
            if (sAhijado==null) {
                certificado.setIdAhijado(niño.getIdPersona());            
            }
            else{
                certificado.setIdAhijado(pAhijado.getIdPersona());            
            }

            if (sTutor==null) {
                certificado.setIdTutor(padre.getIdPersona());
            }else{
                certificado.setIdTutor(pTutor.getIdPersona());                        
            }
            
            if (sTutora==null) {
                certificado.setIdTutora(madre.getIdPersona());
            }else{
                certificado.setIdTutora(pTutora.getIdPersona());            
            }
            
            if (sPadrino==null) {
                certificado.setIdTutora(padrino.getIdPersona());
            }else{
                certificado.setIdTutora(pPadrino.getIdPersona());            
            }
            
            if (sMadrina==null) {
                certificado.setIdTutora(madrina.getIdPersona());
            }else{
                certificado.setIdTutora(pMadrina.getIdPersona());            
            }
            certificado.setFechaBautizmo(cldFechaBautismo.getDate());
            certificado.setDomicilioPadres(txtDomPadres.getText());
            certificado.setCiudad(cmbCiudad.getSelectedItem().toString());
            certificado.setProvincia(cmbProvincia.getSelectedItem().toString());
            certificado.setDomicilioPadres(txtDomPadres.getText());        
            certificado.setLibro(txtLibro.getText());
            certificado.setFolio(txtFolio.getText());
            certificado.setPartida(txtPartida.getText());
            certificado.setNotasMarginales(txtAreaNotaMarginal.getText());               

            certificadoDAO.update(certificado);
            this.dispose();
//        } catch (NullPointerException e) {
//        }

    }//GEN-LAST:event_btnAceptarAltaPersonaActionPerformed

    private void txtBarrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBarrioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBarrioActionPerformed

    private void txtFolioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFolioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFolioActionPerformed

    private void btnCancelarAltaPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAltaPersonaActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarAltaPersonaActionPerformed

    private void btnEditarCuraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCuraActionPerformed
        Persona p = new Persona();        
        PersonaEditadaCertificado bp = new PersonaEditadaCertificado(this,true,txtCura,"cura");
        bp.setVisible(true);
        bp.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnEditarCuraActionPerformed

    private void btnEditarPadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPadreActionPerformed
        Persona p = new Persona();        
        PersonaEditadaCertificado bp = new PersonaEditadaCertificado(this,true,txtNombPadre,"tutor");
        bp.setVisible(true);
        bp.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnEditarPadreActionPerformed

    private void btnEditarMadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarMadreActionPerformed
        Persona p = new Persona();        
        PersonaEditadaCertificado bp = new PersonaEditadaCertificado(this,true,txtNombMadre,"tutora");
        bp.setVisible(true);
        bp.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnEditarMadreActionPerformed

    private void btnEditarPadrinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPadrinoActionPerformed
        Persona p = new Persona();        
        PersonaEditadaCertificado bp = new PersonaEditadaCertificado(this,true,txtNombPadrino,"padrino");
        bp.setVisible(true);
        bp.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnEditarPadrinoActionPerformed

    private void btnEditarMadrinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarMadrinaActionPerformed
        Persona p = new Persona();        
        PersonaEditadaCertificado bp = new PersonaEditadaCertificado(this,true,txtNombMadrina,"madrina");
        bp.setVisible(true);
        bp.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnEditarMadrinaActionPerformed

    private void btnEditarNiñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarNiñoActionPerformed
        Persona p = new Persona();        
        PersonaEditadaCertificado bp = new PersonaEditadaCertificado(this,true,txtNombNiño,"ahijado");
        bp.setVisible(true);
        bp.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnEditarNiñoActionPerformed
//ESTO ES PARA ELIMINAR PERSONA EN BOTON ELIMINAR
        //        certificadoDAO.delete(certificado);
        //        this.dispose();// TODO add your handling code here:

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarAltaPersona;
    private javax.swing.JButton btnCancelarAltaPersona;
    private javax.swing.JButton btnEditarCura;
    private javax.swing.JButton btnEditarMadre;
    private javax.swing.JButton btnEditarMadrina;
    private javax.swing.JButton btnEditarNiño;
    private javax.swing.JButton btnEditarPadre;
    private javax.swing.JButton btnEditarPadrino;
    private com.toedter.calendar.JCalendar cldFechaBautismo;
    private com.toedter.calendar.JCalendar cldFechaNac;
    private javax.swing.JComboBox cmbCiudad;
    private javax.swing.JComboBox cmbProvincia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCura;
    private javax.swing.JTextArea txtAreaNotaMarginal;
    private javax.swing.JTextField txtBarrio;
    private javax.swing.JTextField txtCura;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDomPadres;
    private javax.swing.JTextField txtDomiParroq;
    private javax.swing.JTextField txtFolio;
    private javax.swing.JTextField txtLibro;
    private javax.swing.JTextField txtLugarNac;
    private javax.swing.JTextField txtNombMadre;
    private javax.swing.JTextField txtNombMadrina;
    private javax.swing.JTextField txtNombNiño;
    private javax.swing.JTextField txtNombPadre;
    private javax.swing.JTextField txtNombPadrino;
    private javax.swing.JTextPane txtNombParroquia;
    private javax.swing.JTextField txtPartida;
    // End of variables declaration//GEN-END:variables
}
