/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.too115.sistemabibliotecariomaven.controller;

import com.ues.too115.sistemabibliotecariomaven.models.Categoria;
import com.ues.too115.sistemabibliotecariomaven.models.Subcategoria;
import com.ues.too115.sistemabibliotecariomaven.service.CategoriaService;
import com.ues.too115.sistemabibliotecariomaven.service.SubcategoriaService;
import java.io.IOException;
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
public class SubcategoriaController {
    
    SubcategoriaService subcategoriaDAO = new SubcategoriaService();
    CategoriaService categoriaDAO = new CategoriaService();
    
    @RequestMapping(value = "admin/subcategoriaList", method = RequestMethod.GET)
    public String CategoriaList(ModelMap model) {
        String titulo = "Lista de subcategorias";
        List<Subcategoria> subcategorias = subcategoriaDAO.getAll();
        model.addAttribute("subcategorias", subcategorias);
        model.addAttribute("titulo", titulo);
        return "admin/subcategoriaList";
    }
    
    @RequestMapping(value = "admin/subcategoriaEdit.html",method = RequestMethod.GET)
    public String SubcategoriaEdit(ModelMap model, HttpServletRequest request){
        String titulo = "Editar Subcategoria";
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        Subcategoria subcategoria = subcategoriaDAO.getbyID(id);
        List<Categoria> categorias = categoriaDAO.getAll();
        model.addAttribute("command",subcategoria);
        model.addAttribute("categorias",categorias);
        model.addAttribute("titulo",titulo);
        return "admin/subcategoriaEdit";
    }
    
    @RequestMapping(value = "admin/subcategoriaEdit.html",method = RequestMethod.POST)
    public void SubcategoriaEdit(HttpServletRequest request, HttpServletResponse response){
        String idCategoriaString = request.getParameter("categoria");
        Categoria categoria = categoriaDAO.getbyID(Integer.parseInt(idCategoriaString));
        Subcategoria subcategoria = subcategoriaDAO.getbyID(Integer.parseInt(request.getParameter("id")));
//        SubcategoriaId id = new SubcategoriaId(Integer.parseInt(request.getParameter("id")), Integer.parseInt(idCategoriaString));
        subcategoria.setNombresubcategoria(request.getParameter("nombresubcategoria"));
        subcategoria.setCategoria(categoria);
        subcategoriaDAO.update(subcategoria);
        try {
            response.sendRedirect("admin/subcategoriaList.html");
        } catch (IOException ex) {
            Logger.getLogger(SubcategoriaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(value = "admin/subcategoriaAdd", method = RequestMethod.GET)
    public String SubcategoriaAdd(ModelMap model){
        String titulo = "Agregar nueva subcategoria";
        Subcategoria subcategoria = new Subcategoria();
        List<Categoria> categorias = categoriaDAO.getAll();
        model.addAttribute("command",subcategoria);
        model.addAttribute("categorias",categorias);
        model.addAttribute("titulo", titulo);
        return "admin/subcategoriaAdd";
    }
    
    @RequestMapping(value = "admin/subcategoriaAdd.html", method = RequestMethod.POST)
    public void SubcategoriaAdd(HttpServletRequest request, HttpServletResponse response) {
        Subcategoria subcategoria = new Subcategoria();
        String idCategoriaString = request.getParameter("categoria");
        Categoria categoria = categoriaDAO.getbyID(Integer.parseInt(idCategoriaString));
        subcategoria.setNombresubcategoria(request.getParameter("nombresubcategoria"));
        subcategoria.setCategoria(categoria);
        subcategoriaDAO.add(subcategoria);
        try {
            response.sendRedirect("admin/subcategoriaList.html");
        } catch (IOException ex) {
            Logger.getLogger(SubcategoriaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(value = "admin/subcategoriaDelete",method = RequestMethod.GET)
    public String SubcategoriaDelete(ModelMap model, HttpServletRequest request) {
        String titulo = "Seguro desea eliminar";
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        Subcategoria subcategoria = subcategoriaDAO.getbyID(id);
        model.addAttribute("titulo",titulo);
        model.addAttribute("command",subcategoria);
        return "admin/subcategoriaDelete";
    }
    
    @RequestMapping(value = "admin/subcategoriaDelete.html",method = RequestMethod.POST)
    public void SubcategoriaDelete(HttpServletRequest request, HttpServletResponse response) {
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        subcategoriaDAO.delete(id);
        try {
            response.sendRedirect("admin/subcategoriaList.html");
        } catch (IOException ex) {
            Logger.getLogger(SubcategoriaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    @RequestMapping(value = "admin/subcategoriaByCategoria")
    public String SubcategoriaByCategoria(ModelMap model, HttpServletRequest request){
        List<Subcategoria> subcategorias = subcategoriaDAO.getByCategoria(Integer.parseInt(request.getParameter("id")));
        model.addAttribute("subcategorias",subcategorias);
        return "admin/subcategoriaByCategoria";
    }
    
}
