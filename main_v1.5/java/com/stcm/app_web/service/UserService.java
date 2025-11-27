package com.stcm.app_web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException; // <-- añadir
import com.stcm.app_web.repository.UserRepository; // <-- añadir

@Service
public class UserService implements UserDetailsService {
    // Lógica del servicio de usuario (si es necesario)
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        System.out.println("Buscando usuario: " + nombreUsuario);
        System.out.println("UserRepository inyectado: " + (userRepository != null)+", contiene: " + userRepository.findAll().size() + " usuarios."+"\n\n\n");
        return userRepository.findByNombre_usuario(nombreUsuario)
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado " + nombreUsuario));
    }

}