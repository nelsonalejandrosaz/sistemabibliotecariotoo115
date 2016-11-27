/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.too115.sistemabibliotecariomaven.configuration;

import com.ues.too115.sistemabibliotecariomaven.models.Usuario;
import com.ues.too115.sistemabibliotecariomaven.service.UsuarioService;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nelson Alejandro Saz <nelsonalejandrosaz@gmail.com>
 */

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    
    UsuarioService usuarioService = new UsuarioService();

    public UserDetails loadUserByUsername(String usuarioNombre) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getByUser(usuarioNombre);
        if (usuario == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        User user = new User(usuario.getUsuario(), usuario.getPassword(), authorities);
        return user;
    }
    
}
