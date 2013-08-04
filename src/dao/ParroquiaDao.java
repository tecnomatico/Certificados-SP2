/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Parroquia;

/**
 *
 * @author Joel
 */
public interface ParroquiaDao {
  java.util.List<Parroquia> listarParroquia();
  public void addParroquia(Parroquia a);
  public void deleteParroquia(Parroquia a);
  public void upDateParroquia(Parroquia a);
  public Parroquia getParroquia(int idParroquia);
}
