package com.stcm.app_web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stcm.app_web.entity.Usuario;
import com.stcm.app_web.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        System.out.println("Buscando usuario: " + nombreUsuario);
        System.out.println("UserRepository inyectado: " + (userRepository != null) + ", contiene: " + userRepository.findAll().size() + " usuarios.\n\n\n");
        return userRepository.findByNombre_usuario(nombreUsuario)
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado " + nombreUsuario));
    }

    @Transactional
    public void saveUser(Usuario usuario) {
        usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña()));
        userRepository.save(usuario);
        System.out.println("Usuario guardado: " + usuario.getNombre_usuario());
    }

    @Transactional
    public void createUser(String nombreUsuario, String contraseña) {
        Usuario usuario = new Usuario();
        usuario.setNombre_usuario(nombreUsuario);
        usuario.setContraseña(contraseña); // Se encriptará en saveUser
        saveUser(usuario);
    }

    public boolean userExists(String nombreUsuario) {
        return userRepository.findByNombre_usuario(nombreUsuario).isPresent();
    }
}