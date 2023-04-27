package com.intecap.agenda2.controllers;

import com.intecap.agenda2.models.Alumno;
import com.intecap.agenda2.repositories.AlumnoRepository;
import com.intecap.agenda2.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;



@CrossOrigin (origins = {"*", "http://localhost:3001", "http://localhost:3000"})
// se coloca * para que cualquiera puda consumirlo, pero si no se coloca el localhost
// de la herramienta que se utilizara, en este caso sera REACT

@RestController
@RequestMapping("/api/v1")
public class AlumnoController {
    @Autowired
    //AlumnoRepository alumnoRepository;
    AlumnoService alumnoService;

    @GetMapping("/alumnos")
    public ArrayList<Alumno> obtenerAlumnos(){
        return alumnoService.obtenerAlumnos();
    }


    @PostMapping("/alumnos")
    public Alumno guardarAlumno(@RequestBody Alumno alumno){
        return alumnoService.guardarAlumnos(alumno);
    }

    @GetMapping("/alumnos/{id}")
    public Alumno buscarAlumno(@PathVariable("id") Long id){
        return alumnoService.buscarAlumnos(id);
    }

    @PostMapping("/alumnos/{id}")
    public Alumno actualizarAlumno(@RequestBody Alumno alumno, @PathVariable("id") long id){
        Alumno alumnoEncontrado = alumnoService.buscarAlumnos(id);
        alumnoEncontrado.setNombre(alumno.getNombre());
        alumnoEncontrado.setEdad(alumno.getEdad());
        alumnoEncontrado.setCorreo(alumno.getCorreo());
        alumnoEncontrado.setTelefono(alumno.getTelefono());
        return alumnoService.actualizarAlumnos(alumnoEncontrado);
    }

    @DeleteMapping("/alumnos/{id}")
    public String eliminarAlumno(@PathVariable("id") Long id){
        boolean ok = alumnoService.eliminarAlumno(id);
        if(ok){
            return "Se eliminó el alumno con id " + id;
        }else{
            return "No se pudo eliminar el alumno con id " + id;
        }
    }

}
