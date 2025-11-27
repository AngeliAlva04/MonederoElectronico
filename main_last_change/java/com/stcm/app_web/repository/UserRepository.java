package com.stcm.app_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stcm.app_web.entity.Usuario;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT u FROM Usuario u WHERE u.nombre_usuario = :nombreUsuario")
    Optional<Usuario> findByNombre_usuario(@Param("nombreUsuario") String nombreUsuario);
}