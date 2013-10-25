/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import dominio.Persona;

/**
 *
 * @author dario
 */
public interface PersonaDAO {
    public ArrayList<Persona> getAll();
    public ArrayList<Persona> getAllPadres();
    public ArrayList<Persona> getAllPadrexSexo(String sexo);
    public ArrayList<Persona> getAllAhijados();
    public Persona getPersonaxDNI(int dni);
    public Persona getPersona(int idPersona);
    public void insert (Persona unaPersona);
    public void update (Persona unaPersona);
    public void delete (Persona unaPersona);
}
