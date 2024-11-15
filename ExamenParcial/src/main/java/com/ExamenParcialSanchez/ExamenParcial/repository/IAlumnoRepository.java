package com.ExamenParcialSanchez.ExamenParcial.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ExamenParcialSanchez.ExamenParcial.model.AlumnoModel;


    @Repository
public interface IAlumnoRepository
        extends CrudRepository<AlumnoModel, Integer> {

}

