/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.imp;

import dao.CertificadoDAO;
import hibernate.HibernateUtil;
import java.util.ArrayList;
import dominio.Certificado;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author dario
 */
public class CertificadoDAOImp implements CertificadoDAO{

    @Override
    public ArrayList<Certificado> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Certificado.class);
        criteria.addOrder(Order.asc("numeroCertificado"));
        ArrayList<Certificado> certificados = (ArrayList<Certificado>)criteria.list();
        session.close();
        return certificados;
    }

    @Override
    public Certificado getCertificado(String numeroCertificado) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Certificado.class);
        criteria.add(Restrictions.eq("numeroCertificado", numeroCertificado));
        Certificado certificado = (Certificado)criteria.list().get(0);
        session.close();
        return certificado;
    }

    @Override
    public void insert(Certificado unCertificado) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unCertificado);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Certificado unCertificado) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unCertificado);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Certificado unCertificado) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(unCertificado);
        session.getTransaction().commit();
        session.close();
    }
    
}
