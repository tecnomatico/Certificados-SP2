/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloTable;

import dao.PersonaDAO;
import dao.imp.PersonaDAOImp;
import dominio.Persona;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dario
 */
public class ModeloPersona extends AbstractTableModel{
    Persona persona = new Persona();
    PersonaDAOImp personaDAO = new PersonaDAOImp();
    ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
  
    public ModeloPersona() {            
        try {
            listaPersonas = personaDAO.getAll();;
        } catch (ClassCastException ex) {
            listaPersonas = new ArrayList<Persona>();            
        }finally{
        }
    }

    public final void actualizar() {
        fireTableDataChanged();
    }    
    @Override
    public int getRowCount() {
        return listaPersonas.size();
    }

    @Override
    public int getColumnCount() {
        return cabeceras.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object objeto = new Object();
        persona = (Persona) listaPersonas.get(rowIndex);
        
        switch (columnIndex) {
            case 0:objeto = persona.getDni();break;
            case 1:objeto = persona.getApellido();break;
            case 2:objeto = persona.getNombre();break;
            case 3:objeto = persona.getDomicilio();break;           
            case 4:objeto = persona.getFechaNaciemiento();break;           
        }      
        return objeto;
    }
    
    private String[] cabeceras = {
        "Documento", "Apellido/s", "Nombres", "Domicilio"       
    };
    
    public Persona Consulta(int col) {
        return (Persona) listaPersonas.get(col);
    }
    
    @Override
    public String getColumnName(int column) {
        return cabeceras[column];
    }
    
    public void addElement(Object nuevoElemento){
        listaPersonas.add((Persona)nuevoElemento);        
        actualizar();
    }
    
    public Persona getPersona(int fila){
        return listaPersonas.get(fila);
    }
    
    public void removeElement(Object elemento)
    {
        listaPersonas.remove(elemento);
        actualizar();
    }
    
    
}
