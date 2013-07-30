/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import modelo.Certificado;

/**
 *
 * @author dario
 */
public interface CertificadoDAO {
    public ArrayList<Certificado> getAll();
    public Certificado getCertificado(String numeroCertificado);
    public void insert (Certificado unCertificado);
    public void update (Certificado unCertificado);
    public void delete (Certificado unCertificado);
}
