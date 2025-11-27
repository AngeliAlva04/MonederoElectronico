package com.stcm.app_web.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(unique = true, nullable = false)
    private String nombre_usuario;

    @Column(nullable = false)
    private String contraseña;

    // @Column(nullable = false)
    // private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Ya que aun no hay roles devolvera una lita vacia
        return java.util.Collections.emptyList();
        // Cuando se implementen los roles devolvera una lista con los roles del usuario
        // return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return contraseña;
    }

    @Override
    public String getUsername() {
        return nombre_usuario;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}