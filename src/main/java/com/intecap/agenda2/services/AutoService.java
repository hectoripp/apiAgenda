package com.intecap.agenda2.services;

import com.intecap.agenda2.models.Alumno;
import com.intecap.agenda2.models.Auto;
import com.intecap.agenda2.models.Auto;
import com.intecap.agenda2.repositories.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Service
public class AutoService {
    @Autowired
    AutoRepository autoRepository;

    public ArrayList<Auto> obtenerAuto(){
        return (ArrayList<Auto>) autoRepository.findAll();
    }

    public Auto guardarAuto(Auto auto){
        return autoRepository.save(auto);
    }

    public Auto buscarAuto(Long id){
        return autoRepository.findById(id).orElse(null);
    }

    public Auto actualizarAuto(Auto auto  ){
        return autoRepository.save(auto);
    }

    public boolean eliminarAuto(Long id){
        try{
            autoRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }

}
