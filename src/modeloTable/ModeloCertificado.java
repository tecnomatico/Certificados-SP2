/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloTable;

import dao.imp.CertificadoDAOImp;
import dao.imp.ParroquiaDaoImp;
import dao.imp.PersonaDAOImp;
import dominio.Certificado;
import dominio.Parroquia;
import dominio.Persona;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.AbstractTableModel;
import util.FechaUtil;

/**
 *
 * @author dario
 */
public class ModeloCertificado extends AbstractTableModel{
    Certificado certificado = new Certificado();

    CertificadoDAOImp certificadoDAO = new CertificadoDAOImp();
    ArrayList<Certificado> listaCertificado = new ArrayList<Certificado>();
//    ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
//    Persona cura = new Persona();
    Persona ahijado = new Persona();
    Persona tutor = new Persona();
    Persona padrino = new Persona();
    PersonaDAOImp personaDAO = new PersonaDAOImp();
    
    Parroquia p = new ParroquiaDaoImp().listarParroquia().get(0);
    
    public ModeloCertificado() {            
        try {
            listaCertificado = certificadoDAO.getAll();;
                       
        } catch (ClassCastException ex) {
            listaCertificado = new ArrayList<Certificado>();            
        }finally{
        }
    }

    public final void actualizar() {
        fireTableDataChanged();
    }    
    @Override
    public int getRowCount() {
        return listaCertificado.size();
    }

    @Override
    public int getColumnCount() {
        return cabeceras.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object objeto = new Object();       
        certificado = (Certificado) listaCertificado.get(rowIndex);
        ahijado = personaDAO.getPersona(certificado.getIdAhijado());
        tutor = personaDAO.getPersona(certificado.getIdTutor());
        switch (columnIndex) {
            case 0:objeto = certificado.getNumeroCertificado();break;
            case 1:objeto = FechaUtil.getDateDD_MM_AAAA(certificado.getFechaBautizmo());break;
            // problemas para cargar varios curas
            case 2:objeto = certificado.getNombreCura();break; 
            case 3:objeto = ahijado.getApellido()+" "+ahijado.getNombre();break;
            case 4:objeto = ahijado.getDni();break;                                                       
        }      
        return objeto;
    }
    
    private String[] cabeceras = {
        "N° Certif", "Fecha Bautismo", "Parroco", "Bautizado", "Dni"       
    };
    
    public Certificado Consulta(int col) {
        return (Certificado) listaCertificado.get(col);
    }
    
    @Override
    public String getColumnName(int column) {
        return cabeceras[column];
    }
    
    public void addElement(Object nuevoElemento){
        listaCertificado.add((Certificado)nuevoElemento);        
        actualizar();
    }
    
    public Certificado getCertificado(int fila){
        return listaCertificado.get(fila);
    }
    
    public void removeElement(Object elemento)
    {
        listaCertificado.remove(elemento);
        actualizar();
    }
    
    
}
