/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.too115.sistemabibliotecariomaven.controller;

import com.ues.too115.sistemabibliotecariomaven.models.Categoria;
import com.ues.too115.sistemabibliotecariomaven.service.CategoriaService;
import java.io.IOException;
import java.math.BigDecimal;
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
public class CategoriaController {
    
    CategoriaService categoriaService = new CategoriaService();
    
    @RequestMapping(value = "categoriaList")
    public String CategoriaList(ModelMap model) {
        String titulo = "Lista de categorias";
        List<Categoria> categorias = categoriaService.getAll();
        model.addAttribute("categorias", categorias);
        model.addAttribute("titulo", titulo);
        return "admin/categoriaList";
    }
    
    @RequestMapping(value = "categoriaEdit",method = RequestMethod.GET)
    public String CategoriaEdit(ModelMap model, HttpServletRequest request) {
        String titulo = "Editar Categoria";
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        Categoria categoria = categoriaService.getbyID(id);
        model.addAttribute("command",categoria);
        model.addAttribute("titulo", titulo);
        return "admin/categoriaEdit";
    }
    
    @RequestMapping(value = "categoriaEdit",method = RequestMethod.POST)
    public void CategoriaEdit(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        Categoria categoria = new Categoria();
        int id = Integer.parseInt(request.getParameter("id"));
        categoria.setIdcategoria(BigDecimal.valueOf(id));
        categoria.setNombrecategoria(request.getParameter("nombrecategoria"));
        categoriaService.update(categoria);
        try {
            response.sendRedirect("categoriaList");
        } catch (IOException ex) {
            Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(value = "categoriaDelete",method = RequestMethod.GET)
    public String CategoriaDelete(ModelMap model, HttpServletRequest request) {
        String titulo = "Seguro desea eliminar";
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        Categoria categoria = categoriaService.getbyID(id);
        model.addAttribute("titulo",titulo);
        model.addAttribute("command",categoria);
        return "admin/categoriaDelete";
    }
    
    @RequestMapping(value = "categoriaDelete",method = RequestMethod.POST)
    public void CategoriaDelete(HttpServletRequest request, HttpServletResponse response) {
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        categoriaService.delete(id);
        try {
            response.sendRedirect("categoriaList");
        } catch (IOException ex) {
            Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(value = "categoriaAdd", method = RequestMethod.GET)
    public String CategoriaAdd(ModelMap model, HttpServletRequest request) {
        String titulo = "Agregar nueva categoria";
        Categoria categoria = new Categoria();
        model.addAttribute("command",categoria);
        model.addAttribute("titulo", titulo);
        return "admin/categoriaAdd";
    }
    
     @RequestMapping(value = "categoriaAdd", method = RequestMethod.POST)
    public void CategoriaAdd(HttpServletRequest request, HttpServletResponse response) {
        Categoria categoria = new Categoria();
        categoria.setNombrecategoria(request.getParameter("nombrecategoria"));
        categoriaService.add(categoria);
        try {
            response.sendRedirect("categoriaList");
        } catch (IOException ex) {
            Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
