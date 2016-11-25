/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.too115.sistemabibliotecariomaven.controller;

import com.ues.too115.sistemabibliotecariomaven.models.Biblioteca;
import com.ues.too115.sistemabibliotecariomaven.models.Categoria;
import com.ues.too115.sistemabibliotecariomaven.models.Recurso;
import com.ues.too115.sistemabibliotecariomaven.models.Subcategoria;
import com.ues.too115.sistemabibliotecariomaven.service.BibliotecaService;
import com.ues.too115.sistemabibliotecariomaven.service.CategoriaService;
import com.ues.too115.sistemabibliotecariomaven.service.RecursoService;
import com.ues.too115.sistemabibliotecariomaven.service.SubcategoriaService;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Nelson Alejandro Saz <nelsonalejandrosaz@gmail.com>
 */
@Controller
public class RecursoController {

    SubcategoriaService subcategoriaDAO = new SubcategoriaService();
    CategoriaService categoriaDAO = new CategoriaService();
    RecursoService recursoDAO = new RecursoService();
    BibliotecaService bibliotecaDAO = new BibliotecaService();

    @RequestMapping(value = "recursoList", method = RequestMethod.GET)
    public String RecursoList(ModelMap model) {
        String titulo = "Lista de RECURSOS";
        List<Recurso> recursos = recursoDAO.getAll();
        model.addAttribute("recursos", recursos);
        model.addAttribute("titulo", titulo);
        return "admin/recursoList";
    }

    @RequestMapping(value = "recursoEdit", method = RequestMethod.GET)
    public String RecursoEdit(ModelMap model, HttpServletRequest request) {
        String titulo = "Editar Recurso";
        int id = Integer.parseInt(request.getParameter("id"));
        Recurso recurso = recursoDAO.getByID(id);
        List<Categoria> categorias = new ArrayList<Categoria>();
        categorias = categoriaDAO.getAll();
        model.addAttribute("command", recurso);
        model.addAttribute("titulo", titulo);
        model.addAttribute("categorias", categorias);
        return "admin/recursoEdit";
    }

    @RequestMapping(value = "recursoEdit", method = RequestMethod.POST)
    public void RecursoEdit(HttpServletRequest request, HttpServletResponse response) {
        int idSubcategoria = Integer.parseInt(request.getParameter("subcategoria"));
        Subcategoria subcategoria = subcategoriaDAO.getbyID(idSubcategoria);
        Recurso recurso = recursoDAO.getByID(Integer.parseInt(request.getParameter("id")));
        recurso.setNombrerecurso(request.getParameter("nombrerecurso"));
        recurso.setSubcategoria(subcategoria);
        recurso.setDescripcion(request.getParameter("descripcion"));
        recurso.setSinopsis(request.getParameter("sinopsis"));
        recurso.setAutores(request.getParameter("autores"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaString = request.getParameter("fecha");
        Date fecha;
        try {
            fecha = sdf.parse(fechaString);
            recurso.setFecha(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(RecursoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        recurso.setVolumen(BigDecimal.valueOf(Integer.parseInt(request.getParameter("volumen"))));
        recurso.setUnidades(BigDecimal.valueOf(Integer.parseInt(request.getParameter("unidades"))));
        recurso.setEditorial(request.getParameter("editorial"));
        recurso.setImagen(request.getParameter("imagen"));
        recurso.setFormato(request.getParameter("formato"));
        recurso.setPrestamointerno(BigDecimal.valueOf(Integer.parseInt(request.getParameter("prestamointerno"))));
        recursoDAO.update(recurso);
        try {
            response.sendRedirect("recursoList");
        } catch (IOException ex) {
            Logger.getLogger(RecursoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @RequestMapping(value = "recursoAdd", method = RequestMethod.GET)
    public String RecursoAdd(ModelMap model, HttpServletRequest request) {
        String titulo = "Agregar Recurso";
        Recurso recurso = new Recurso();
        List<Categoria> categorias = new ArrayList<Categoria>();
        categorias = categoriaDAO.getAll();
        model.addAttribute("command", recurso);
        model.addAttribute("titulo", titulo);
        model.addAttribute("categorias", categorias);
        return "admin/recursoAdd";
    }

    @RequestMapping(value = "recursoAdd.html", method = RequestMethod.POST)
    public void RecursoAdd(HttpServletRequest request, HttpServletResponse response) {
        int idSubcategoria = Integer.parseInt(request.getParameter("subcategoria"));
        Subcategoria subcategoria = subcategoriaDAO.getbyID(idSubcategoria);
        Recurso recurso = new Recurso();
        recurso.setNombrerecurso(request.getParameter("nombrerecurso"));
        recurso.setSubcategoria(subcategoria);
        recurso.setDescripcion(request.getParameter("descripcion"));
        recurso.setSinopsis(request.getParameter("sinopsis"));
        recurso.setAutores(request.getParameter("autores"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaString = request.getParameter("fecha");
        Date fecha;
        try {
            fecha = sdf.parse(fechaString);
            recurso.setFecha(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(RecursoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        recurso.setVolumen(BigDecimal.valueOf(Integer.parseInt(request.getParameter("volumen"))));
        recurso.setUnidades(BigDecimal.valueOf(Integer.parseInt(request.getParameter("unidades"))));
        recurso.setEditorial(request.getParameter("editorial"));
        recurso.setImagen(request.getParameter("imagen"));
        recurso.setFormato(request.getParameter("formato"));
        recurso.setPrestamointerno(BigDecimal.valueOf(Integer.parseInt(request.getParameter("prestamointerno"))));
        Biblioteca biblioteca = bibliotecaDAO.getbyID(1);
        recurso.setBiblioteca(biblioteca);
        recursoDAO.add(recurso);
        try {
            response.sendRedirect("recursoList");
        } catch (IOException ex) {
            Logger.getLogger(RecursoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @RequestMapping(value = "recursoDelete", method = RequestMethod.GET)
    public String RecursoDelete(ModelMap model, HttpServletRequest request) {
        String titulo = "Seguro desea eliminar";
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        Recurso recurso = recursoDAO.getByID(id);
        model.addAttribute("titulo", titulo);
        model.addAttribute("command", recurso);
        return "admin/recursoDelete";
    }

    @RequestMapping(value = "recursoDelete", method = RequestMethod.POST)
    public void RecursoDelete(HttpServletRequest request, HttpServletResponse response) {
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        recursoDAO.delete(id);
        try {
            response.sendRedirect("recursoList");
        } catch (IOException ex) {
            Logger.getLogger(RecursoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
