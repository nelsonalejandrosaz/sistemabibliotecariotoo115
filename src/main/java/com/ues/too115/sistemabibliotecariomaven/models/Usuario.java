package com.ues.too115.sistemabibliotecariomaven.models;
// Generated 11-24-2016 03:13:27 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private BigDecimal idusuario;
     private Persona persona;
     private String usuario;
     private String password;
     private BigDecimal rol;
     private String email;
     private Set prestamos = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(BigDecimal idusuario, Persona persona, String usuario, String password, BigDecimal rol, String email) {
        this.idusuario = idusuario;
        this.persona = persona;
        this.usuario = usuario;
        this.password = password;
        this.rol = rol;
        this.email = email;
    }
    public Usuario(BigDecimal idusuario, Persona persona, String usuario, String password, BigDecimal rol, String email, Set prestamos) {
       this.idusuario = idusuario;
       this.persona = persona;
       this.usuario = usuario;
       this.password = password;
       this.rol = rol;
       this.email = email;
       this.prestamos = prestamos;
    }
   
    public BigDecimal getIdusuario() {
        return this.idusuario;
    }
    
    public void setIdusuario(BigDecimal idusuario) {
        this.idusuario = idusuario;
    }
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public BigDecimal getRol() {
        return this.rol;
    }
    
    public void setRol(BigDecimal rol) {
        this.rol = rol;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Set getPrestamos() {
        return this.prestamos;
    }
    
    public void setPrestamos(Set prestamos) {
        this.prestamos = prestamos;
    }




}


