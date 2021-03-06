package com.ues.too115.sistemabibliotecariomaven.models;
// Generated 11-24-2016 03:13:27 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * Prestamo generated by hbm2java
 */
public class Prestamo  implements java.io.Serializable {


     private BigDecimal idprestamo;
     private Usuario usuario;
     private Recurso recurso;
     private Date fechainicio;
     private Date fechafin;
     private String observaciones;

    public Prestamo() {
    }

	
    public Prestamo(BigDecimal idprestamo, Usuario usuario, Recurso recurso, Date fechainicio, Date fechafin) {
        this.idprestamo = idprestamo;
        this.usuario = usuario;
        this.recurso = recurso;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
    }
    public Prestamo(BigDecimal idprestamo, Usuario usuario, Recurso recurso, Date fechainicio, Date fechafin, String observaciones) {
       this.idprestamo = idprestamo;
       this.usuario = usuario;
       this.recurso = recurso;
       this.fechainicio = fechainicio;
       this.fechafin = fechafin;
       this.observaciones = observaciones;
    }
   
    public BigDecimal getIdprestamo() {
        return this.idprestamo;
    }
    
    public void setIdprestamo(BigDecimal idprestamo) {
        this.idprestamo = idprestamo;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Recurso getRecurso() {
        return this.recurso;
    }
    
    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }
    public Date getFechainicio() {
        return this.fechainicio;
    }
    
    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }
    public Date getFechafin() {
        return this.fechafin;
    }
    
    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }
    public String getObservaciones() {
        return this.observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }




}


