package com.ExamenParcialSanchez.ExamenParcial.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Alumno")
public class AlumnoModel {

     @Id
    @Column(name = "id")
    public Integer idAlumno;

    @Column(name = "nombre")
    public String nombre;

    @Column(name = "nota")
    public Double nota;


    // Getters and Setters
    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getNota() {
        return nota;
    }
    public void setNota(Double nota) {
        this.nota = nota;
    }

    
}
