/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.too115.sistemabibliotecariomaven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Nelson Alejandro Saz <nelsonalejandrosaz@gmail.com>
 */
@Controller
public class AdminController {
    
    @RequestMapping(value = "adminIndex")
    public String AdminIndex(ModelMap model) {
        String titulo = "Bienvenido administrador";
        model.addAttribute("titulo",titulo);
        return "admin/adminIndex";
    }
    
}
