package com.stcm.app_web.repository;

import java.time.LocalDate;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.stcm.app_web.entity.Persona;

@Repository
public interface PersonRepository extends JpaRepository<Persona, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO personas (nombre, apellidos, fecha_nacimiento, curp) VALUES (:nombre, :apellidos, :fechaNacimiento, :curp)", nativeQuery = true)
    void savePersona(@Param("nombre") String nombre,
            @Param("apellidos") String apellidos,
            @Param("fechaNacimiento") LocalDate fechaNacimiento,
            @Param("curp") String curp);
}