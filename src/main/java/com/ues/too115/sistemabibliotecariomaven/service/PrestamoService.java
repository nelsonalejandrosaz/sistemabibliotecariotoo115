/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.too115.sistemabibliotecariomaven.service;

import com.ues.too115.sistemabibliotecariomaven.models.Prestamo;
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
public class PrestamoService {
    
    public List<Prestamo> getAll(){
        List<Prestamo> prestamos = new ArrayList<Prestamo>();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            prestamos = session.createCriteria(Prestamo.class).list();
            transaction.commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return prestamos;
    }
    
    public Prestamo getByID(int id){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Prestamo prestamo = new Prestamo();
        try {
            Transaction transaction = session.beginTransaction();
            prestamo = (Prestamo) session.get(Prestamo.class,BigDecimal.valueOf(id));
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
        return prestamo;
    }
    
    public void update(Prestamo prestamo) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.update(prestamo);
            transaction.commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    
    public void add(Prestamo prestamo) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
//            Identificacion del ultimo ID para asignarlo a la clase            
            List<Prestamo> prestamos = new ArrayList<Prestamo>();
            int id = 1;
            prestamos = getAll();
            for (int i = 0; i < prestamos.size(); i++) {
                if (id < Integer.parseInt(prestamos.get(i).getIdprestamo().toString())) {
                    id = Integer.parseInt(prestamos.get(i).getIdprestamo().toString());
                }
            }
//            Fin de metodo para el id
            prestamo.setIdprestamo(BigDecimal.valueOf(id + 1));
            session.save(prestamo);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    
    public void delete(int id) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Prestamo prestamo = getByID(id);
        try {
            Transaction transaction = session.beginTransaction();
            session.delete(prestamo);
            transaction.commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    
}
