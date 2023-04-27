package com.intecap.agenda2.repositories;

import com.intecap.agenda2.models.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Long> {
/*
    @Autowired
    AlumnoRepository alumnoRepository;

    public ArrayList<Alumno> obtenerAlumnos(){
        return (ArrayList<Alumno>) alumnoRepository.findAll();
    };

    public Alumno guardarAlumno(Alumno alumno){
        return alumnoRepository.save(alumno);
    }

    */
}
