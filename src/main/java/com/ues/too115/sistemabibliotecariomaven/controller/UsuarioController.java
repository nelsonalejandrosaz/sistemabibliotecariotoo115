/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.too115.sistemabibliotecariomaven.controller;

import com.ues.too115.sistemabibliotecariomaven.models.Departamento;
import com.ues.too115.sistemabibliotecariomaven.models.Municipio;
import com.ues.too115.sistemabibliotecariomaven.models.Persona;
import com.ues.too115.sistemabibliotecariomaven.models.Usuario;
import com.ues.too115.sistemabibliotecariomaven.service.DepartamentoService;
import com.ues.too115.sistemabibliotecariomaven.service.MunicipioService;
import com.ues.too115.sistemabibliotecariomaven.service.PersonaService;
import com.ues.too115.sistemabibliotecariomaven.service.UsuarioService;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Nelson Alejandro Saz <nelsonalejandrosaz@gmail.com>
 */
@Controller
public class UsuarioController {

    UsuarioService usuarioService = new UsuarioService();
    MunicipioService municipioService = new MunicipioService();
    DepartamentoService departamentoService = new DepartamentoService();
    PersonaService personaService = new PersonaService();

    @RequestMapping(value = "admin/usuarioLectorList", method = RequestMethod.GET)
    public String UsuarioLectorList(ModelMap model) {
        String titulo = "Lista de lectores registrados";
        List<Usuario> usuarios = usuarioService.getAllLector();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("titulo", titulo);
        return "admin/usuarioList";
    }

    @RequestMapping(value = "admin/usuarioAdminList", method = RequestMethod.GET)
    public String UsuarioAdminList(ModelMap model) {
        String titulo = "Lista de administradores de sistema";
        List<Usuario> usuarios = usuarioService.getAllAdmin();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("titulo", titulo);
        return "admin/usuarioList";
    }

    @RequestMapping(value = "admin/usuarioEdit", method = RequestMethod.GET)
    public String UsuarioEdit(ModelMap model, HttpServletRequest request) {
        String titulo = "Editar usaurio";
        int id = Integer.parseInt(request.getParameter("id"));
        Usuario usuario = usuarioService.getByID(id);
        model.addAttribute("command", usuario);
        model.addAttribute("titulo", titulo);
        return "admin/usuarioEdit";
    }

    @RequestMapping(value = "admin/usuarioEdit", method = RequestMethod.POST)
    public void UsuarioEdit(HttpServletRequest request, HttpServletResponse response) {
        Usuario usuario = usuarioService.getByID(Integer.parseInt(request.getParameter("id")));
        usuario.setUsuario(request.getParameter("usuario"));
        usuario.setEmail(request.getParameter("email"));
        String password = request.getParameter("password");
////        Encriptacion del pass
        if (!password.equals(usuario.getPassword())) {
            String pass = DigestUtils.sha1Hex(password);
            usuario.setPassword(pass);
        }
//        Fin del encriptado
        usuarioService.update(usuario);
        String tipoUser = usuario.getRol().toString();
        try {
            if (tipoUser.equals("1")) {
                response.sendRedirect("admin/usuarioLectorList");
            } else {
                response.sendRedirect("admin/usuarioAdminList");
            }
        } catch (IOException ex) {
            Logger.getLogger(RecursoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @RequestMapping(value = "admin/usuarioAdd", method = RequestMethod.GET)
    public String UsuarioAdd(ModelMap model, HttpServletRequest request) {
        String titulo = "Agregar usaurio";
        Usuario usuario = new Usuario();
        List<Departamento> departamentos = new ArrayList<Departamento>();
        departamentos = departamentoService.getAll();
        model.addAttribute("departamentos",departamentos);
        model.addAttribute("command", usuario);
        model.addAttribute("titulo", titulo);
        return "admin/usuarioAdd";
    }

    @RequestMapping(value = "admin/usuarioAdd", method = RequestMethod.POST)
    public void UsuarioAdd(HttpServletRequest request, HttpServletResponse response) {
        BigDecimal tipoUsuario = BigDecimal.valueOf(Integer.parseInt(request.getParameter("tipo")));
        Usuario usuario = new Usuario();
        usuario.setUsuario(request.getParameter("usuario"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setRol(tipoUsuario);
        String password = request.getParameter("password");
//        Creacion de Persona
        Persona persona = new Persona();
        int idPersona = personaService.idProx();
        persona.setIdpersona(BigDecimal.valueOf(idPersona));
        persona.setNombre(request.getParameter("nombre"));
        persona.setApellidos(request.getParameter("apellidos"));
        persona.setDui(request.getParameter("dui"));
        Municipio municipio = new Municipio();
        int idMunicipio = Integer.parseInt(request.getParameter("municipio"));
        municipio = municipioService.getByID(idMunicipio);
        persona.setMunicipio(municipio);
        personaService.add(persona);
//        Encriptacion del pass
        String pass = DigestUtils.sha1Hex(password);
        usuario.setPassword(pass);
//        Fin del encriptado
        usuario.setPersona(personaService.getByID(idPersona));
        usuarioService.add(usuario);
        String tipoUser = usuario.getRol().toString();
        try {
            if (tipoUser.equals("1")) {
                response.sendRedirect("admin/usuarioLectorList");
            } else {
                response.sendRedirect("admin/usuarioAdminList");
            }
        } catch (IOException ex) {
            Logger.getLogger(RecursoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(value = "admin/usuarioDelete", method = RequestMethod.GET)
    public String UsuarioDelete(ModelMap model, HttpServletRequest request) {
        String titulo = "Seguro desea eliminar";
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        Usuario usuario = usuarioService.getByID(id);
        model.addAttribute("titulo", titulo);
        model.addAttribute("command", usuario);
        return "admin/usuarioDelete";
    }

    @RequestMapping(value = "admin/usuarioDelete", method = RequestMethod.POST)
    public void UsuarioDelete(HttpServletRequest request, HttpServletResponse response) {
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        usuarioService.delete(id);
        personaService.delete(id);
        try {
            response.sendRedirect("admin/usuarioAdminList");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(value = "admin/municipioByDepartamento")
    public String MunicipioByDepartamento(ModelMap model, HttpServletRequest request){
        List<Municipio> municipios = municipioService.getByDepartamento(Integer.parseInt(request.getParameter("id")));
        model.addAttribute("municipios",municipios);
        return "admin/municipioByDepartamento";
    }

}
