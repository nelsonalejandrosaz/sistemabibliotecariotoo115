/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.too115.sistemabibliotecariomaven.service;

import com.ues.too115.sistemabibliotecariomaven.models.Municipio;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Nelson Alejandro Saz <nelsonalejandrosaz@gmail.com>
 */
public class MunicipioService {
    
    public List<Municipio> getAll(){
        List<Municipio> municipios = new ArrayList<Municipio>();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            municipios = session.createCriteria(Municipio.class).list();
            transaction.commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return municipios;
    }
    
    public Municipio getByID(int id){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Municipio municipio = new Municipio();
        try {
            Transaction transaction = session.beginTransaction();
            municipio = (Municipio) session.get(Municipio.class,BigDecimal.valueOf(id));
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
        return municipio;
    }
    
    public List<Municipio> getByDepartamento(int id ) {
        List<Municipio> municipios = new ArrayList<Municipio>();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            String hql = "from Municipio where iddepartamento = :iddepartamento";
            Query query = session.createQuery(hql);
            query.setBigDecimal("iddepartamento", BigDecimal.valueOf(id));
            municipios= query.list();
            transaction.commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return municipios;
    }
    
}
