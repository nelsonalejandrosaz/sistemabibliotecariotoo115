/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.too115.sistemabibliotecariomaven.service;

import com.ues.too115.sistemabibliotecariomaven.models.Persona;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Nelson Alejandro Saz <nelsonalejandrosaz@gmail.com>
 */
public class PersonaService {
    
    public List<Persona> getAll(){
        List<Persona> personas = new ArrayList<Persona>();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            personas = session.createCriteria(Persona.class).list();
            transaction.commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return personas;
    }
    
    public Persona getByID(int id){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Persona persona = new Persona();
        try {
            Transaction transaction = session.beginTransaction();
            persona = (Persona) session.get(Persona.class,BigDecimal.valueOf(id));
//            String queryString = "from Subcategoria where idSubcategoria = :id ";
//            Query query = session.createQuery(queryString);
//            query.setInteger("id", id);
//            subcategoria = (Subcategoria) query.uniqueResult();
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return persona;
    }
    
    public void update(Persona persona) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.update(persona);
            transaction.commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    
    public void add(Persona persona) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(persona);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    
    public void delete(int id) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Persona persona = getByID(id);
        try {
            Transaction transaction = session.beginTransaction();
            session.delete(persona);
            transaction.commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    
    public int idProx() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
//            Identificacion del ultimo ID para asignarlo a la clase            
            List<Persona> personas = new ArrayList<Persona>();
            int id = 1;
            personas = getAll();
            for (int i = 0; i < personas.size(); i++) {
                if (id < Integer.parseInt(personas.get(i).getIdpersona().toString())) {
                    id = Integer.parseInt(personas.get(i).getIdpersona().toString());
                }
            }
//            Fin de metodo para el id
            return id + 1;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return 0;
        }
    }
    
}
