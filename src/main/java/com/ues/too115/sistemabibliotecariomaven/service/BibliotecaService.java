/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.too115.sistemabibliotecariomaven.service;

import com.ues.too115.sistemabibliotecariomaven.models.Biblioteca;
import java.math.BigDecimal;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Nelson Alejandro Saz <nelsonalejandrosaz@gmail.com>
 */
public class BibliotecaService {
    
    public Biblioteca getbyID(int id) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Biblioteca biblioteca = new Biblioteca();
        try {
            Transaction transaction = session.beginTransaction();
            biblioteca = (Biblioteca) session.get(Biblioteca.class, BigDecimal.valueOf(id));
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
        return biblioteca;
    }
    
}
