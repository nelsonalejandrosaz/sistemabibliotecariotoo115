package com.ues.too115.sistemabibliotecariomaven.models;
// Generated 11-24-2016 03:13:27 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Departamento generated by hbm2java
 */
public class Departamento  implements java.io.Serializable {


     private BigDecimal iddepartamento;
     private String nombredepartamento;
     private Set municipios = new HashSet(0);

    public Departamento() {
    }

	
    public Departamento(BigDecimal iddepartamento, String nombredepartamento) {
        this.iddepartamento = iddepartamento;
        this.nombredepartamento = nombredepartamento;
    }
    public Departamento(BigDecimal iddepartamento, String nombredepartamento, Set municipios) {
       this.iddepartamento = iddepartamento;
       this.nombredepartamento = nombredepartamento;
       this.municipios = municipios;
    }
   
    public BigDecimal getIddepartamento() {
        return this.iddepartamento;
    }
    
    public void setIddepartamento(BigDecimal iddepartamento) {
        this.iddepartamento = iddepartamento;
    }
    public String getNombredepartamento() {
        return this.nombredepartamento;
    }
    
    public void setNombredepartamento(String nombredepartamento) {
        this.nombredepartamento = nombredepartamento;
    }
    public Set getMunicipios() {
        return this.municipios;
    }
    
    public void setMunicipios(Set municipios) {
        this.municipios = municipios;
    }




}


