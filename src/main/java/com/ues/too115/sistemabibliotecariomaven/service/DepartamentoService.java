/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.too115.sistemabibliotecariomaven.service;

import com.ues.too115.sistemabibliotecariomaven.models.Departamento;
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
public class DepartamentoService {
    
    public List<Departamento> getAll(){
        List<Departamento> departamentos = new ArrayList<Departamento>();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            departamentos = session.createCriteria(Departamento.class).list();
            transaction.commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return departamentos;
    }
    
    public Departamento getByID(int id){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Departamento departamento = new Departamento();
        try {
            Transaction transaction = session.beginTransaction();
            departamento = (Departamento) session.get(Departamento.class,BigDecimal.valueOf(id));
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
        return departamento;
    }
    
}
