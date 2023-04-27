package com.intecap.agenda2.services;

import com.intecap.agenda2.models.Alumno;
import com.intecap.agenda2.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AlumnoService {
    @Autowired
    AlumnoRepository alumnoRepository; //Inyeccion de dependencias, se crea una instancia de AlumnoRepository
    //AlumnoService alumnoService;
    public ArrayList <Alumno> obtenerAlumnos(){
        //return (ArrayList<Alumno>) alumnoService.findAll();
        return (ArrayList<Alumno>) alumnoRepository.findAll();
    }

    public Alumno guardarAlumnos(Alumno alumno){
        return alumnoRepository.save(alumno);
    }

    public Alumno buscarAlumnos(Long id){
        return  alumnoRepository.findById(id).orElse(null);
        //return alumnoRepository.findAllById(id).orElse(null);
    }

    public Alumno actualizarAlumnos(Alumno alumno){
        return alumnoRepository.save(alumno);
    }

    public boolean eliminarAlumno(Long id){
        try{
            alumnoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


/*
    public Alumno guardarAlumno(Alumno alumno){
        return alumnoService.save(alumno);
    }

*/
    /*
    public AlumnoService(AlumnoRepository alumnoRepository){
        this.alumnoRepository = alumnoRepository;
    }
    */

}
