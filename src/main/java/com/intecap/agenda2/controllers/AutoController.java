package com.intecap.agenda2.controllers;


import com.intecap.agenda2.models.Alumno;
import com.intecap.agenda2.models.Auto;
import com.intecap.agenda2.repositories.AutoRepository;
import com.intecap.agenda2.services.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.PushBuilder;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class AutoController {
    @Autowired

    AutoService autoService;

    @GetMapping("/autos")
    public ArrayList<Auto> obtenerAuto(){
        return autoService.obtenerAuto();
    }

    @PostMapping("/autos")
    public Auto guardarAuto(@RequestBody Auto auto){
        return autoService.guardarAuto(auto);
    }

    @GetMapping("/autos/{id}")
    public Auto buscarAuto(@PathVariable("id") Long id){
        return autoService.buscarAuto(id);
    }

    @PutMapping("/autos/{id}")
    public Auto actualizarAuto(@RequestBody Auto auto, @PathVariable("id") Long id){
        Auto autoEncontrado = autoService.buscarAuto(id);
        autoEncontrado.setModelo(auto.getModelo());
        autoEncontrado.setColor(auto.getColor());
        autoEncontrado.setPlaca(auto.getPlaca());
        autoEncontrado.setAnio(auto.getAnio());
        return autoService.actualizarAuto(autoEncontrado);
    }

    @DeleteMapping("/autos/{id}")
    public String elimnarAuto(@PathVariable("id") Long id){
        boolean ok = autoService.eliminarAuto(id);
        if(ok){
            return "Se elimino el alumno con id: " + id;
        }else {
            return "No se pudo eliminar el alumno con id: " + id;
        }
    }


}
