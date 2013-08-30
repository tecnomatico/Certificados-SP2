/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.imp;

import dao.ParroquiaDao;
import hibernate.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import dominio.Certificado;
import dominio.Parroquia;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Joel
 */
public class ParroquiaDaoImp implements ParroquiaDao{

    @Override
    public List<Parroquia> listarParroquia() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Parroquia.class);
        
        ArrayList<Parroquia> parroquia = (ArrayList<Parroquia>)criteria.list();
        session.close();
        return parroquia;
    }

    @Override
    public void addParroquia(Parroquia a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteParroquia(Parroquia a) {
         Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void upDateParroquia(Parroquia a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public Parroquia getParroquia(int idParroquia) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Parroquia a = (Parroquia) session.get(Parroquia.class,idParroquia);
        session.getTransaction().commit();
        session.close();
        return a;    
    }
    
}
