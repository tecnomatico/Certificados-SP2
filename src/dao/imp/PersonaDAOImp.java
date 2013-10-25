/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.imp;

import dao.PersonaDAO;
import hibernate.HibernateUtil;
import java.util.ArrayList;
import dominio.Persona;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author dario
 */
public class PersonaDAOImp implements PersonaDAO {

    @Override
    public ArrayList<Persona> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Persona.class);
        criteria.addOrder(Order.asc("dni"));
        ArrayList<Persona> personas = (ArrayList<Persona>) criteria.list();
        session.close();
        return personas;
    }

    @Override
    public Persona getPersona(int idPersona) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Persona.class);
        criteria.add(Restrictions.eq("id", idPersona));
        Persona persona = (Persona) criteria.list().get(0);
        session.close();
        return persona;
    }

    @Override
    public void insert(Persona unaPersona) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unaPersona);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Persona unaPersona) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unaPersona);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Persona unaPersona) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(unaPersona);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public ArrayList<Persona> getAllPadres() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ArrayList<Persona> lista = (ArrayList<Persona>) session.createQuery("from Persona where dni='0'").list();

        session.close();
        return lista;
    }

    @Override
    public ArrayList<Persona> getAllAhijados() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ArrayList<Persona> lista = (ArrayList<Persona>) session.createQuery("from Persona where dni<>'0'").list();

        session.close();
        return lista;
    }

    @Override
    public ArrayList<Persona> getAllPadrexSexo(String sexo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ArrayList<Persona> lista = (ArrayList<Persona>) session.createQuery("from Persona where dni='0' and sexo='"+sexo+"'").list();
        session.close();
        return lista;
    }

    @Override
    public Persona getPersonaxDNI(int dni) {
      Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Persona persona = (Persona) session.createQuery("from Persona where dni'"+dni+"'").uniqueResult();

        session.close();
        return persona;
    }
}
