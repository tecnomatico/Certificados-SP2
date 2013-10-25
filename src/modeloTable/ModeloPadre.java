/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloTable;

import dao.imp.PersonaDAOImp;
import dominio.Persona;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import util.FechaUtil;

/**
 *
 * @author dario
 */
public class ModeloPadre extends AbstractTableModel{
    Persona persona = new Persona();
    PersonaDAOImp personaDAO = new PersonaDAOImp();
    ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
  
    public ModeloPadre(String sexo) {            
        try {
            listaPersonas = personaDAO.getAllPadrexSexo(sexo);
                       
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
           
            case 0:objeto = persona.getApellido();break;
            case 1:objeto = persona.getNombre();break;
            case 2:objeto = persona.getNacionalidad();break;          
//            case 4:objeto =            
        }      
        return objeto;
    }
    
    private String[] cabeceras = {
         "Apellido/s", "Nombres", "Nacionalidad"       
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
